package com.kuraky

import com.kuraky.api.KuraAPI
import com.kuraky.commands.v1.CommandManagerV1
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin


class kuracore : JavaPlugin() {

    override fun onEnable() {
        KuraAPI.init(this)
        logger.info("§aKuraCore ha sido habilitado. ¡API lista para otros plugins!")
    }

    override fun onDisable() {
        logger.info("§cKuraCore ha sido Desabilitado.")

    }


}