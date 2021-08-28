package com.example.restapiproject.ui.networkGlobal

import com.example.restapiproject.model.GlobalResult

interface NetworkListenerForGlobal {
    fun onGlobalResultResponses(models: GlobalResult?)
    fun onGlobalResultFailure(message: String?)
}