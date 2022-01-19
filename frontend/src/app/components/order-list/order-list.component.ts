import {Component, OnInit, TemplateRef, ViewChild} from "@angular/core";
import {Order} from "../../classes/order";
import {OrderService} from "../../services/order.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-order',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
    title = 'frontend';

    @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>|undefined;
    @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>|undefined;

    orders: Array<Order>;
    isNewRecord: boolean = false;
    statusMessage: string = "";

    constructor(private serv: OrderService,
                private location: Location) {
        this.orders = new Array<Order>();
    }

    ngOnInit() {
        this.loadOrders();
    }

    private loadOrders() {
        this.serv.getOrders().subscribe((data: Array<Order>) => {
            this.orders = data;
        });
    }

    public back(): void {
        this.location.back();
    }

}
