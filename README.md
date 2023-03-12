# Hype-BE

![image](https://user-images.githubusercontent.com/55437339/224282395-db603b34-a337-453b-beb9-58d27c16085b.png)

잘 알려지지 않은 숨은 명곡을 공유하고 대결과 투표를 통해 더 좋은 곡을 알아가는 서비스

<br/>

### 🛠 Used Stacks

| <img width="80" height="80" src="https://user-images.githubusercontent.com/55437339/224531454-65f005e4-ece5-4796-81fa-d28cd75f74a7.png"> | <img width="100" height="80" src="https://user-images.githubusercontent.com/55437339/224531494-171c8e4d-3326-48c3-88f9-8205425e07ba.png"> | <code><img height="80" src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png" alt="Spring Boot" title="Spring Boot" /></code> | <img width="120" height="80" src="https://user-images.githubusercontent.com/55437339/224531530-d53418df-c62f-4f72-841f-3739b9a9746d.png"> | <code><img height="80" src="https://user-images.githubusercontent.com/25181517/183896128-ec99105a-ec1a-4d85-b08b-1aa1620b2046.png" alt="MySQL" title="MySQL" /></code>   |
|------|---------------------------------------------------------------|------------------------------------------|------------------------------------------------------------|------------------------------------------------------------|
| Java 17                                                    | Gradle                                                        | SpringBoot 2.7.7                              | Spring Data JPA                                            | MySQL 8.0 |

<br/>


## 👥 팀원

| [이수영](https://github.com/twotwobread)| [김소현](https://github.com/thguss)| [박세준](https://github.com/park-se-jun)|
|:-----:|:------:|:------------:|
| <img width="120" height="120" src="https://user-images.githubusercontent.com/55437339/224531862-cad9bcfa-4803-4e0c-9128-f00d160751df.png"> | <img width="120" height="120" src="https://user-images.githubusercontent.com/55437339/224531882-ed4bb72a-5684-4981-8eb8-63fe0a7ef343.png"> | <img width="120" height="120" src="https://user-images.githubusercontent.com/55437339/224531901-d14145a6-9ab8-474c-a60f-d4eba2593c5f.png"> |
|백엔드 개발| 백엔드 개발| 백엔드 개발|


| 멘토 | 서브멘토 |
|--------|------------|
| [마르코](https://github.com/ksy90101) | [김명환](https://github.com/samkimuel) |

<br/>

## 📏 Code Convention
[Naver 코드 컨벤션](https://naver.github.io/hackday-conventions-java/) + CheckStyle 적용

<br/>

## 🌴 Commit Convention
| 태그 이름 | 설명 |
| --- | --- |
| [CHORE] | 로직과 상관없는 잡다한 작업 ( resource 추가, yml 추가 등 ) |
| [FIX] | 코드 수정 |
| [FEAT] | 새로운 기능 구현 |
| [ADD] | 코드 추가 |
| [HOTFIX] | 급한 사항 |
| [DEL] | 코드 삭제 |
| [DOCS] | README 등의 문서 개정 |
| [REFACTOR] | 파일 이름 변경, 구조 변경 등의 전면 수정 |
| [TEST] | 테스트 코드 |

<br/>

## ✨ Branch Strategy
**git 전략 - git flow 전략**
- `main` : 초기 프로젝트 설정 브랜치
- `develop` : 개발(작업) 브랜치: 해당 브랜치로 push 할 경우 CD
- `이름_#이슈번호` : 이슈별 개발 브랜치
- `이름` : 개인 작업 브랜치


<br/>

## 📃 API 명세서 초안
[API 명세서 Notion](https://carnation-hearing-eb3.notion.site/API-d7387bba98474e63a5085843188e537f )

## 📃 API 명세서
[API 명세서 Swagger](https://hype.n-e.kr/docs/index.html)

<br/>

## 🥫 ERD

<br/>

## 🗂 프로젝트 폴더 구조

```
MVC 기반

📁 src
|_ 📁 main
|_ |_ 📁 common
|_ |_ 📁 config
|_ |_ 📁 constrant
|_ |_ 📁 controller
|_ |_ 📁 dto
|_ |_ 📁 exception
|_ |_ 📁 model
|_ |_ 📁 repository
|_ |_ 📁 services
|_ |_ 📁 util
|_ 📁 test

```

<br/>

## 🌴 Dependencies Module
<b>build.gradle</b>
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-data-redis'
    implementation 'org.springframework.boot:spring-boot-starter-data-redis-reactive'
    implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.cloud:spring-cloud-starter:3.1.5'
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.flywaydb:flyway-mysql'
    implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
    implementation 'io.jsonwebtoken:jjwt:0.9.1'
    implementation 'org.redisson:redisson-spring-boot-starter:3.18.0'

    testImplementation 'org.projectlombok:lombok:1.18.22'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.h2database:h2'
    runtimeOnly 'com.mysql:mysql-connector-j'
    annotationProcessor 'org.projectlombok:lombok'
    testAnnotationProcessor 'org.projectlombok:lombok'
    annotationProcessor "org.springframework.boot:spring-boot-configuration-processor"

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'io.projectreactor:reactor-test'
    testImplementation 'org.springframework.security:spring-security-test'
    testImplementation 'org.testcontainers:junit-jupiter'
    testImplementation 'org.testcontainers:mysql'
    testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'
    testImplementation 'com.epages:restdocs-api-spec-mockmvc:0.16.4'
    testImplementation "org.junit.jupiter:junit-jupiter-params"
    testImplementation 'io.findify:s3mock_2.13:0.2.6'
    implementation 'com.google.guava:guava:31.1-jre'
    swaggerUI 'org.webjars:swagger-ui:4.1.3'

    implementation "ca.pjer:logback-awslogs-appender:1.6.0"
    implementation 'com.amazonaws:aws-java-sdk-bom:1.12.417'
    implementation 'com.amazonaws:aws-java-sdk-s3:1.12.410'
}

```

<br/>

## 🏗 Architecture

