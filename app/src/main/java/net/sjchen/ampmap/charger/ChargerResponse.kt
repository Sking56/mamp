package net.sjchen.ampmap.charger

data class ChargerResponse (
    val id: Int,
    val street_address: String,
    val station_name: String,
    val ev_network: String,
    val city: String,
    val state: String,
    val zip: Int,
    val latitude: Double,
    val longitude: Double,
)

fun ChargerResponse.toCharger(): Charger = Charger(
        id = id,
        address = street_address,
        stationName = station_name,
        city = city,
        state = state,
        zip = zip,
        latitude = latitude,
        longitude = longitude,
        network = ev_network,
    )
