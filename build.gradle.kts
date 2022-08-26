val arrowVersion by extra { "1.1.2" }

plugins {
    kotlin("jvm") version "1.6.20"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.arrow-kt:arrow-core:$arrowVersion")

    testImplementation("io.kotest:kotest-assertions-core:5.4.2")
    testImplementation("io.kotest.extensions:kotest-assertions-arrow:1.2.5")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.4.2")
    testImplementation("io.kotest:kotest-property:5.4.2")
    testImplementation("io.kotest.extensions:kotest-property-arrow:1.2.5")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.4.2")

}
tasks {
    test {
        useJUnitPlatform()
    }
}
