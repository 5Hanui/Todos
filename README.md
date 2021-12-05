# Todo

열정팩토리 개발 과제로 제작한 spring boot 프로젝트 입니다.

# 개발 환경 및 사용 버전

- IDE : IntelliJ IDEA Ultimate
- OS: Window
- JAVA 11
- Spring boot 2.6.1
- Gradle
- Spring Data JPA

# 실행 하기
1. jar 만들기  
프로젝트 위치로 이동
```
gradlew bootJar
```
2. /build/libs/  
jar파일 확인  

> dev 환경에서 실행
```
java -jar -Dspring.profiles.active=dev {jar파일}
```

> prod 환경에서 실행
```
java -jar -Dspring.profiles.active=prod {jar파일}
```
