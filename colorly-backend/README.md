# Set-up

(This set-up was inspired by Felipe Girotti's StackOverflow answer -- https://stackoverflow.com/questions/35531661/using-env-variable-in-spring-boots-application-properties/53797683#53797683).

1. Create a MYSQL database by running `mysql` and executing `CREATE DATABASE colorly_db;`
2. Create a `.env` file with the Colorly database username and password:
```bash
# .env
SPRING_DATASOURCE_URL=jdbc:mysql://127.0.0.1:3306/colorly_db
SPRING_DATASOURCE_USERNAME=#some_username
SPRING_DATASOURCE_PASSWORD=#some_password
```
3. Load the environment variables by running
```bash
export $(cat .env | xargs)
```

# How to run

- To build and run:
```bash
mvn clean spring-boot:run
```
