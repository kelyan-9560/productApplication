package com.example.kelyan_bervin.firstapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (val name: String, val brand: String, val barcode: String, val nustriscoreCode: String,
                    val imageUrl: String, val quantity: Int, val country : List<String>, val ingredients: List<String>,
                    val allergens: List<String>, val additives: List<String>, val nutritionFacts: NutritionFacts):Parcelable {

    //




}