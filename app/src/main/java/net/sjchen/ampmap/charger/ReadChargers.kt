package net.sjchen.ampmap.charger

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.sjchen.ampmap.R
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Create a class to read the chargers from the database
 * Current database is a CSV file "CA_DEMO_Data.csv"
 * Returns a list of markers of the chargers
 */
class ReadChargers(private  val context: Context){
    private val gson = Gson();

    private val inputStream: InputStream
        get() = context.resources.openRawResource(R.raw.ca_demo_data_small)

    fun readChargers(): List<Charger> {
        val itemType = object : TypeToken<List<ChargerResponse>>() {}.type
        val reader = InputStreamReader(inputStream)
        return gson.fromJson<List<ChargerResponse>>(reader, itemType).map { it.toCharger() }
    }
}