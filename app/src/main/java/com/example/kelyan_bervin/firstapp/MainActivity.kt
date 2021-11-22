package com.example.kelyan_bervin.firstapp

import android.content.res.ColorStateList
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
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
        Énergie 293 kj
        Matières grasses / Lipides 0,8 g
        Acides gras saturés 0,1 g
        Glucides 8,4 g
        Sucres 5,2 g
        Fibres alimentaires 5,2 g
        Protéines 4,8 g
        Sel 0,75 g
        Sodium 0,295 g
        val nutritionFactsItem = listOf(293, )

        val prod1 = Product ("Petit pois et carottes", "Cassegrain", "3083680085304", "B",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg", 1, country,
            ingredients, allergens, additivesList)

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