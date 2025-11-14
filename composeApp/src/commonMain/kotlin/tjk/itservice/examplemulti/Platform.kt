package tjk.itservice.examplemulti

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform