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
        maven { url = uri("https://www.jitpack.io" ) }
    }
}

rootProject.name = "CinemaSearchApp"
include(":app")
//FOLDERS
include(":api")
include(":celebrity")
include(":feature")
//CELEBRITY
include(":celebrity:core")
include(":celebrity:core_factory")
include(":celebrity:core_impl")
include(":celebrity:coreui")
include(":celebrity:network")
//API
include(":api:film_by_id_api")
include(":api:all_films_api")
//FEATURE
include(":feature:film_by_id")
include(":feature:all_films")


