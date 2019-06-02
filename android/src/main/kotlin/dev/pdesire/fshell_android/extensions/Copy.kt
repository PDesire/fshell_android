package dev.pdesire.fshell_android.extensions

import dev.pdesire.fshell_android.framework.core.ErrorHandler
import dev.pdesire.fshell_android.framework.exceptions.FShellException
import java.lang.Exception

object Copy {

    fun copy(fromFile : String?, toFile: String?) : String {
        val execute = Runtime.getRuntime().exec("cp $fromFile $toFile")
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

    fun copyRecursive(fromPath : String?, toPath: String?) : String {
        val execute = Runtime.getRuntime().exec("cp -r $fromPath $toPath")
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