package dev.pdesire.fshell_android.extensions

import dev.pdesire.fshell_android.framework.core.ErrorHandler
import dev.pdesire.fshell_android.framework.exceptions.FShellException
import java.lang.Exception

object Move {

    fun move(fromPath : String?, toPath: String?) : String {
        val execute = Runtime.getRuntime().exec("mv $fromPath $toPath")
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Remove failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }

}