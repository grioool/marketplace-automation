import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Report} from '../../classes/report';
import {ReportService} from '../../services/report.service';
import {isPresent} from "../../../util";
import {Supply} from "../../classes/supply";

@Component({
  selector: 'purchase-root',
  templateUrl: './report-list.component.html',
  styleUrls: ['./report-list.component.css']
})
export class ReportList implements OnInit {
  title = 'frontend';

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>|undefined;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>|undefined;

  editedReport: Report = null;
  reports: Array<Report>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: ReportService) {
    this.reports = new Array<Report>();
  }

  ngOnInit() {
    this.loadReports();
  }

  private loadReports() {
    this.serv.getReports().subscribe((data: Array<Report>) => {
      this.reports = data;
    });
  }

  addReport() {
  //  this.editedReport = new Report(-1,0,"",0, 0, 0, 0,0,0, 0, 0,0,0,Supply); TODO
    this.reports.push(this.editedReport);
    this.isNewRecord = true;
  }

  editReport(report: Report) {
    this.editedReport = new Report(report._id, report.orderNumber, report.name, report.orderPrice, report.proceeds, report.logistics, report.costPrice, report.commission, report.profit, report.commissionPerCent, report.commissionVAT, report.dateSale, report.dateOrder, report.supply);
  }

  loadTemplate(report: Report) {
    if (this.editedReport && this.editedReport._id === report._id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveReport() {
    if (this.isNewRecord) {
      this.serv.createReport(this.editedReport as Report).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены';
          this.loadReports();
      });
      this.isNewRecord = false;
      this.editedReport = null;
    } else {
      this.serv.updateReport(this.editedReport as Report).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены';
          this.loadReports();
      });
      this.editedReport = null;
    }
  }

  cancel() {
    if (this.isNewRecord) {
      this.reports.pop();
      this.isNewRecord = false;
    }
    this.editedReport = null;
  }

  deleteReport(id: number) {
    this.serv.deleteReport(id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены';
        this.loadReports();
    });
  }

  public isReadOnly(report: Report): boolean {
    return !this.isEditable(report);
  }

  public isEditable(report: Report): boolean {
    return isPresent(this.editedReport) && this.editedReport._id === report._id;
  }
}
