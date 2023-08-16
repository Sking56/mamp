package net.sjchen.ampmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import net.sjchen.ampmap.charger.Charger
import net.sjchen.ampmap.charger.ReadChargers

class MapsActivity : AppCompatActivity() {

    private val chargers: List<Charger> by lazy { ReadChargers(this)
        .readChargers() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync{googleMap ->
            addMarkers(googleMap)
            googleMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(this))}

    }


    private fun addMarkers(googleMap: GoogleMap) {
        chargers.forEach { charger ->
            val marker = googleMap.addMarker(
                MarkerOptions()
                    .title(charger.id.toString())
                    .position(LatLng(charger.latitude, charger.longitude))
            )
            marker?.tag = charger
        }
    }
}