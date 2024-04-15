package com.sistemexico.schoolmanager.fragment.loggedActivityFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.sistemexico.schoolmanager.adapter.AdapterViewPagerChat
import com.sistemexico.schoolmanager.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        viewPagerAdapter()
    }

    private fun viewPagerAdapter() {
        //val parentViewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        val viewPager = binding.viewPagerChat
        viewPager.adapter = AdapterViewPagerChat(this)
        val tabLayout = binding.tabLayoutChat
        val titles = listOf("Notificaciones", "Muro") // Lista de títulos para las pestañas

        TabLayoutMediator(tabLayout, binding.viewPagerChat) { tab, position ->
            tab.text = titles[position] // Establecer el título de la pestaña basado en la posición
        }.attach()
    }
}