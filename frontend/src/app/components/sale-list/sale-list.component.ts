import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Sale} from "../../classes/sale";
import {SaleService} from "../../services/sale.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-sale',
  templateUrl: './sale-list.component.html',
  styleUrls: ['./sale-list.component.css']
})
export class SaleListComponent implements OnInit {

    title = 'frontend';

    @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>|undefined;
    @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>|undefined;

    sales: Array<Sale>;
    isNewRecord: boolean = false;
    statusMessage: string = "";

    constructor(private serv: SaleService,
                private location: Location) {
        this.sales = new Array<Sale>();
    }

    ngOnInit() {
        this.loadSales();
    }

    private loadSales() {
        this.serv.getSales().subscribe((data: Array<Sale>) => {
            this.sales = data;
        });
    }

    public back(): void {
        this.location.back();
    }
}
