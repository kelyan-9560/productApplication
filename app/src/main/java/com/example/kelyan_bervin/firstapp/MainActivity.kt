package com.example.kelyan_bervin.firstapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // l'ActionBar (ancien nom de la Toolbar) doit prendre comme arrière-plan la ressource contenant le dégradé
        // chemin de la ressource en question -> res/drawable/toolbar.xml
        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        //affichez un Toast avec pour texte "Hello World"
        // context <=> activity
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()

        // affichez un log de type verbose ayant pour texte "Hello World" (s'affiche dans l'onglet logcat de l'IDE)
        // .v --> verbose
        Log.v("TestVerbose", "Hello World (Toast")

        //Snackbar
        //android.R.id.content --> page de l'application
        Snackbar.make(findViewById(android.R.id.content), "Je suis un snackbar", Snackbar.LENGTH_SHORT).show()

        //appel de la page pois_carottes
        setContentView(R.layout.product)

        //utilisation des TextView
        findViewById<TextView>(R.id.barcode).setTextBold(getString(R.string.product_barcode, "1234"),)

        /////////
        val country = listOf("France", "ALlemagne", "Pérou", "Pays-Bas")
        val ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel")
        val allergens = listOf("Auncun")
        val additivesList = listOf("Auncun")

        val energy = NutritionFactsItem("1", 15, 150)
        val butterfat = NutritionFactsItem("1", 15, 150)
        val saturatedFat = NutritionFactsItem("1", 15, 150)
        val carbohydrates = NutritionFactsItem("1", 15, 150)
        val sugar = NutritionFactsItem("1", 15, 5)
        val dietaryFibers = NutritionFactsItem("1", 15, 150)
        val proteins = NutritionFactsItem("1", 4, 8)
        val salt = NutritionFactsItem("1", 0, 75)
        val sodium = NutritionFactsItem("1", 0, 295)
        val nutritionFacts = NutritionFacts(energy, butterfat, saturatedFat, carbohydrates, sugar, dietaryFibers, proteins, salt, sodium)

        val prod1 = Product ("Petit pois et carottes", "Cassegrain", "3083680085304", "B",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", 1, country,
            ingredients, allergens, additivesList, nutritionFacts)

        foodTitle.text = prod1.name
        brand.text = prod1.brand
        //nutriscroreImage.url = prod1.imageUrl
        barcode.text = prod1.barcode
        quantity.text = prod1.quantity.toString()
        allergen.text = prod1.allergens.toString()
        additives.text = prod1.additives.toString()

        Picasso.get().load("url").into(nutriscroreImage)
        //////////
        //nutrition
        //DrawableCompat.setTintList(R.layout.nutrition.background, ColorStateList.valueOf(votreCouleur))


    }


    fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }

}