package com.mintod.keepexperience

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.event.Listener
import cn.nukkit.plugin.PluginBase
import cn.nukkit.utils.TextFormat

class Main : PluginBase(), Listener {
    var isActive: Boolean = true

    private var isEnabled: Boolean? = null

    override fun onEnable() {
        this.server.pluginManager.registerEvents(EventHandler(this), this)

        this.saveDefaultConfig()
        this.isEnabled = this.config.getBoolean("enabled")
    }

    override fun onCommand(
        sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?
    ): Boolean {
        if (command?.name == "keepexperience" && sender?.hasPermission("keepexperience.toggle.cmd") == true) {
            if (sender !is Player) {
                sender.sendMessage("${TextFormat.RED}Please use this command in-game")
                return true
            }
            if (this.isEnabled == true) {
                return if (this.isActive) {
                    this.isActive = !this.isActive
                    sender.sendMessage(this.config.getString("disableMessage"))
                    true
                } else {
                    this.isActive = !this.isActive
                    sender.sendMessage(this.config.getString("enableMessage"))
                    true
                }
            } else {
                sender.sendMessage(this.config.getString("keepExperienceDisabled"))
            }
        }
        return true
    }
}