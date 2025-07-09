plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.sandroni"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.1"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation(kotlin("stdlib-jdk8"))
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
	jvmToolchain(8)
}

kotlin {
	jvmToolchain(21)
}

tasks.withType<JavaCompile> {
}

tasks.withType<Test> {
	useJUnitPlatform()
}
