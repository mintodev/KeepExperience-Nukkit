package com.mintod.keepexperience

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerDeathEvent
import cn.nukkit.plugin.PluginBase

class Main : PluginBase(), Listener {

    private var keepExperienceEnabled: Boolean = false

    override fun onEnable() {
        this.server.pluginManager.registerEvents(this, this)

        this.saveDefaultConfig()
        this.keepExperienceEnabled = this.config.getBoolean("keepExperienceEnabled")
    }

    @EventHandler
    private fun onDeath(e: PlayerDeathEvent) {
        e.keepExperience = this.keepExperienceEnabled
    }
}
