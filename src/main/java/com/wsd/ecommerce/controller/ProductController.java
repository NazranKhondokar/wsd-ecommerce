package com.wsd.ecommerce.controller;

import com.wsd.ecommerce.projection.MaxSaleDayProjection;
import com.wsd.ecommerce.projection.ProductDetailProjection;
import com.wsd.ecommerce.service.ProductService;
import com.wsd.ecommerce.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.wsd.ecommerce.util.ResponseBuilder.error;
import static com.wsd.ecommerce.util.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
@Tag(name = "Product API")
public class ProductController {

    private final ProductService service;

    @GetMapping("/top-items")
    @Operation(summary = "show top 5 selling items of all time (based on total sale amount).")
    @ApiResponse(content = {@Content(schema = @Schema(implementation = ProductDetailProjection.class))})
    public ResponseEntity<JSONObject> list() {
        return ok(success(service.getTopItems()).getJson());
    }

    @GetMapping("/last-month-top-items")
    @Operation(summary = "show top 5 selling items of the last month (based on number of sales).")
    @ApiResponse(content = {@Content(schema = @Schema(implementation = ProductDetailProjection.class))})
    public ResponseEntity<JSONObject> lastMonthList() {
        return ok(success(service.getLastMonthTopItems()).getJson());
    }

    @GetMapping("/max-sale-day")
    @Operation(summary = "the max sale day of a certain time range.")
    @ApiResponse(content = {@Content(schema = @Schema(implementation = MaxSaleDayProjection.class))})
    public ResponseEntity<JSONObject> getMaxSaleDay(@RequestParam(value = "start", defaultValue = "") String start,
                                                    @RequestParam(value = "end", defaultValue = "") String end) {
        if (start.isEmpty()) return badRequest().body(error(HttpStatus.NOT_ACCEPTABLE, "Please provide start date").getJson());
        if (end.isEmpty()) return badRequest().body(error(HttpStatus.NOT_ACCEPTABLE, "Please provide end date").getJson());
        return ok(success(service.getMaxSaleDay(start, end)).getJson());
    }
}
