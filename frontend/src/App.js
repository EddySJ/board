import React, { Component } from 'react';
import TodoListTemplate from './components/TodoListTemplate';
import Form from './components/Form';
import TodoItemList from './components/TodoItemList';
import axios from 'axios';


class App extends Component {

  state = {
    input: '',
    todos: [
    ]
  }

  componentDidMount() {
    const url = 'http://localhost:8080/todo/getAll';
    axios.get(url)
        .then(response => response.data)
        .then(response => response.data)
        .then(data => this.setState({todos: data}))
        .catch(err => console.log(err))
  }

  handleInitInfo() {
    const url = 'http://localhost:8080/todo/getAll';
    axios.get(url)
        .then(response => response.data)
        .then(response => response.data)
        .then(data => this.setState({input: '', todos: data}))
        .catch(err => console.log(err))
  }

  handleChange = (e) => {
    this.setState({
      input: e.target.value // input 의 다음 바뀔 값
    });
  }

  handleCreate = () => {
    const { input, todos } = this.state;
    if (input === "") {
        alert("할 일을 입력해주세요!");
        return;
    }

    const request = {
        text: input,
        completed: false
    }
    const url = 'http://localhost:8080/todo/create';
    axios.post(url, request)
        .then(response => {
            if (!response.success) {
                return this.handleInitInfo();
            } else {
                throw new Error(response)
            }
        })
  }

  handleKeyPress = (e) => {
    // 눌려진 키가 Enter 면 handleCreate 호출
    if(e.key === 'Enter') {
      this.handleCreate();
    }
  }

  handleToggle = (id) => {
    const { todos } = this.state;

    // 파라미터로 받은 id 를 가지고 몇번째 아이템인지 찾습니다.
    const index = todos.findIndex(todo => todo.id === id);
    const selected = todos[index]; // 선택한 객체

    const request = {
        id: id,
        text: selected.text,
        completed: !selected.completed
    }

    const url = 'http://localhost:8080/todo/update';
    axios.post(url, request)
        .then(response => {
            if (!response.success) {
                return this.handleInitInfo();
            } else {
                throw new Error(response)
            }
        })
  }

  handleRemove = (id) => {
    const { todos } = this.state;

    const url = 'http://localhost:8080/todo/delete?id='+id;
    axios.post(url)
        .then(response => {
            if (!response.success) {
                return this.handleInitInfo();
            } else {
                throw new Error(response)
            }
        })
  }

  render() {
    const { input, todos } = this.state;
    const {
      handleChange,
      handleCreate,
      handleKeyPress,
      handleToggle,
      handleRemove
    } = this;

    return (
      <TodoListTemplate form={(
        <Form
          value={input}
          onKeyPress={handleKeyPress}
          onChange={handleChange}
          onCreate={handleCreate}
        />
      )}>
        <TodoItemList todos={todos} onToggle={handleToggle} onRemove={handleRemove}/>
      </TodoListTemplate>
    );
  }
}

export default App;