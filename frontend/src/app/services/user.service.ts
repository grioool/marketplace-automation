import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../classes/user';
import {environment} from "../../environments/environment";
import {Observable, ReplaySubject, Subject, tap} from "rxjs";

@Injectable({
    providedIn: 'root',
})
export class UserService {

    private url = environment.apiHost;


    private isLoaded: boolean = false;

    private loadedUsers: Subject<User[]> = new ReplaySubject<User[]>(1);

    constructor(private http: HttpClient) {
        this.loadedUsers.subscribe(() => this.isLoaded = true);
    }

    public getUser(id: string) {
        return this.http.get<User>(this.url + '/user' + id);
    }

    public createUser(user: User) {
        return this.http.post<User>(this.url + '/user', user);
    }

    public updateUser(user: User) {
        return this.http.put<User>(this.url + '/user', user);
    }

    public deleteUser(id: number) {
        return this.http.delete<User>(this.url + '/user/' + id);
    }

    public getLoadedUsers(): Observable<User[]> {
        if (!this.isLoaded)
            this.getUsers().subscribe();
        return this.loadedUsers.asObservable();
    }

    public getUsers(): Observable<User[]> {
        return this.http.get<User[]>(this.url + '/users')
            .pipe(tap(users => this.loadedUsers.next(users)));
    }

}
