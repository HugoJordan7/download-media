package com.example.downloadmedia.feature.main.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.downloadmedia.manager.DownloadManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MediaViewModel(private val downloadManager: DownloadManager) : ViewModel() {

    val isDownloading: StateFlow<Boolean> get() = _isDownloading
    private val _isDownloading: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val isFailure: StateFlow<Boolean> get() = _isFailure
    private val _isFailure: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val errorMessage: StateFlow<String> get() = _errorMessage
    private val _errorMessage: MutableStateFlow<String> = MutableStateFlow("")

    fun downloadMedia(url: String, fileName: String, context: Context) {
        _isDownloading.value = true
        try {
            val byteArray = downloadManager.downloadFile(url, fileName, context){ isComplete ->
                if(isComplete) _isDownloading.value = false
            }
        } catch (e: Exception) {
            _isFailure.value = true
            _isDownloading.value = false
            _errorMessage.value = e.message ?: "Unknown error"
        }
    }

}