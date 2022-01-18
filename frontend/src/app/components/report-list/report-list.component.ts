import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Report} from '../../classes/report';
import {ReportService} from '../../services/report.service';
import {isPresent} from "../../../util";
import {Supply} from "../../classes/supply";
import {SupplyService} from "../../services/supply.service";

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

    public supplies: Supply[] = [];

  constructor(private serv: ReportService,
              public supplyService: SupplyService) {
    this.reports = new Array<Report>();
      this.supplyService.getLoadedSupplies()
          .subscribe((supplies: Supply[]) => this.supplies = supplies);
  }

  ngOnInit() {
    this.loadReports();
  }

  private loadReports() {
    this.serv.getReports().subscribe((data: Array<Report>) => {
      this.reports = data;
    });
  }

  public addReport() {
    this.editedReport = new Report(-1,0,"",0, 0, 0, 0,0,0, 0, 0,0,0, null);
    this.reports.push(this.editedReport);
    this.isNewRecord = true;
  }

  public editReport(report: Report) {
    this.editedReport = new Report(report.id, report.orderNumber, report.name, report.orderPrice, report.proceeds, report.logistics, report.costPrice, report.commission, report.profit, report.commissionPerCent, report.commissionVAT, report.dateSale, report.dateOrder, report.supply);
  }

  public loadTemplate(report: Report) {
    if (this.editedReport && this.editedReport.id === report.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  public saveReport() {
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

  public cancel() {
    if (this.isNewRecord) {
      this.reports.pop();
      this.isNewRecord = false;
    }
    this.editedReport = null;
  }

  public deleteReport(id: number) {
    this.serv.deleteReport(id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены';
        this.loadReports();
    });
  }

  public isReadOnly(report: Report): boolean {
    return !this.isEditable(report);
  }

  public isEditable(report: Report): boolean {
    return isPresent(this.editedReport) && this.editedReport.id === report.id;
  }
}
