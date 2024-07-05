# Database (MySQL) preparation
```bash
brew install mysql
brew services start mysql
```
```sql
CREATE USER 'nazran'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'nazran'@'%';
```

