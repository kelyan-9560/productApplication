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

    }


    fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }

}