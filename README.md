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
```bash
exit
```
- Login with previous username & password
```bash
sudo mysql -u nazran -p
```
```bash
mysql> CREATE DATABASE wsd;
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
sudo mysql -u root -p
```
- Then provide the auto generated password to login and after change ethe password
```bash
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '[newpassword]';
```
```bash
mysql> CREATE DATABASE wsd;
```