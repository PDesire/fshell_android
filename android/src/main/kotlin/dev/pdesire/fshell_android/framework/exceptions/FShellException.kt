package dev.pdesire.fshell_android.framework.exceptions

import java.lang.Exception

class FShellException(classname: String, message: String, error : String) : Exception("GENERIC FAILURE! Source: $classname Message: $message Error: $error")

class FShellRootException(classname: String, message: String, error : String) : Exception("ROOT EXECUTION FAILURE!  Source: $classname Message: $message Error: $error")