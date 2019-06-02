package dev.pdesire.fshell_android

import dev.pdesire.fshell_android.extensions.Copy
import dev.pdesire.fshell_android.extensions.Echo
import dev.pdesire.fshell_android.extensions.Move
import dev.pdesire.fshell_android.extensions.Remove
import dev.pdesire.fshell_android.framework.core.RootShell
import dev.pdesire.fshell_android.framework.core.Shell
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FshellAndroidPlugin: MethodCallHandler {
  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "fshell_android")
      channel.setMethodCallHandler(FshellAndroidPlugin())
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    when {
        call.method == "executeRootCommand" -> {
            result.success(RootShell.executeRootCommand(call.arguments as String))
        }
        call.method == "getRootBinaryCall" -> {
            result.success(RootShell.getRootBinaryCall())
        }
        call.method == "executeCommand" -> {
            result.success(Shell.executeCommand(call.arguments as String))
        }
        call.method == "move" -> {
            result.success(Move.move(call.argument<String>("from"), call.argument<String>("to")))
        }
        call.method == "echo" -> {
            result.success(Echo.echo(call.argument<String>(call.arguments as String)))
        }
        call.method == "echoWrite" -> {
            result.success(Echo.echoWrite(call.argument<String>("value"), call.argument<String>("path")))
        }
        call.method == "remove" -> {
            result.success(Remove.remove(call.arguments as String))
        }
        call.method == "removeForce" -> {
            result.success(Remove.remove(call.arguments as String))
        }
        call.method == "removeRecursive" -> {
            result.success(Remove.removeRecursive(call.arguments as String))
        }
        call.method == "removeRecursiveForce" -> {
            result.success(Remove.removeRecusiveForce(call.arguments as String))
        }
        call.method == "copy" -> {
            result.success(Copy.copy(call.argument<String>("from"), call.argument<String>("to")))
        }
        call.method == "copyRecursive" -> {
            result.success(Copy.copyRecursive(call.argument<String>("from"), call.argument<String>("to")))
        }
        else -> result.notImplemented()
    }
  }
}
