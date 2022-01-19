import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, ReplaySubject, Subject, tap} from "rxjs";
import {environment} from "../../environments/environment";
import {Order} from "../classes/order";

@Injectable({
    providedIn: 'root',
})
export class OrderService {

    private url = environment.apiHost;

    private isLoaded: boolean = false;

    private loadedOrders: Subject<Order[]> = new ReplaySubject<Order[]>(1);

    constructor(private http: HttpClient) {
        this.loadedOrders.subscribe(() => this.isLoaded = true);
    }

    public getLoadedOrders(): Observable<Order[]> {
        if(!this.isLoaded)
            this.getOrders().subscribe();
        return this.loadedOrders.asObservable();
    }

    public getOrders(): Observable<Order[]> {
        return this.http.get<Order[]>(this.url + '/orders')
            .pipe(tap(orders => this.loadedOrders.next(orders)));
    }

}
