plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":jooq-generated"))
    implementation("org.jetbrains:annotations:23.0.0")

    implementation("org.eclipse.jetty:jetty-server:11.0.12")
    implementation("org.eclipse.jetty:jetty-servlet:11.0.12")

    implementation("com.google.code.gson:gson:2.10")



}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}