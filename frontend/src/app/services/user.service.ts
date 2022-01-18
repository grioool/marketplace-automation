import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../classes/user';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root',
})
export class UserService{

  private url = environment.apiHost;
  constructor(private http: HttpClient){ }

  public getUsers(){
    return this.http.get<Array<User>>(this.url + '/users');
  }

  public getUser(id: string){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.get<User>(this.url + '/user' + id);
  }

  public createUser(user: User){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<User>(this.url + '/user', JSON.stringify(user), {headers: myHeaders});
  }
  public updateUser(user: User) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<User>(this.url + '/user', JSON.stringify(user), {headers:myHeaders});
  }

  public deleteUser(id: number){
    return this.http.delete<User>(this.url + '/user/' + id);
  }

}
