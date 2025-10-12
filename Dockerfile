# Gunakan base image Java 21 (sesuaikan jika kamu pakai versi lain)
FROM eclipse-temurin:21-jdk-alpine

# Set working directory di dalam container
WORKDIR /app

# Copy file pom.xml dan download dependencies lebih dulu (build caching)
COPY pom.xml ./
RUN ./mvnw dependency:go-offline || true

# Copy semua source code ke container
COPY . .

# Build aplikasi Spring Boot (hasil jar di target/)
RUN ./mvnw clean package -DskipTests

# Jalankan aplikasi
CMD ["java", "-jar", "target/birth-day-api-0.0.1-SNAPSHOT.jar"]
