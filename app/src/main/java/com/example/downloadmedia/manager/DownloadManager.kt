package com.example.downloadmedia.manager

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class DownloadManager {

    @Throws
    fun downloadFile(url: String, fileName: String, context: Context){
        val requestQueue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            saveFileToDownloadFolder(response, fileName, context)
        }, { error ->
            throw Exception(error.message ?: "Unknown error")
        })
        requestQueue.add(stringRequest)
    }

    private fun saveFileToDownloadFolder(response: String, fileName: String, context: Context) {
        val fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val inputStream = response.byteInputStream()
        val buffer = ByteArray(1024)
        var bytesRead: Int
        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            fileOutputStream.write(buffer, 0, bytesRead)
        }
        inputStream.close()
        fileOutputStream.close()
    }
}