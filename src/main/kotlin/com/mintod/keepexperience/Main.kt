/*
     _  __               ______                      _
    | |/ /              |  ____|                    (_)
    | ' / ___  ___ _ __ | |__  __  ___ __   ___ _ __ _  ___ _ __   ___ ___
    |  < / _ \/ _ \ '_ \|  __| \ \/ / '_ \ / _ \ '__| |/ _ \ '_ \ / __/ _ \
    | . \  __/  __/ |_) | |____ >  <| |_) |  __/ |  | |  __/ | | | (_|  __/
    |_|\_\___|\___| .__/|______/_/\_\ .__/ \___|_|  |_|\___|_| |_|\___\___|
                   | |               | |
                   |_|               |_|

    Copyright (C) 2021  MintoD

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
 */

package com.mintod.keepexperience

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerDeathEvent
import cn.nukkit.plugin.PluginBase
import cn.nukkit.utils.TextFormat

class Main : PluginBase(), Listener {

    private var isActive: Boolean = false
    private var keepExperienceEnabled: Boolean = false

    override fun onEnable() {
        this.server.pluginManager.registerEvents(this, this)

        this.saveDefaultConfig()
        this.keepExperienceEnabled = this.config.getBoolean("keepExperienceEnabled")
    }

    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (sender !is Player) {
            sender?.sendMessage("${TextFormat.DARK_RED} Please use this command in-game")
            return false
        }

        when (this.isActive) {
            true -> {
                sender.sendMessage("${TextFormat.DARK_RED} Disabled keep experience")
                this.isActive = false
            }
            else -> {
                sender.sendMessage("${TextFormat.GREEN} Enabled keep experience")
                this.isActive = true
            }
        }

        return true
    }

    @EventHandler
    private fun onDeath(e: PlayerDeathEvent): Unit {
        if (this.isActive) {
            e.keepExperience = this.keepExperienceEnabled
        }
    }
}
