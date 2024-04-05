pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CinemaSearchApp"
include(":app")
//FOLDERS
include(":api")
include(":celebrity")
include(":feature")
include(":celebrity:core")
include(":celebrity:core_factory")
include(":celebrity:core_impl")
include(":celebrity:coreui")
