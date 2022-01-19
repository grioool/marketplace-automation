import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {User} from '../../classes/user';
import {UserService} from '../../services/user.service';
import {isPresent} from "../../../util";
import {Location} from "@angular/common";

@Component({
    selector: 'users-list',
    templateUrl: './user-list.component.html',
    styleUrls: ['./user-list.component.css']
})

export class UserList implements OnInit {
    title = 'frontend';


    @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any> | undefined;
    @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any> | undefined;

    public editedUser: User = null;

    public users: User[];

    public isNewRecord: boolean = false;

    public statusMessage: string = "";

    constructor(private userService: UserService,
                private location: Location) {
        this.users = new Array<User>();
        this.userService.getLoadedUsers()
            .subscribe((users: User[]) => this.users = users);
    }

    ngOnInit() {
        this.loadUsers();
    }

    public loadUsers() {
        this.userService.getUsers().subscribe((data: Array<User>) => {
            this.users = data;
        });
    }

    public addRoleToUser() {

    }

    public addUser() {
        this.editedUser = new User(0, "", "", "", "", "", "", "", false, false);
        this.users.push(this.editedUser);
        this.isNewRecord = true;
    }

    public editUser(user: User) {
        this.editedUser = new User(user.id, user.name, user.email, user.password, user.username, user.nameCompany, user.wildBerriesKeys, user.ozonKey, user.isBlocked, user.isSubscribed);
    }

    public loadTemplate(user: User) {
        if (this.editedUser && this.editedUser.id === user.id) {
            return this.editTemplate;
        } else {
            return this.readOnlyTemplate;
        }
    }

    public saveUser() {
        if (this.isNewRecord) {
            this.userService.createUser(this.editedUser).subscribe(data => {
                this.statusMessage = 'Данные успешно добавлены';
                this.loadUsers();
            });
            this.isNewRecord = false;
            this.editedUser = null;
        } else {
            this.userService.updateUser(this.editedUser).subscribe(data => {
                this.statusMessage = 'Данные успешно обновлены';
                this.loadUsers();
            });
            this.editedUser = null;
        }
    }

    public cancel() {
        if (this.isNewRecord) {
            this.users.pop();
            this.isNewRecord = false;
        }
        this.editedUser = null;
    }

    public deleteUser(id: number) {
        this.userService.deleteUser(id).subscribe(data => {
            this.statusMessage = 'Данные успешно удалены';
            this.loadUsers();
        });
    }

    public isReadOnly(user: User): boolean {
        return !this.isEditable(user);
    }

    public isEditable(user: User): boolean {
        return isPresent(this.editedUser) && this.editedUser.id === user.id;
    }

    public back(): void {
        this.location.back();
    }

}
