package com.example.downloadmedia.di

import com.example.downloadmedia.manager.DownloadManager
import org.koin.dsl.module

val managerModule = module {
    single { providerDownloadManager() }
}

private fun providerDownloadManager() = DownloadManager()