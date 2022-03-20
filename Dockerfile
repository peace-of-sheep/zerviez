FROM openjdk:8-jdk AS builder
RUN mkdir /app
WORKDIR /app
COPY ./build.gradle.kts ./settings.gradle.kts ./gradle.properties ./gradlew ./gradlew.bat ./
COPY ./gradle ./gradle/
RUN chmod +x ./gradlew
RUN ./gradlew build
COPY . .
RUN ./gradlew installDist

FROM openjdk:8-jdk
EXPOSE 8080:8080
RUN mkdir /app
COPY --from=builder /app/build/install/zerviez/ /app/
WORKDIR /app/bin
CMD ["./zerviez"]