import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Supply} from '../classes/supply';
import {Observable, ReplaySubject, Subject, tap} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
    providedIn: 'root',
})
export class SupplyService {

    private url = environment.apiHost;

    private isLoaded: boolean = false;

    private loadedSupplies: Subject<Supply[]> = new ReplaySubject<Supply[]>(1);


    constructor(private http: HttpClient) {
        this.loadedSupplies.subscribe(() => this.isLoaded = true);
    }

    public createSupply(supply: Supply) {
        return this.http.post<Supply>(this.url + '/supply', supply);
    }

    public updateSupply(supply: Supply) {
        return this.http.put<Supply>(this.url + '/supply', supply);
    }

    public deleteSupply(id: number) {
        return this.http.delete<Supply>(this.url + '/supply/' + id);
    }

    public getLoadedSupplies(): Observable<Supply[]> {
        if (!this.isLoaded)
            this.getSupplies().subscribe();
        return this.loadedSupplies.asObservable();
    }

    public getSupplies(): Observable<Supply[]> {
        return this.http.get<Supply[]>(this.url + '/supplies')
            .pipe(tap(supplies => this.loadedSupplies.next(supplies)));
    }

}
