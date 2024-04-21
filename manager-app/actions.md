__*БД для пользователей менеджерского приложения:*__
```shell
docker run --name manager-db -p 5433:5432 -e POSTGRES_DB=manager -e POSTGRES_USER=manager -e POSTGRES_PASSWORD=manager postgres:16
```
