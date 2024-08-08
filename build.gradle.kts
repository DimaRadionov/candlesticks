plugins {
  kotlin("jvm") version "1.7.21"
  application
}

application {
  mainClass.set("MainKt")
}

group = "org.traderepublic.candlesticks"
version = "1.1.4"

repositories {
  mavenCentral()
}

object DependencyVersions {
  const val coroutines = "1.5.2"
  const val http4k = "4.13.1.0"
  const val jackson = "2.13.+"
  const val mockk = "1.12.0"
  const val postgres = "42.3.6"
  const val hikariCP = "4.0.3"
  const val typesafeConfig = "1.4.2"
  const val exposed = "0.38.2"
}

dependencies {
  implementation(kotlin("stdlib"))
  testImplementation(kotlin("test"))

  implementation("com.typesafe:config:${DependencyVersions.typesafeConfig}")

  implementation(platform("org.http4k:http4k-bom:4.13.1.0"))
  implementation("org.http4k:http4k-core")
  implementation("org.http4k:http4k-server-netty")
  implementation("org.http4k:http4k-client-websocket:${DependencyVersions.http4k}")
  implementation("org.http4k:http4k-format-jackson:${DependencyVersions.http4k}")
  testImplementation("org.http4k:http4k-testing-hamkrest:${DependencyVersions.http4k}")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersions.coroutines}")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${DependencyVersions.coroutines}")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersions.jackson}")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${DependencyVersions.jackson}")
  testImplementation("io.mockk:mockk:${DependencyVersions.mockk}")
  implementation("org.apache.logging.log4j:log4j-core:2.17.1")

  implementation("org.postgresql:postgresql:${DependencyVersions.postgres}")
  implementation("com.zaxxer:HikariCP:${DependencyVersions.hikariCP}")

  implementation("org.jetbrains.exposed:exposed-core:${DependencyVersions.exposed}")
  implementation("org.jetbrains.exposed:exposed-dao:${DependencyVersions.exposed}")
  implementation("org.jetbrains.exposed:exposed-jdbc:${DependencyVersions.exposed}")
  implementation("org.jetbrains.exposed:exposed-java-time:${DependencyVersions.exposed}")
}

tasks.test {
  useJUnitPlatform()
}
