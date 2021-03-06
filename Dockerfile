FROM maven:3-openjdk-11 as build

WORKDIR /opt/build

COPY . .

RUN mvn clean compile install

RUN mv ./target/smkt-files-2.0.0.jar /app.jar

FROM openjdk:11

WORKDIR /opt/server

COPY --from=build /app.jar  ./app.jar

ARG port=4050
ARG eureka_url=http://smkt-eureka:8761/eureka

ENV PORT ${port}
ENV EUREKA_URL ${eureka_url}

EXPOSE ${PORT}

CMD java -jar app.jar --server.port="${PORT}" --eureka.client.service-url.defaultZone="${EUREKA_URL}"

