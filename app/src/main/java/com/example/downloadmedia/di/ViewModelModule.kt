package com.example.downloadmedia.di

import com.example.downloadmedia.feature.main.viewModel.MediaViewModel
import com.example.downloadmedia.manager.DownloadManager
import org.koin.dsl.module

val viewModelModule = module {
    single { providerMediaViewModel(get()) }
}

private fun providerMediaViewModel(downloadManager: DownloadManager) = MediaViewModel(downloadManager)