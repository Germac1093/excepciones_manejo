# first stage: Building
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app
COPY . .
# Building the app without run tests
RUN ./mvnw clean package -DskipTests

# stage 2: running
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Only the earlier generated jar
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]