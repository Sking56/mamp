package net.sjchen.ampmap.db

import net.sjchen.ampmap.charger.Charger
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MampAPI {
    @GET("/chargers/api/json")
    fun getChargers(@QueryMap params: Map<String, String>):
            List<Charger>
}