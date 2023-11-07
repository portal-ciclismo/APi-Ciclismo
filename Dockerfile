FROM eclipse-temurin:17
WORKDIR /app
COPY target/Api-Ciclismo-1.0.0.jar Api-Ciclismo-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "Api-Ciclismo-1.0.0.jar"]