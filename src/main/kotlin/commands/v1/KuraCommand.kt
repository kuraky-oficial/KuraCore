package com.kuraky.commands.v1

import com.kuraky.commands.v1.SenderType
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class KuraCommand(
    name:String,
    usageMessage: String,
    private val permissionNode: String?,
    private val senderType: SenderType,
    private val action: (CommandSender, Array<out String>) -> Unit

): Command(name,"",usageMessage, emptyList()) {
    override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>): Boolean {
        if (permissionNode != null && !sender.hasPermission(permissionNode)) {
            sender.sendMessage("§cNo tienes permiso para ejecutar este comando.")
            return true
        }

        when (senderType) {
            SenderType.PLAYER -> if (sender !is Player) {
                sender.sendMessage("§cEste comando solo puede ser ejecutado por jugadores.")
                return true
            }
            SenderType.CONSOLE -> if (sender is Player) {
                sender.sendMessage("§cEste comando solo puede ser ejecutado desde la consola.")
                return true
            }
            SenderType.BOTH -> {}
        }
        action(sender, args)
        return true
    }
}