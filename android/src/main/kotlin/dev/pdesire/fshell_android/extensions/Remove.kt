package dev.pdesire.fshell_android.extensions

import dev.pdesire.fshell_android.framework.core.ErrorHandler
import dev.pdesire.fshell_android.framework.exceptions.FShellException
import java.lang.Exception

object Remove {

    fun remove(filePath : String?) : String {
        val execute = Runtime.getRuntime().exec("rm $filePath")
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

    fun removeForce(filePath : String?) : String {
        val execute = Runtime.getRuntime().exec("rm -f $filePath")
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Remove forcefully failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }

    fun removeRecursive(folderPath : String?) : String {
        val execute = Runtime.getRuntime().exec("rm -r $folderPath")
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Remove recursively failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }

    fun removeRecusiveForce(folderPath : String?) : String {
        val execute = Runtime.getRuntime().exec("rm -rf $folderPath")
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Remove recursively forcefully failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }

}