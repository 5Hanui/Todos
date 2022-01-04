# Todo

개발 과제로 제작한 spring boot 프로젝트 입니다.

# 개발 환경 및 사용 버전

- IDE : IntelliJ IDEA Ultimate
- OS: Windows
- JAVA 11
- Spring boot 2.6.1
- Gradle
- Spring Data JPA
- H2 Database

# DB setting
![image](https://user-images.githubusercontent.com/22045436/144750523-ed8b3b6b-775f-4fe5-887c-1e8d04c34a55.png)


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
---------------------------------------------------
# 로컬 환경에서 실행하기
![image](https://user-images.githubusercontent.com/22045436/144747970-cce8b179-960b-4444-8be8-84a57ea9ea6b.png)

Active profiles: dev/prod 실행환경 
