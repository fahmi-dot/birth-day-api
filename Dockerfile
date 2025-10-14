FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY pom.xml ./

RUN ./mvnw dependency:go-offline || true

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/birth-day-api-0.0.1-SNAPSHOT.jar"]