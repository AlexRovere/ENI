class Todo {
  int _id;
  String _title;
  bool _completed;

  Todo(this._id, this._title, this._completed);

  static Todo fromJson(Map<String, dynamic> json) {
    return Todo(json['id'], json['title'], json['completed']);
  }

  Todo.fromJson2(Map<String, dynamic> json) : this(json['id'], json['title'], json['completed']);

  bool get completed => _completed;

  set completed(bool value) {
    _completed = value;
  }

  String get title => _title;

  set title(String value) {
    _title = value;
  }

  int get id => _id;

  set id(int value) {
    _id = value;
  }
}