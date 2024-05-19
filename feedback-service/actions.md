```shell
#Запуск Mongo
docker run --name feedback-db -p 27017:27017 mongo:7

#доступ к БД
docker exec -it feedback-db mongosh feedback
````

