FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

USER root

RUN apk update
COPY . .
RUN sh mvnw clean package -DskipTests

CMD ["/app/wait-for-it.sh","sh","mvnw", "spring-boot:run"]
