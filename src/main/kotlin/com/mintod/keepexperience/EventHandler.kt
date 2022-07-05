package com.mintod.keepexperience

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerDeathEvent

class EventHandler(main: Main) : Listener {
    private val plugin: Main = main;

    @EventHandler
    private fun onDeath(e: PlayerDeathEvent): Unit {
        if (plugin.isEnabled) {
            if (plugin.isActive) {
                e.keepExperience = plugin.isActive
            }
        }
    }
}