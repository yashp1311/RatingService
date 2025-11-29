FROM eclipse-temurin:21-jre-alpine@sha256:latest AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine@sha256:latest
WORKDIR /app
COPY --from=builder /app/target/RatingService-0.0.1-SNAPSHOT.jar RatingService.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "RatingService.jar"]