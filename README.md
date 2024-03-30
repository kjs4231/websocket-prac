## 사용한 Dependency

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-websocket'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'com.mysql:mysql-connector-java'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}


application.properties에 아래 설정을 추가하면 좀 더 세밀한 디버깅 받을수 있다고 하네요.
logging.level.org.springframework.web=DEBUG
logging.level.org.springframework.messaging=DEBUG
