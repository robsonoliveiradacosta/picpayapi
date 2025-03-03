FROM maven:3.9.9-eclipse-temurin-21-alpine AS  build
COPY ./src /usr/src/app/src
COPY ./pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn package

FROM registry.access.redhat.com/ubi8/openjdk-21-runtime:1.21
## We make four distinct layers so if there are application changes the library layers can be re-used
COPY --from=build --chown=185 /usr/src/app/target/quarkus-app/lib/ /deployments/lib/
COPY --from=build --chown=185 /usr/src/app/target/quarkus-app/*.jar /deployments/
COPY --from=build --chown=185 /usr/src/app/target/quarkus-app/app/ /deployments/app/
COPY --from=build --chown=185 /usr/src/app/target/quarkus-app/quarkus/ /deployments/quarkus/
EXPOSE 8080
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"
ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]