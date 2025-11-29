FROM eclipse-temurin:21.0.2_13-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21.0.2_13-jdk
WORKDIR /app
COPY --from=builder /app/target/RatingService-0.0.1-SNAPSHOT.jar RatingService.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "RatingService.jar"]