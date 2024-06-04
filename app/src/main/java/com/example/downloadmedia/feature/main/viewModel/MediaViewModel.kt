package com.example.downloadmedia.feature.main.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.downloadmedia.manager.DownloadManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MediaViewModel(private val downloadManager: DownloadManager) : ViewModel() {

    val isFailure: StateFlow<Boolean> get() = _isFailure
    private val _isFailure: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val errorMessage: StateFlow<String> get() = _errorMessage
    private val _errorMessage: MutableStateFlow<String> = MutableStateFlow("")

    fun downloadMedia(url: String, fileName: String, context: Context) {
        try {
            downloadManager.downloadFile(url, fileName, context)
            _isFailure.value = false
        } catch (e: Exception) {
            _isFailure.value = true
            _errorMessage.value = e.message ?: "Unknown error"
        }
    }

}