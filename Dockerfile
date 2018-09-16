FROM openjdk:8
VOLUME /tmp
ADD build/libs/similarityfinder-0.0.1-SNAPSHOT.jar similarity-finder.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "similarity-finder.jar"]
