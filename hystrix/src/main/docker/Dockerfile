FROM openjdk:11-jre-slim-sid

LABEL maintainer="Henrique Castro <henrique.castro@codeminer42.com>"
LABEL version="1.0"

EXPOSE 8083

COPY maven/*.jar histryx.jar

ENTRYPOINT [ "java" , "-Xms128m",  "-Xmx400m", "-jar", "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector", "histryx.jar", "--spring.profiles.active=docker"]