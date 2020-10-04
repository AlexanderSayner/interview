plugins {
    java
    application
    id("org.springframework.boot") version "2.3.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "org.sayner.sandbox.interview.core"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    implementation(project(":concurrency"))
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("junit", "junit", "4.12")
}

application {
    mainClassName = "org.sayner.sandbox.interview.core.Application"
    applicationDefaultJvmArgs = mutableListOf("-ea")
}
