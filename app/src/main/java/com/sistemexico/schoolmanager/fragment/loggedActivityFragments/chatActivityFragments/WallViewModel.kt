package com.sistemexico.schoolmanager.fragment.loggedActivityFragments.chatActivityFragments

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WallViewModel : ViewModel() {

    private var _wallpost = MutableStateFlow<List<WallDataClass>>(emptyList())
    val wallpost: StateFlow<List<WallDataClass>> = _wallpost

    init {
        _wallpost.value = listOf()
    }

}