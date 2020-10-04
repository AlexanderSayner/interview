plugins {
    java
}

group = "org.sayner.sandbox.interview.concurrency"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    testImplementation("junit", "junit", "4.12")
}
