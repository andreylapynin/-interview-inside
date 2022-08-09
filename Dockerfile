FROM maven:3.8.4-openjdk-11 as builder
WORKDIR /app
COPY . /app
RUN mvn package
FROM openjdk:11
COPY --from=builder /app/target/*.war interview-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "interview-0.0.1-SNAPSHOT.war"]