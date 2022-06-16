FROM adoptopenjdk:11-jre-hotspot
COPY /build/libs/Book-0.0.1-SNAPSHOT.jar /build/libs/
ENTRYPOINT ["java", "-jar", "/build/libs/Book-0.0.1-SNAPSHOT.jar"]
