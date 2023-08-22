package net.sjchen.ampmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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

        val searchView = supportFragmentManager.findFragmentById(R.id
            .idSearchView) as? SearchView

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync{googleMap ->
            addMarkers(googleMap)
            googleMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(this))}

        searchView?.setOnQueryTextListener(object : SearchView
            .OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // 1. Get the query string
                val queryString = query ?: return false

                // 2. Get the list of matching chargers
//                val chargerList = chargers.filter { charger ->
//                    charger.stationName.contains(queryString, true)
//                }

                // 3. Update the map with the new list
//                updateMap(chargerList)

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

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