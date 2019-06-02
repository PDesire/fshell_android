package dev.pdesire.fshell_android.framework.core

import dev.pdesire.fshell_android.framework.exceptions.FShellRootException
import java.lang.Exception

object RootShell {

    fun getRootBinaryCall() : Process {
        return Runtime.getRuntime().exec("su")
    }

    private fun getRootBinaryLocation() : Process {
        return Runtime.getRuntime().exec("which su")
    }

    fun executeRootCommand(command : String) : String{
        val rootCheck = getRootBinaryLocation()
        val execute = Runtime.getRuntime().exec("su -c $command")
        var finishedOutput = ""

        try {
            rootCheck.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellRootException(
                    this.javaClass.name,
                    "No Root binary detected.",
                    ErrorHandler.readError(rootCheck.errorStream)
            )
        } finally {
            rootCheck.destroy()
        }

        try {
            execute.waitFor()
        } catch (e: Exception) {
            execute.destroy()
            throw FShellRootException(
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