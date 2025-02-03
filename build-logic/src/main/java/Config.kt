object Config {
    const val appName = "streamplayerapp"
    const val applicationId = "com.codandotv.$appName"
    const val compileSdkVersion = 34
    const val minSdkVersion = 24
    const val targetSdkVersion = 34
    const val versionName = "1.0"
    const val versionCode = 1
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    object BuildField {
        const val host = "https://api.themoviedb.org/3/"
        const val api_profile = "https://demo3364084.mockable.io/"

        private const val tmdb_token_name_debug = "TMDB_BEARER_TOKEN_DEBUG"

        private const val bearear_without_environment = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiNDg2NWM4YTAzNzhmM2I4NjI0OWU1ZjNiYWFiMjU2NyIsInN1YiI6IjY0Mjk4YTg5YTNlNGJhMWM0NDgzM2U4OCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9cIxv29vkaZ2yW88DIFRUFK_nXbK2b6KS8t96kA8WAE"

        val api_bearer = System.getenv(tmdb_token_name_debug) ?: bearear_without_environment
    }
}