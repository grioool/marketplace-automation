import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../classes/user';

@Injectable({
  providedIn: 'root',
})
export class UserService{

  private url = "http://localhost:8080/user";
  constructor(private http: HttpClient){ }

  getUsers(){
    return this.http.get<Array<User>>(this.url + "s");
  }

  getUser(id: number){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.get<User>(this.url);
  } //TODO

  createUser(user: User){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<User>(this.url, JSON.stringify(user), {headers: myHeaders});
  }
  updateUser(user: User) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<User>(this.url, JSON.stringify(user), {headers:myHeaders});
  }
  deleteUser(user: User){
    return this.http.delete<User>(this.url);
  }
}
