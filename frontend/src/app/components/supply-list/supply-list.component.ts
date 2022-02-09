import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Supply} from '../../classes/supply';
import {isPresent} from "../../../util";
import {SupplyService} from "../../services/supply.service";
import {Purchase} from "../../classes/purchase";
import {PurchaseService} from "../../services/purchase.service";
import {Storage} from "../../classes/storage";
import {StorageService} from "../../services/storage.service";
import {Location} from "@angular/common";
import {TablePage} from "../../classes/table-page";
import {User} from "../../classes/user";

@Component({
    selector: 'supply-root',
    templateUrl: './supply-list.component.html',
    styleUrls: ['./supply-list.component.css']
})
export class SupplyList implements OnInit {
    title = 'frontend';

    @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any> | undefined;
    @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any> | undefined;

    public editedSupply: Supply = null;

    public supplies: Supply[];

    public isNewRecord: boolean = false;

    public statusMessage: string = "";

    public purchases: Purchase[] = [];

    public storages: Storage[] = [];

    public totalAmount: number = 0;

    public amountOnPage: number = 5;

    constructor(private serv: SupplyService,
                public purchaseService: PurchaseService,
                public storageService: StorageService,
                private location: Location) {
        this.supplies = new Array<Supply>();
    }

    ngOnInit() {
        this.loadSupplies();
    }

    private loadSupplies() {
        this.setPageSelected(0);
    }

    public addSupply() {
        this.editedSupply = new Supply(0, null, null, 0, "", 0, 0, 0, 0, 0);
        this.supplies.push(this.editedSupply);
        this.isNewRecord = true;
    }

    public editSupply(supply: Supply) {
        this.editedSupply = new Supply(supply.id, supply.purchase, supply.storage, supply.date, supply.product, supply.amount, supply.logistics, supply.purchasePrice, supply.fulfillment, supply.costPrice);
    }

    public loadTemplate(supply: Supply) {
        if (this.editedSupply && this.editedSupply.id === supply.id) {
            return this.editTemplate;
        } else {
            return this.readOnlyTemplate;
        }
    }

    public saveSupply() {
        if (this.isNewRecord) {
            this.serv.createSupply(this.editedSupply).subscribe(data => {
                this.statusMessage = 'Данные успешно добавлены';
                this.loadSupplies();
            });
            this.isNewRecord = false;
            this.editedSupply = null;
        } else {
            this.serv.updateSupply(this.editedSupply).subscribe(data => {
                this.statusMessage = 'Данные успешно обновлены';
                this.loadSupplies();
            });
            this.editedSupply = null;
        }
    }

    public cancel() {
        if (this.isNewRecord) {
            this.supplies.pop();
            this.isNewRecord = false;
        }
        this.editedSupply = null;
    }

    public deleteSupply(id: number) {
        this.serv.deleteSupply(id).subscribe(data => {
            this.statusMessage = 'Данные успешно удалены';
            this.loadSupplies();
        });
    }

    public isReadOnly(supply: Supply): boolean {
        return !this.isEditable(supply);
    }

    public isEditable(supply: Supply): boolean {
        return isPresent(this.editedSupply) && this.editedSupply.id === supply.id;
    }

    public back(): void {
        this.location.back();
    }

    public setPageSelected(shift: number): void {
        this.serv.getByPage(shift, this.amountOnPage)
            .subscribe((page: TablePage<Supply>) => {
                this.supplies = page.items;
                this.totalAmount = page.totalCount;
            })
    }
}
