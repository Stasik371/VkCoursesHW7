plugins {
    java
    `kotlin-dsl`
    application
    id("nu.studer.jooq") version "8.0" apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"
allprojects {
    repositories {
        mavenCentral()
        google()
    }
}
subprojects {
    apply {
        plugin("nu.studer.jooq")
        plugin("org.jetbrains.kotlin.jvm")
    }

    dependencies {
        implementation("org.flywaydb:flyway-core:9.8.1")
        implementation("org.postgresql:postgresql:42.5.0")
        implementation("org.jooq:jooq:3.17.5")
        implementation("org.jooq:jooq-codegen:3.17.5")
        implementation("org.jooq:jooq-meta:3.17.5")
        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    }


    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}