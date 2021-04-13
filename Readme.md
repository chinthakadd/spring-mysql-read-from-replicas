## Before Running 

- Go to `mysql-master-slave` folder in this Repository.
- Run `build.sh` which will start the MySql Leader and a Follower
- Then run to create `code` table

```sh
docker exec mysql_master sh -c "export MYSQL_PWD=111; mysql -u root mydb -e 'create table code(code int)'"
```

## Curl Commands for Two APIs

Generation of Random Codes:

```sh
curl --location --request POST 'http://localhost:8080/code'
```

Get Codes (uses the Read Replica)

```sh
curl --location --request GET 'http://localhost:8080/code'
```

## Useful Links

- https://vladmihalcea.com/read-write-read-only-transaction-routing-spring/
- https://stackoverflow.com/questions/51513447/is-hibernate-transactionalreadonly-true-on-read-query-a-bad-practice
- https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/
- https://vladmihalcea.com/why-you-should-always-use-hibernate-connection-provider_disables_autocommit-for-resource-local-jpa-transactions/