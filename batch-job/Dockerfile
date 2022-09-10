FROM maven:3.8-openjdk-17
# WORKDIR /batch-job
# COPY . .
# RUN mvn clean package
# CMD mvn spring-boot:run
ADD target/batch-0.0.1-SNAPSHOT.jar batch-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "batch-0.0.1-SNAPSHOT.jar" ]