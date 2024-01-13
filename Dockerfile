
FROM openjdk:17 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR customer-product
COPY --from=build target/*.jar customer-order.jar
ENTRYPOINT ["java", "-jar", "customer-order.jar"]
