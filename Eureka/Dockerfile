FROM openjdk:17-jdk
EXPOSE 8761
ADD /target/Eureka-0.0.1-SNAPSHOT.jar.original EurekaServer.jar
ENTRYPOINT ["EurekaServer.jar"]