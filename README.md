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
CREATE USER 'nazran'@'%' IDENTIFIED BY 'password';
```
```sql
GRANT ALL PRIVILEGES ON * . * TO 'nazran'@'%';
```
```bash
exit
```
- login with previous username & password
```bash
sudo mysql -u nazran -p
```
```sql
CREATE DATABASE wds;
```
```bash
exit
```

