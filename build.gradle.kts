// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("room_version", "2.5.2")
        set("di_hilt", "2.47")
        set("retrofit_version", "2.11.0")
        set("retrofit_okhttp3_version", "5.0.0-alpha.13")
        set("coroutines_version", "1.7.1")
        set("lifecycle_version", "2.7.0")
        set("compose_version", "1.0.0-beta01")
    }
}
plugins {
    id("com.android.application") version "8.3.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id ("com.google.dagger.hilt.android") version "2.47" apply false
}