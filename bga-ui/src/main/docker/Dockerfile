FROM anapsix/alpine-java:8
MAINTAINER ODRIN7 <sz.danix6@gmail.com>
VOLUME /tmp
ADD bga-ui-1.0.0.jar app.jar
ADD wait-for-service.sh wait-for-service.sh
RUN bash -c 'touch /app.jar'
RUN bash -c 'touch /wait-for-service.sh'
RUN bash -c 'chmod +x /wait-for-service.sh'
RUN apk --no-cache add curl
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
