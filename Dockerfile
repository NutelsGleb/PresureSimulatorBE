FROM openjdk:17-jdk-slim
WORKDIR /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline
RUN mvn -N io.takari:maven:wrapper
COPY src ./src
RUN ./mvnw clean package -DskipTests
ENTRYPOINT ["java", "-jar", "target/nutels.presuresimulator.be-1.0.jar"]
