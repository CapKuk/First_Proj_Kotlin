package com.example.server

import com.example.common.CityTemp
import com.example.server.db.DatabaseFactory
import com.example.server.repository.dataBase.DataBaseRepos
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.*
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }

    val dbUri = URI(environment.config.property("db.jdbcUrl").getString())

    val username: String = dbUri.userInfo.split(":")[0]
    val password: String = dbUri.userInfo.split(":")[1]
    val dbUrl = ("jdbc:postgresql://${dbUri.host}:${dbUri.port}${dbUri.path}")

    DatabaseFactory(
        dbUrl = dbUrl,
        dbPassword = password,
        dbUser = username
    ).apply {
        init()
    }

    val repos = DataBaseRepos

    routing {
        route ("/temps") {
            get{
                val cityTemps = repos.getAll()
                if(cityTemps != null){
                    call.respond(cityTemps)
                }
                else{
                    call.respondText("Empty list")
                }
            }
            post{
                val cityTemp = call.receive<CityTemp>()
                repos.add(cityTemp)
                call.respond(HttpStatusCode.OK)
            }
            delete{
                val id = call.request.queryParameters["id"]?.toLong()
                if(id == null){
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    repos.delete(id)
                    call.respond(HttpStatusCode.OK)
                }
            }
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

