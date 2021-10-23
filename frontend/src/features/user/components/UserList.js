import axios from 'axios';
import React, { useEffect,useState } from 'react';
import { UserListForm } from '..';


export default function UserList() {
  const [ list, setList] = useState([])
  const SERVER = 'http://localhost:8080'
  const fetchList = () => { //이벤트 e 가 없어도 자동 실행하라는..
    axios.get(`${SERVER}/users`)
    .then(res => setList(res.data))
    .catch(err => console.log(err))
  }
  useEffect(() => { //즉시실행
    fetchList()
  },[]) //줄어들지않고 담긴다. 리스트가 두개면 명시해줘야한다.

  return (
    <div>
      <h1>User List</h1>
      <UserListForm list = {list}/>
    </div>
  );
}
