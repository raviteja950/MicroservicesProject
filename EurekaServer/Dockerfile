FROM eclipse-temurin:17-jdk-alpine
COPY /target/*.jar  app.jar
EXPOSE  8971
ENTRYPOINT [ "java","-jar","app.jar" ]