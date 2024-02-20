package com.yeelight_kotlin_api_custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id_text: TextView =findViewById(R.id.id_text)
        val power_button: Button = findViewById(R.id.power_button)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val yeelight = YeelightManager()
                // for debug: Network search + print details
                yeelight.printAllYeelightDevices()

                val ids = yeelight.getAllYeelightDeviceIds()
                val chosenId = ids.first()
                val device = yeelight.findDeviceById(chosenId)
                id_text.text ="Choosed ID: $chosenId"
                //println("ID-K: $chosenId")

                power_button.setOnClickListener {
                    CoroutineScope(Dispatchers.IO).launch {
                        try {

                            device?.toggle()
                            yeelight.clearCache()
                            /*device?.setBrightness(50)
                            device?.startColorFlow(
                                flowTuples = listOf(FlowColor(0xFF0000), FlowColor(0x00FF00)),
                                repeat = 10,
                                action = FlowEndAction.off
                            )*/
                            Log.d("Yeelight", "Siker! " + device)
                        } catch (e: Exception) {
                            Log.e("Yeelight", "Hiba történt: ${e.message}", e)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("Yeelight", "Hiba történt: ${e.message}", e)
            }
        }
    }
    //nem vagyok teljesen biztos, hogy ez kell... || I'm not sure about it...
    /*override fun onDestroy() {
        super.onDestroy()
        CoroutineScope(Dispatchers.IO).cancel()
    }*/
}