import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Purchase} from '../classes/purchase';

@Injectable({
  providedIn: 'root',
})
export class PurchaseService {

  private url = "http://localhost:8080";
  constructor(private http: HttpClient){ }

  getPurchases(){
    return this.http.get<Array<Purchase>>(this.url + '/purchases');
  }

  createPurchase(purchase: Purchase){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Purchase>(this.url + '/purchase', JSON.stringify(purchase), {headers: myHeaders});
  }
  updatePurchase(purchase: Purchase) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Purchase>(this.url + '/purchase', JSON.stringify(purchase), {headers:myHeaders});
  }
  deletePurchase(id: number){
    return this.http.delete<Purchase>(this.url + '/purchase/' + id);
  }
}
