import 'dart:convert';

import 'package:demo/todo.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(

        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  Todo? _todo;
  List<Todo> _todos = [];

  @override
  void initState()  {
    super.initState();
    callApi();
  }

  void  callApi() async {
    var response = await http.get(Uri.parse("https://jsonplaceholder.typicode.com/todos/3"));

    if(response.statusCode == 200) {
      setState(() {
        _todo = Todo.fromJson(jsonDecode(response.body));
      });
    }

    var response2 = await http.get(Uri.parse("https://jsonplaceholder.typicode.com/users/1/todos"));
    if(response2.statusCode == 200) {
      setState(() {
        _todos = List<Todo>.from(jsonDecode(response2.body).map((data) => Todo.fromJson(data)).toList());
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(onPressed: callApi, child: Text("appel api")),
            const Text('You have pushed the button this many times:'),
            Text("Contenu de mon objet: ${_todo?.id}"),
            Expanded(child:  ListView.builder(
                itemCount: _todos.length,
                itemBuilder: (BuildContext context, int index) {
                  return ListTile(
                    title: Text(_todos[index].title),
                    leading: _todos[index].completed ? Icon(Icons.check) : Icon(Icons.check_box_outline_blank),
                  );
                }
            )),
          ],
        ),
      ),
    );
  }
}
