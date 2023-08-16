package net.sjchen.ampmap.charger

import com.google.maps.android.clustering.ClusterItem


data class Charger(
    val id: Int,
    val stationName: String,
    val address: String,
    val network: String,
    val city: String,
    val state: String,
    val zip: Int,
    val latitude: Double,
    val longitude: Double,


) : ClusterItem{
    override fun getSnippet(): String {
        return "Charger"
    }

    override fun getTitle(): String {
        return id.toString()
    }

    override fun getPosition(): com.google.android.gms.maps.model.LatLng {
        return com.google.android.gms.maps.model.LatLng(latitude, longitude)
    }
}