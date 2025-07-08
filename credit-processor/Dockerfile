FROM bellsoft/liberica-openjre-alpine:21-cds

WORKDIR /application

COPY --chown=spring-user:spring-user target/credit-processor-1.0.0.jar app.jar

RUN adduser -S spring-user
USER spring-user

EXPOSE 8080

ENV JAVA_OPTS="-XX:ErrorFile=/tmp/java_error.log \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:HeapDumpPath=/tmp \
    -XX:+CrashOnOutOfMemoryError \
    -XX:+UseContainerSupport \
    -XX:MaxRAMPercentage=75"

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar