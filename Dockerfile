FROM amazoncorretto:17.0.7
EXPOSE 8080
ADD target/sbonk8s-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]