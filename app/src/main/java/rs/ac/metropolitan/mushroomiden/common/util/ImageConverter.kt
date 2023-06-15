package rs.ac.metropolitan.mushroomiden.common.util

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import java.io.ByteArrayOutputStream

object ImageConverter {

    fun convertUriToBase64(contentResolver: ContentResolver, uri: Uri): String {
        val inputStream = contentResolver.openInputStream(uri)
        val buffer = ByteArray(128 * 1024)
        val outputStream = ByteArrayOutputStream()
        var read: Int
        while (inputStream?.read(buffer).also { read = it ?: -1 } != -1) {
            outputStream.write(buffer, 0, read)
        }
        val imageBytes = outputStream.toByteArray()
        inputStream?.close()
        outputStream.close()
        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }
}