package dalian.razvan.cucer.githubandroidrepos.core.network

object Endpoints {

    const val BASE_URL = "https://api.github.com/"

    const val SEARCH_TOPICS = "search/topics?q=android&sort=stars&order=desc&per_page=100"
    const val REPO_DETAILS = "/repos/{owner}/{repo_name}"
}