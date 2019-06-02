package dev.pdesire.fshell_android.extensions

import dev.pdesire.fshell_android.framework.core.ErrorHandler
import dev.pdesire.fshell_android.framework.exceptions.FShellException
import java.lang.Exception

object Echo {

    fun echo(value : String?) : String {
        val execute = Runtime.getRuntime().exec("echo $value")
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Echo failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }

    fun echoWrite(value : String?, toPath: String?) : String {
        val execute = Runtime.getRuntime().exec("echo $value > $toPath")
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Echo write failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }
}