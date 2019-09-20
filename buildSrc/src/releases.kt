const val RELEASE_USER = "hendraanggrian"
const val RELEASE_GROUP = "com.$RELEASE_USER"
const val RELEASE_ARTIFACT = "kotlinpoet-ktx"
const val RELEASE_VERSION = "0.1-rc1"
const val RELEASE_DESC = "KotlinPoet Kotlin extension"
const val RELEASE_WEBSITE = "https://github.com/$RELEASE_USER/$RELEASE_ARTIFACT"

val BINTRAY_USER: String? get() = System.getenv("BINTRAY_USER")
val BINTRAY_KEY: String? get() = System.getenv("BINTRAY_KEY")