package com.wsd.ecommerce.controller;


import com.wsd.ecommerce.dto.CustomerWishDTO;
import com.wsd.ecommerce.entity.CustomerWish;
import com.wsd.ecommerce.helper.CommonDataHelper;
import com.wsd.ecommerce.response.CustomerWishResponse;
import com.wsd.ecommerce.service.impl.CustomerWishServiceImpl;
import com.wsd.ecommerce.util.PaginatedResponse;
import com.wsd.ecommerce.validator.CustomerWishValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.wsd.ecommerce.constant.MessageConstants.CUSTOMER_WISH_SAVE;
import static com.wsd.ecommerce.constant.MessageConstants.CUSTOMER_WISH_UPDATE;
import static com.wsd.ecommerce.exception.ApiError.fieldError;
import static com.wsd.ecommerce.response.CustomerWishResponse.select;
import static com.wsd.ecommerce.util.ResponseBuilder.*;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer-wish")
@Tag(name = "Customer Wish API")
public class CustomerWishController {

    private final CustomerWishValidator customerWishValidator;
    private final CustomerWishServiceImpl service;
    private final CommonDataHelper commonDataHelper;

    @PostMapping("/save")
    @Operation(summary = "save customerWish", description = "save customerWish")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerWishResponse.class))
    })
    public ResponseEntity<JSONObject> save(@Valid @RequestBody CustomerWishDTO dto, BindingResult bindingResult) {

        ValidationUtils.invokeValidator(customerWishValidator, dto, bindingResult);
        if (bindingResult.hasErrors())
            return badRequest().body(error(fieldError(bindingResult)).getJson());

        CustomerWish customerWish = service.save(dto);
        return ok(success(select(customerWish), CUSTOMER_WISH_SAVE).getJson());
    }

    @PutMapping("/update")
    @Operation(summary = "update customerWish", description = "update customerWish")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerWishResponse.class))
    })
    public ResponseEntity<JSONObject> update(@Valid @RequestBody CustomerWishDTO dto, BindingResult bindingResult) {

        Optional<CustomerWish> customerWish = service.findById(dto.getId());
        if (customerWish.isEmpty())
            return badRequest().body(error(HttpStatus.NOT_FOUND, "CustomerWish not found with id: " + dto.getId()).getJson());

        ValidationUtils.invokeValidator(customerWishValidator, dto, bindingResult);
        if (bindingResult.hasErrors())
            return badRequest().body(error(fieldError(bindingResult)).getJson());

        CustomerWish updatedCustomerWish = service.update(customerWish.get(), dto);
        return ok(success(select(updatedCustomerWish), CUSTOMER_WISH_UPDATE).getJson());
    }

    @GetMapping("/list")
    @Operation(summary = "show lists of all customerWish", description = "show lists of all customerWish")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerWishResponse.class))
    })
    public ResponseEntity<JSONObject> lists(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                                            @RequestParam(value = "sortBy", defaultValue = "") String sortBy,
                                            @RequestParam(value = "search", defaultValue = "") String search
    ) {

        PaginatedResponse response = new PaginatedResponse();
        Map<String, Object> map = service.search(page, size, sortBy, search);
        List<CustomerWish> customerWishList = (List<CustomerWish>) map.get("lists");
        List<CustomerWishResponse> responses = customerWishList.stream().map(CustomerWishResponse::select).toList();
        commonDataHelper.getCommonData(page, size, map, response, responses);
        return ok(paginatedSuccess(response).getJson());
    }

    @GetMapping("/details/{id}")
    @Operation(summary = "find customerWish by id", description = "find customerWish by id")
    @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerWishResponse.class))
    })
    public ResponseEntity<JSONObject> details(@PathVariable Integer id) {

        Optional<CustomerWish> customerWish = service.findById(id);

        return customerWish.map(value -> ok(success(select(value)).getJson())).orElseGet(() ->
                badRequest().body(error(HttpStatus.NOT_FOUND, "CustomerWish not found with id: " + id).getJson()));
    }
}
