package com.example.downloadmedia.manager

import android.content.Context
import android.os.Environment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.Volley
import java.io.File
import java.io.FileOutputStream

class DownloadManager {

    @Throws
    fun downloadFile(url: String, fileName: String, context: Context) {
        val requestQueue = Volley.newRequestQueue(context)
        val byteRequest = object : Request<ByteArray>(
            Method.GET, url,
            { error ->
                throw Exception(error.message ?: "Unknown error")
            }) {
            override fun parseNetworkResponse(response: com.android.volley.NetworkResponse): Response<ByteArray> {
                return Response.success(response.data, HttpHeaderParser.parseCacheHeaders(response))
            }

            override fun deliverResponse(response: ByteArray) {
                saveFileToDownloadFolder(response, fileName)
            }
        }
        requestQueue.add(byteRequest)
    }

    @Throws
    private fun saveFileToDownloadFolder(response: ByteArray, fileName: String) {
        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        var file = File(downloadsDir, fileName)
        if (file.exists()) {
            val fileNameBeforeExtension = fileName.substringBeforeLast(".")
            val fileExtension = fileName.substringAfterLast(".", "")
            var counter = 1
            while (file.exists()) {
                val newFileName = "$fileNameBeforeExtension ($counter).$fileExtension"
                file = File(downloadsDir, newFileName)
                counter++
            }
        }
        val fileOutputStream = FileOutputStream(file)
        fileOutputStream.write(response)
        fileOutputStream.close()
    }

}