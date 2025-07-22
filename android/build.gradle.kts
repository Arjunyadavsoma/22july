// Top-level build file where you can add configuration options common to all sub-projects/modules.

// The 'plugins' block is the modern way to apply plugins to the project.
// We define the versions here and set 'apply false' because they will be
// applied in the individual module's build.gradle.kts file.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("com.android.library") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}

// The 'allprojects' block configures properties for all projects (root and sub-projects).
// Here, we are specifying the repositories where Gradle should look for dependencies.
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// The following section contains custom logic to change the default build directory location.
// This is not standard but is preserved from your original file.
val newBuildDir: org.gradle.api.file.Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.set(newBuildDir)

subprojects {
    val newSubprojectBuildDir: org.gradle.api.file.Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.set(newSubprojectBuildDir)
}

subprojects {
    project.evaluationDependsOn(":app")
}

// This registers a custom 'clean' task to delete the build directory.
// This is useful for clearing out all build artifacts.
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
