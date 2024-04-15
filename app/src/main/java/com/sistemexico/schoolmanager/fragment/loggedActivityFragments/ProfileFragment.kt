package com.sistemexico.schoolmanager.fragment.loggedActivityFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sistemexico.schoolmanager.R
import com.sistemexico.schoolmanager.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*BottomSheetBehavior.from(binding.sheet).apply {
            peekHeight = 0
            this.state = BottomSheetBehavior.STATE_EXPANDED
        }*/

        /*
                val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        */
        val navBar = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
        //Card1
        val card1 = binding.card1
        card1.titleTemplate.text = "Avisos"
        card1.textTemplate.text = "Circulares y notificaciones"
        //Card2
        val card2 = binding.card2
        card2.titleTemplate.text = "Realizar Pagos"
        card2.textTemplate.text = "Conceptos próximos a vencer"
        card2.iconTemplate.setImageResource(R.drawable.ic_pay)
        //Card3
        val card3 = binding.card3
        card3.titleTemplate.text = "Documentos Académicos"
        card3.textTemplate.text = "Consulta tus documentos aquí"
        card3.iconTemplate.setImageResource(R.drawable.ic_academic)

        binding.card1.root.setOnClickListener {
            /*viewPager.setCurrentItem(0, true)*/
            navBar.selectedItemId = R.id.chatFragment
        }
        binding.card2.root.setOnClickListener {
            /*viewPager.setCurrentItem(2, true)*/
            navBar.selectedItemId = R.id.payFragment
        }
    }

}