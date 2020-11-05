FROM openjdk:11

WORKDIR /opt/server

COPY ./target/smkt-files-1.0.0.jar ./app.jar

EXPOSE 4050

CMD [ "java", "-jar", "./app.jar" ]
