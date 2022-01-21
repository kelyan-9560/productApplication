package com.example.kelyan_bervin.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main,container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val button = view.findViewById<Button>(R.id./*nom du nouton de scan*/)
        button.setOnClickListener{
            // Clic sur le bouton Scan
            val intent = Intent("com.google.zxing.client.android.SCAN")
            intent.putExtra("SCAN_FORMATS", "EAN_13")
            startActivityForResult(intent, 100)
        }





    }


}