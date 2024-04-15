package com.sistemexico.schoolmanager.fragment.loggedActivityFragments.chatActivityFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sistemexico.schoolmanager.PostProvider
import com.sistemexico.schoolmanager.adapter.PostsAdapter
import com.sistemexico.schoolmanager.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerNotifications
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PostsAdapter(PostProvider.posts)
    }
}