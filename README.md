# Production Boost
Based on the video on YouTube [Spring Boot—Production Boost
](https://www.youtube.com/watch?v=gMvAp_qGyyE) on SpringDeveloper Channel and SpringOne 2021 playlist.

### Test Structure

### How to run

### Build 
```shell
./gradlew bootJar
```

### Build Docker Image
By this command it is possible to build an image by a sort of useful features.
- [Spring Boot Gradle Plugin Reference Guid](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/)
- [Paketo Build Packs for Spring Boot](https://github.com/paketo-buildpacks/spring-boot)
```shell
./gradlew bootBuildImage
```
the result should be:
```text
Successfully built image 'docker.io/library/book-service-production-boost:0.0.1-SNAPSHOT'
```