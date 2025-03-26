import {Component} from '@angular/core';
import {Todo, TodoCategory} from '../../models/todo';
import {NgClass} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-todo-list',
  imports: [
    NgClass,
    FormsModule
  ],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss'
})
export class TodoListComponent {
  categories: Array<TodoCategory> = [TodoCategory.TODO, TodoCategory.IN_PROGRESS, TodoCategory.DONE]
  todos: Array<Todo> = [
    {
      title: "firstTodo",
      description: "",
      category: TodoCategory.TODO
    },
    {
      title: "secondTodo",
      description: "desc",
      category: TodoCategory.IN_PROGRESS
    },
    {
      title: "firstTodo",
      description: "",
      category: TodoCategory.DONE
    }
  ]
  isTodoFormHidden: boolean = true
  newTodo: Todo = {
    title: "",
    description: "",
    category: undefined
  }

  addClassTodo(cat: TodoCategory): string {
    switch (cat) {
      case TodoCategory.TODO:
        return "bg-green-500"
      case TodoCategory.IN_PROGRESS:
        return "bg-purple-500"
      case TodoCategory.DONE:
        return "bg-red-500"
    }
  }

  filterTodoByCat(cat: TodoCategory) {
    return this.todos.filter(t => t.category === cat)
  }

  deleteTodo(todo: Todo) {
    this.todos.splice(this.todos.indexOf(todo), 1)
  }

  showTodoForm(cat: TodoCategory) {
    this.newTodo.category = cat
    this.isTodoFormHidden = false
  }

  closeTodoForm() {
    this.isTodoFormHidden = true
  }

  addTodo(cat: TodoCategory) {
    this.todos.push({
      title: "new Todo",
      description: "new Desc",
      category: cat
    })
  }

  createTodo() {
    this.todos.push(this.newTodo)
    this.newTodo = {
      title: "",
      description: "",
      category: undefined
    }
    this.closeTodoForm()
  }

  protected readonly TodoCategory = TodoCategory;
}
