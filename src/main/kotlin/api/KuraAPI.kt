package com.kuraky.api

import com.kuraky.commands.v1.CommandManagerV1
import com.kuraky.events.v1.EventManagerV1
import org.bukkit.plugin.Plugin

object KuraAPI {
    lateinit var plugin: Plugin private set

    // Llamaremos a esto desde el onEnable de KuraCore
    fun init(corePlugin: Plugin) {
        this.plugin = corePlugin
    }

    object commands {
        val v1 = CommandManagerV1() // El que creamos antes
    }

    object events {
        val v1 = EventManagerV1()
    }
}