plugins {
    java
    id("com.gradleup.shadow") version "9.3.2"
    id("io.github.intisy.github-gradle") version "1.8.2.1"
}

group = "me.sfiguz7"
version = "5.3.3"
description = "ExtraTools is a Slimefun5 addon aimed at implementing useful tools"

apply(from = "https://raw.githubusercontent.com/Slimefun5/gradle/stable/slimefun-addon.gradle")

version = "5.3.3"

tasks.withType<ProcessResources> {
    filesMatching("plugin.yml") {
        expand(mapOf("version" to "5.3.3"))
    }
}

dependencies {
    implementation("org.bstats:bstats-bukkit:2.2.1")
}

tasks {
    shadowJar {
        archiveFileName.set("ExtraTools-5.3.3.jar")
        relocate("org.bstats", "me.sfiguz7.extratools.bstats")
    }
}
