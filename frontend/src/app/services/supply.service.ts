import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Supply} from '../classes/supply';

@Injectable({
  providedIn: 'root',
})
export class SupplyService {

  private url = "http://localhost:8080";
  constructor(private http: HttpClient){ }

  getSupplies(){
    return this.http.get<Array<Supply>>(this.url + '/supplies');
  }

  createSupply(supply: Supply){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Supply>(this.url + '/supply', JSON.stringify(supply), {headers: myHeaders});
  }
  updateSupply(supply: Supply) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Supply>(this.url + '/supply', JSON.stringify(supply), {headers:myHeaders});
  }
  deleteSupply(id: number){
    return this.http.delete<Supply>(this.url + '/supply/' + id);
  }
}
