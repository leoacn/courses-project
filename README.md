## Description

Simple skeleton to microservices approach

## How to test?

Package

```shell
mvn clean package
```

### Run individual modules

- Courses Registration Service

```shell
mvn clean spring-boot:run -pl courses-registration
```

- Courses Search Service

```shell
mvn clean spring-boot:run -pl courses-search
```

- Courses view module

```shell
mvn clean spring-boot:run -pl courses-view
```

### Build & register docker images (pending)

```shell
mvn clean package spring-boot:build-image
```

### Run with Docker-compose (pending)

```shell
docker-compose up -d
```

### Payload

```json
{
  "metadata": {},
  "data": {
  }
}
```
