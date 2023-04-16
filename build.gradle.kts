plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    testImplementation("io.rest-assured:rest-assured:5.3.0")
    implementation("io.rest-assured:rest-assured:5.3.0")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    testImplementation("com.fasterxml.jackson.core:jackson-core:2.6.0-rc1")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.6.0")
    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    testImplementation("com.googlecode.json-simple:json-simple:1.1")
}

tasks.test {
    useJUnitPlatform()
}