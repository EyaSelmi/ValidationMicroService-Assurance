FROM openjdk:17-jdk
EXPOSE 8090
ADD /target/ClientService-0.0.1-SNAPSHOT.jar ClientService.jar
ENTRYPOINT ["java","-jar","ClientService.jar"]