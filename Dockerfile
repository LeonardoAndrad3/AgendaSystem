FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/agenda-0.0.1-SNAPSHOT.jar agenda.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "agenda.jar"]

#
#COPY src ./src
#COPY pom.xml ./
#
#RUN mvn clean install