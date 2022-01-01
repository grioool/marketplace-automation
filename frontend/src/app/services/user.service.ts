import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../classes/user';

@Injectable({
  providedIn: 'root',
})
export class UserService{

  private url = "http://localhost:8080";
  constructor(private http: HttpClient){ }

  getUsers(){
    return this.http.get<Array<User>>(this.url + '/users');
  }

  getUser(id: string){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.get<User>(this.url + '/user' + id);
  }

  createUser(user: User){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<User>(this.url + '/user', JSON.stringify(user), {headers: myHeaders});
  }
  updateUser(user: User) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<User>(this.url + '/user', JSON.stringify(user), {headers:myHeaders});
  }

  deleteUser(id: number){
    return this.http.delete<User>(this.url + '/user/' + id);
  }
}
