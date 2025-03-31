package me.grian

import io.github.classgraph.ClassGraph
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import me.grian.actions.MoveAction
import me.grian.commands.api.Command
import me.grian.data.ErrorResponse
import me.grian.data.move.MoveResponse
import java.util.Scanner
import kotlin.collections.set
import kotlin.io.path.Path
import kotlin.io.path.readText

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json)
        }
    }

    val env = Json.decodeFromString<Env>(Path("src/main/resources/env.json").readText())

    val characterName = "Grian"

    val commands: MutableMap<String, Command> = mutableMapOf()


    ClassGraph().enableAllInfo().scan().use { result ->
        val commandList = result.getSubclasses(Command::class.java)

        commandList.forEach { command ->
            val commandClass = command.loadClass(Command::class.java)
            val instance = commandClass.getConstructor(
                HttpClient::class.java,
                String::class.java,
                String::class.java
            )
                .newInstance(client, env.token, characterName)

            commands[instance.name] = instance
        }

    }


    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        val command = sc.nextLine()

        val commandName = command.split(" ")[0]

        if (commands.containsKey(commandName)) {
            commands[commandName]!!.execute(command)
        } else {
            println("Unrecognized Command")
        }
    }
}