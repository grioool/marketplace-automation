import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, ReplaySubject, Subject, tap} from "rxjs";
import {environment} from "../../environments/environment";
import {Sale} from "../classes/sale";

@Injectable({
    providedIn: 'root',
})
export class SaleService {

    private url = environment.apiHost;

    private isLoaded: boolean = false;

    private loadedSales: Subject<Sale[]> = new ReplaySubject<Sale[]>(1);

    constructor(private http: HttpClient) {
        this.loadedSales.subscribe(() => this.isLoaded = true);
    }

    public getLoadedSales(): Observable<Sale[]> {
        if(!this.isLoaded)
            this.getSales().subscribe();
        return this.loadedSales.asObservable();
    }

    public getSales(): Observable<Sale[]> {
        return this.http.get<Sale[]>(this.url + '/sales')
            .pipe(tap(sales => this.loadedSales.next(sales)));
    }

}
