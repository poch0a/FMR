package com.example.final_mobileresume

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class HomeScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)

        val AboutMeButton : Button = view.findViewById(R.id.AboutMeBut)
        val ProjectDevelopmentButton : Button = view.findViewById(R.id.ProjectDevelopmentsBut)
        val ContactFormButton : Button = view.findViewById(R.id.ContactFormBut)
        val SettingsButton : Button =view.findViewById(R.id.SettingsBut)

        AboutMeButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homePage_to_aboutMe)
        }
        ProjectDevelopmentButton.setOnClickListener(){
            findNavController().navigate(R.id.action_HomeScreen_to_projectDevelopment)
        }
        ContactFormButton.setOnClickListener(){
            findNavController().navigate(R.id.action_HomeScreen_to_contactForm)
        }
        SettingsButton.setOnClickListener(){
            findNavController().navigate(R.id.action_HomeScreen_to_settings)
        }

        return view
    }
}