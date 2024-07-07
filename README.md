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
```sql
CREATE USER <username>@'%' IDENTIFIED BY <password>;
```
```sql
GRANT ALL PRIVILEGES ON * . * TO 'nazran'@'%';
```
```bash
exit
```
- Login with previous username & password
```bash
sudo mysql -u nazran -p
```
```sql
CREATE DATABASE wsd;
```
```bash
exit
```
# Connect Database (MySQL)
- Update the `application.yml` credentials
```bash
    url: jdbc:mysql://localhost:3306/wsd?trustServerCertificate=true;
    username: <username>
    password: <password>
```
# Run the application
- Check on `http://localhost:1991/swagger-ui/index.html` on browser if started application properly



