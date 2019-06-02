import 'package:flutter/material.dart';
import 'dart:async';

import 'package:fshell_android/fshell_android.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Column(
            children: <Widget>[
              // This is just a test for SOME commands
              new MaterialButton(
                  onPressed: () async {
                    String result = await FShellAndroid.echo(1.toString());
                    print(result);
                  },
                  child: new Text('Echo 1'),
              ),
              new MaterialButton(
                onPressed: () async {
                  String result = await FShellAndroid.executeCommand("whoami");
                  print(result);
                },
                child: new Text('Whoami'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
