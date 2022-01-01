import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Report} from "../classes/report";

@Injectable({
  providedIn: 'root',
})
export class ReportService {

  private url = "http://localhost:8080";
  constructor(private http: HttpClient){ }

  getReports(){
    return this.http.get<Array<Report>>(this.url + '/reports');
  }

  createReport(report: Report){
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.post<Report>(this.url + '/report', JSON.stringify(report), {headers: myHeaders});
  }
  updateReport(report: Report) {
    const myHeaders = new HttpHeaders().set("Content-Type", "application/json");
    return this.http.put<Report>(this.url + '/report', JSON.stringify(report), {headers:myHeaders});
  }
  deleteReport(id: number){
    return this.http.delete<Report>(this.url + '/report/' + id);
  }
}
