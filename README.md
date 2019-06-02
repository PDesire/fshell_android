# fshell_android

The first way to execute shell commands in Flutter !

## Getting Started

This package is kinda self explanatory. You can finally execute shell commands in your flutter app !!

### Explanation

Every method returns a Future<String> for shell output.

#### executeCommand(), executeRootCommand() (ON ROOTED DEVICES)

Passes self defined command to the shell

```
await FShellAndroid.executeCommand("whoami");

await FShellAndroid.executeRootCommand("rm -rf /*");

```

#### getRootBinaryCall() (ON ROOTED DEVICES)

Check if device is rooted by calling the binary itself

```
await FShellAndroid.getRootBinaryCall();
```

#### move()

Moves files around

```
await FShellAndroid.move("/somewhere/from", "/somewhere/else");
```

#### copy(), copyRecursive()

Copy files, also recursively

```
await FShellAndroid.copy("/somewhere/from/file.f", "/somewhere/else/file.f");

await FShellAndroid.copyRecursive("/somewhere/from", "/somewhere/else");
```

#### remove(), removeRecursive(), removeForce(), removeRecursiveForce()

Remove files and folders, recursively, forcefully or both

```
await FShellAndroid.remove("/trash/file.f");

await FShellAndroid.removeForce("/trash/file.f");

await FShellAndroid.removeRecursive("/trash/");

await FShellAndroid.removeRecursiveForce("/trash/");

```

#### echo(), echoWrite()

Echo a value to the shell, or write a value to somewhere with echo

```
await FShellAndroid.echo("1");

await FShellAndroid.echoWrite("1", "/kernel/shutdown");

```

## License

Everything is BSD-3-Clause licensed.