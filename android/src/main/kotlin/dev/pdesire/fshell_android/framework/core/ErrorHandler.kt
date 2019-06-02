package dev.pdesire.fshell_android.framework.core

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

object ErrorHandler {

    fun readError(input: InputStream) : String {
        val reader = BufferedReader(InputStreamReader(input))
        try {
            val results = StringBuilder()
            while (true) {
                val line = reader.readLine() ?: break
                results.append(line)
            }
            return results.toString()
        } finally {
            reader.close()
        }
    }

    fun readSuccess(input: InputStream) : String {
        val reader = BufferedReader(InputStreamReader(input))
        try {
            val results = StringBuilder()
            while (true) {
                val line = reader.readLine() ?: break
                results.append(line)
            }
            return "Success! $results"
        } finally {
            reader.close()
        }
    }

}