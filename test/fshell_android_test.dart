import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:fshell_android/fshell_android.dart';

void main() {
  const MethodChannel channel = MethodChannel('fshell_android');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FShellAndroid.executeCommand("whoami"), '42');
  });
}
