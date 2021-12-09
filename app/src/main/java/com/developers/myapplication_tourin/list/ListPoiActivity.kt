package com.developers.myapplication_tourin.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developers.myapplication_tourin.R
import com.developers.myapplication_tourin.detalle.DetalleActivity
import com.developers.myapplication_tourin.model.Poi
import com.developers.myapplication_tourin.model.PoiItem
import com.google.gson.Gson

class ListPoiActivity : AppCompatActivity() {

    private lateinit var listPoi: ArrayList<PoiItem>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poi)

        poiRecyclerView = findViewById(R.id.poi_recycler_view) /*Bindeamos el Recycler View*/

        //listPoi = createMockPoi()
        listPoi = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(listPoi, onItemClicked = {onPoiClicked(it) })

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiClicked(poi: PoiItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("poi", poi)
        startActivity(intent)


    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem>{
        val poiString: String = applicationContext.assets.open("poi.json").bufferedReader().use { it.readText()}
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Poi::class.java)
        return poiList
    }

    /*private fun createMockPoi():ArrayList<poi>{
        /* Crear poi uno por uno
        var list: ArrayList<poi> = arrayListOf()
        var poi = poi(
            name = "Monserrate",
            location = "Bogota D.C",
            grade = "5 stars",
            temperature_C = "8",
            summary= "Monserrate (named after Catalan homonym mountain Montserrat) is a high mountain over 10,000 feet high that dominates the city center of Bogotá, the capital city of Colombia. It rises to 3,152 meters (10,341 ft) above the sea level, where there is a church (built in the 17th century) with a shrine, devoted to El Señor Caído",
            description="Monserrate (named after Catalan homonym mountain Montserrat) is a high mountain over 10,000 feet high that dominates the city center of Bogotá, the capital city of Colombia. It rises to 3,152 meters (10,341 ft) above the sea level, where there is a church (built in the 17th century) with a shrine, devoted to El Señor Caído.\n" +
            "\n" +
            "The Mountain, already considered sacred in pre-Columbian times when the area was inhabited by the indigenous Muisca, is a pilgrim destination, as well as a major tourist attraction. In addition to the church, the summit contains restaurants, cafeteria, souvenir shops and many smaller tourist facilities. Monserrate can be accessed by aerial tramway (a cable car known as the teleférico), by funicular, or by climbing, the preferred way of pilgrims"
        )
        list.add(poi)
        return list*/

        return arrayListOf(
            poi(
                name = "Monserrate   ",
                location = "Bogota D.C",
                grade = "5 stars",
                temperature_C = "8",
                summary= "Monserrate is a high mountain over 10,000 ft that dominates the city center of Bogotá",
                description="Monserrate (named after Catalan homonym mountain Montserrat) is a high mountain over 10,000 feet high that dominates the city center of Bogotá, the capital city of Colombia. It rises to 3,152 meters (10,341 ft) above the sea level, where there is a church (built in the 17th century) with a shrine, devoted to El Señor Caído.\n" +
                        "\n" +
                        "The Mountain, already considered sacred in pre-Columbian times when the area was inhabited by the indigenous Muisca, is a pilgrim destination, as well as a major tourist attraction. In addition to the church, the summit contains restaurants, cafeteria, souvenir shops and many smaller tourist facilities. Monserrate can be accessed by aerial tramway (a cable car known as the teleférico), by funicular, or by climbing, the preferred way of pilgrims",
                urlPicture = "https://www.eltiempo.com/files/article_main/uploads/2019/04/19/5cba5f5bb4807.jpeg"
            ),

            poi(
                name = "Plaza de Bolivar",
                location = "Bogota D.C",
                grade = "4 stars",
                temperature_C = "12",
                summary= "Plaza de Bolivar is the main square of the Colombian capital Bogotá",
                description="The main square of the Colombian capital Bogotá. The square, previously called Plaza Mayor until 1821 and Plaza de la Constitución, is located in the heart of the historical area of the city and hosts a statue of Simón Bolívar. The square is surrounded by historical buildings; the Palace of Justice is located on the northern edge and the National Capitol borders the square in the south. The Primary Cathedral of Bogotá, next to the Archiepiscopal Palace with the monumental door cast by Ferdinando Marinelli Artistic Foundry and the Lievano Palace, seat of the mayor of Bogotá, are situated on the eastern and western side respectively.",
                urlPicture="https://www.gpsmycity.com/img/gd_attr/34282.jpg"

            ),

            poi(
                name = "Museo de Botero",
                location = "La candelaria, Bogota D.C",
                grade = "4 stars",
                temperature_C = "12",
                summary= "The Botero Museum also known as Museo Botero is a museum located in Bogotá, Colombia",
                description="The Botero Museum also known as Museo Botero is a museum located in Bogotá, Colombia. It houses one of Latin America's most important international art collections. It sees 500,000 visitors annually, around 1,000 daily, and of those 2,000 students per month. Being in La Candelaria neighborhood of Bogotá, the museum is in close proximity to other important landmarks like the Luis Ángel Arango Library and the Gold Museum of Bogotá",
                urlPicture = "https://media-cdn.tripadvisor.com/media/photo-s/05/44/de/f9/museo-di-botero.jpg"

            )

        )
    }*/

}