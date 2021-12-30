import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {User} from './user';
import {UserService} from './user.service';
import {Role} from "./role";
import {isPresent} from "../util";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontend';


  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>|undefined;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>|undefined;

  editedUser: User = null;
  users: Array<User>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: UserService) {
    this.users = new Array<User>();
  }

  ngOnInit() {
    this.loadUsers();
  }

  private loadUsers() {
    this.serv.getUsers().subscribe((data: Array<User>) => {
      this.users = data;
    });
  }

  addUser() {
    this.editedUser = new User(-1,"", "","","","", Role.USER, false, false);
    this.users.push(this.editedUser);
    this.isNewRecord = true;
  }

  editUser(user: User) {
    this.editedUser = new User(user._id, user.name, user.email, user.password, user.wildBerriesKeys, user.ozonKey, user.role, user.isBlocked, user.isSubscribed);
  }

  loadTemplate(user: User) {
    if (this.editedUser && this.editedUser._id === user._id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveUser() {
    if (this.isNewRecord) {
      this.serv.createUser(this.editedUser as User).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены';
          this.loadUsers();
      });
      this.isNewRecord = false;
      this.editedUser = null;
    } else {
      this.serv.updateUser(this.editedUser as User).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены';
          this.loadUsers();
      });
      this.editedUser = null;
    }
  }

  cancel() {
    if (this.isNewRecord) {
      this.users.pop();
      this.isNewRecord = false;
    }
    this.editedUser = null;
  }

  deleteUser(user: User) {
    this.serv.deleteUser(user._id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены';
        this.loadUsers();
    });
  }

  public isReadOnly(user: User): boolean {
    return !this.isEditable(user);
  }

  public isEditable(user: User): boolean {
    return isPresent(this.editedUser) && this.editedUser._id === user._id;
  }
}
