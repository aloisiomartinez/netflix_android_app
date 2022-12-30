package co.tiagoaguiar.netflixremake.util

import android.util.Log
import java.io.IOException
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class CategoryTask {

    fun execute(url: String) {
        //  utiliza a UI-thread (1)
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {
            try {
                // utiliza a NOVA-thread [processo paralelo] (2)
                val requestURL = URL(url) // abrir uma URL
                val urlConnection =
                    requestURL.openConnection() as HttpsURLConnection // abre a conexão
                urlConnection.readTimeout = 2000 // tempo leitura (2s)
                urlConnection.connectTimeout = 2000 // tempo conexão (2s)

                val statusCode: Int = urlConnection.responseCode
                if (statusCode > 400) {
                    throw IOException("Erro na comunicação com o servidor!")
                }

                // forma 1: simples e rápida
                val stream = urlConnection.inputStream // sequencia bytes
                val jsonAsString = stream.bufferedReader().use { it.readText() } // bytes -> String
                Log.i("Teste", jsonAsString)


            } catch (e: IOException) {
                Log.e("Teste", e.message ?: "erro desconhecido", e)
            }
        }
    }

}