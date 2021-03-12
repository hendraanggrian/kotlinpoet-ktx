const val VERSION_TRUTH = "1.0.1"

fun org.gradle.api.artifacts.dsl.DependencyHandler.google(repo: String? = null, module: String, version: String) =
    "com.google${repo?.let { ".$it" }.orEmpty()}:$module:$version"