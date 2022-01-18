import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Purchase} from '../classes/purchase';
import {BehaviorSubject, Observable, ReplaySubject, Subject, tap} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
    providedIn: 'root',
})
export class PurchaseService {

    private url = environment.apiHost;

    private isLoaded: boolean = false;

    private loadedPurchases: Subject<Purchase[]> = new ReplaySubject<Purchase[]>(1);

    constructor(private http: HttpClient) {
        this.loadedPurchases.subscribe(() => this.isLoaded = true);
    }

    public getLoadedPurchases(): Observable<Purchase[]> {
        if(!this.isLoaded)
            this.getPurchases().subscribe();
        return this.loadedPurchases.asObservable();
    }

    public getPurchases(): Observable<Purchase[]> {
        return this.http.get<Purchase[]>(this.url + '/purchases')
            .pipe(tap(purchases => this.loadedPurchases.next(purchases)));
    }

    public createPurchase(purchase: Purchase) {
        return this.http.post<Purchase>(this.url + '/purchase', purchase);
    }

    public updatePurchase(purchase: Purchase) {
        return this.http.put<Purchase>(this.url + '/purchase', purchase);
    }

    public deletePurchase(id: number) {
        return this.http.delete<Purchase>(this.url + '/purchase/' + id);
    }
}
