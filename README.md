# ToDo list project


##Project setup

**docker-compose.yml**
```
version: '3'
services:
    mongodb:
        image: mongo:4.2.15
        container_name: mongodb
        hostname: mongodb
        volumes:
        #    - ./mongodb/mongod.conf:/etc/mongod.conf
        #    - ./mongodb/initdb.d/:/docker-entrypoint-initdb.d/
            - ./mongodb/data/db/:/data/db/
            - ./mongodb/data/log/:/var/log/mongodb/
        #env_file:
        #    - .env
        #environment:
            #MONGO_INITDB_ROOT_USERNAME: ${MONGO_INITDB_ROOT_USERNAME}
            #MONGO_INITDB_ROOT_PASSWORD: ${MONGO_INITDB_ROOT_PASSWORD}
            #MONGO_INITDB_DATABASE: ${MONGO_INITDB_DATABASE}
        ports:
            - "27017:27017"
```