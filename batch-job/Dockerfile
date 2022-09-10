FROM maven:3.8-openjdk-17
RUN mkdir "/batch-job-app"
ADD target/batch-0.0.1-SNAPSHOT.jar batch-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "batch-0.0.1-SNAPSHOT.jar" ]