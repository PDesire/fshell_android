import 'dart:async';

import 'package:flutter/services.dart';

class FShellAndroid {
  static const MethodChannel _channel =
      const MethodChannel('fshell_android');

  static Future<String> executeRootCommand(String command) async {
    final String result = await _channel.invokeMethod('executeRootCommand', command);
    return result;
  }

  static Future<String> executeCommand(String command) async {
    final String result = await _channel.invokeMethod('executeCommand', command);
    return result;
  }

  static Future<String> getRootBinaryCall() async {
    final String result = await _channel.invokeMethod('getRootBinaryCall');
    return result;
  }

  static Future<String> move(String from, String to) async {
    final String result = await _channel.invokeMethod('move', {"from": from, "to": to});
    return result;
  }

  static Future<String> copy(String from, String to) async {
    final String result = await _channel.invokeMethod('copy', {"from": from, "to": to});
    return result;
  }

  static Future<String> copyRecursive(String from, String to) async {
    final String result = await _channel.invokeMethod('copyRecursive', {"from": from, "to": to});
    return result;
  }

  static Future<String> remove(String path) async {
    final String result = await _channel.invokeMethod('remove', path);
    return result;
  }

  static Future<String> removeForce(String path) async {
    final String result = await _channel.invokeMethod('removeForce', path);
    return result;
  }

  static Future<String> removeRecursive(String path) async {
    final String result = await _channel.invokeMethod('removeRecursive', path);
    return result;
  }

  static Future<String> removeRecursiveForce(String path) async {
    final String result = await _channel.invokeMethod('removeRecursiveForce', path);
    return result;
  }

  static Future<String> echo(String value) async {
    final String result = await _channel.invokeMethod('echo', value);
    return result;
  }

  static Future<String> echoWrite(String value, String path) async {
    final String result = await _channel.invokeMethod('copyRecursive', {"value": value, "path": path});
    return result;
  }
}
