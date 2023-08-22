package net.sjchen.ampmap.db

import net.sjchen.ampmap.charger.Charger

interface MampAPI {
    fun getChargers(): List<Charger>
}