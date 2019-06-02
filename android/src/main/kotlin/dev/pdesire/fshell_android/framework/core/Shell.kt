package dev.pdesire.fshell_android.framework.core

import dev.pdesire.fshell_android.framework.exceptions.FShellException
import java.lang.Exception

object Shell {

    fun executeCommand(command : String) : String{
        val execute = Runtime.getRuntime().exec(command)
        var finishedOutput = ""

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellException(
                    this.javaClass.name,
                    "Command failed",
                    ErrorHandler.readError(execute.errorStream)
            )
        } finally {
            finishedOutput = ErrorHandler.readSuccess(execute.inputStream)
            execute.destroy()
        }

        return finishedOutput
    }

}