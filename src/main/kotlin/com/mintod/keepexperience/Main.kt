package com.mintod.keepexperience

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerDeathEvent
import cn.nukkit.plugin.PluginBase

class Main : PluginBase(), Listener {

    private var keepExperienceEnabled: Boolean = false
<<<<<<< HEAD
=======
    private var keepInventoryEnabled: Boolean = false
>>>>>>> 2c728525a892c134f236c8198581297c5867f4ad

    override fun onEnable() {
        this.server.pluginManager.registerEvents(this, this)

<<<<<<< HEAD
        this.saveDefaultConfig()
        this.keepExperienceEnabled = this.config.getBoolean("keepExperienceEnabled")
=======
        this.saveDefaultConfig();
        this.keepExperienceEnabled = this.config.getBoolean("keepExperienceEnabled")
        this.keepInventoryEnabled = this.config.getBoolean("keepInventoryEnabled")
>>>>>>> 2c728525a892c134f236c8198581297c5867f4ad
    }

    @EventHandler
    private fun onDeath(e: PlayerDeathEvent) {
        e.keepExperience = this.keepExperienceEnabled
<<<<<<< HEAD
=======
        e.keepInventory = this.keepInventoryEnabled
>>>>>>> 2c728525a892c134f236c8198581297c5867f4ad
    }
}
