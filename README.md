# Versions
- `Spring Boot 3.2.2`
- `mysql  Ver 8.3.0`
- `Docker version 24.0.5`
- `gradle-8.8`
- `flyway-9.22.3`
- `lombok-1.18.30`

# Database (MySQL) preparation
```bash
brew install mysql
```
```bash
brew services start mysql
```
```bash
sudo mysql
```
```bash
mysql> CREATE USER <username>@'%' IDENTIFIED BY <password>;
```
```bash
mysql> GRANT ALL PRIVILEGES ON * . * TO 'nazran'@'%';
```
- Login with previous username & password
```bash
sudo mysql -u nazran -p
```
```bash
mysql> CREATE DATABASE wsd;
```
# Connect Database (MySQL)
- Update the `application.yml` credentials
```bash
    url: jdbc:mysql://localhost:3306/wsd?trustServerCertificate=true;
    username: <username>
    password: <password>
```
# Run the application
- Check `http://localhost:1991/swagger-ui/index.html` on browser if the application started  properly
- the wish list of a customer: `/customer-wish/list?page=1&size=10&customerId=18`
- the total sale amount of the current day: `/product/sale-day`
- the max sale day of a certain time range: `/product/max-sale-day?start=2024-06-01&end=2024-06-30`
- top 5 selling items of all time (based on total sale amount): `/product/top-items`
- top 5 selling items of the last month (based on number of sales): `/product/last-month-top-items`

# Database (MySQL) preparation in `docker`
```bash
sudo docker pull mysql/mysql-server:latest
```
```bash
sudo docker images
```
```bash
sudo docker run --name=[container_name] -d mysql/mysql-server:latest
```
```bash
docker ps
```
```bash
sudo apt-get install mysql-client
```
```bash
sudo docker logs [container_name]
```
- [Entrypoint] GENERATED ROOT PASSWORD: which will be needed
```bash
sudo docker exec -it [container_name] bash
```
```bash
mysql -u root -p
```
- Then provide the auto generated password to login and after change the password
```bash
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '[newpassword]';
```
```bash
mysql> CREATE DATABASE wsd;
```
- Update the `docker-compose.yml` credentials with `[container_name]`
```bash
  mysqldb:
    image: [container_name]
    restart: always
    ports:
      - 3306:3306
    networks:
      - springapimysql-net
    environment:
      MYSQL_DATABASE: wsd
      MYSQL_USER: <username>
      MYSQL_PASSWORD: <password>
      MYSQL_ROOT_PASSWORD: <password>
```
```bash
docker-compose up
```
