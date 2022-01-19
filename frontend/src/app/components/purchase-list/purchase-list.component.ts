import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Purchase} from '../../classes/purchase';
import {PurchaseService} from '../../services/purchase.service';
import {isPresent} from "../../../util";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'purchase-root',
  templateUrl: './purchase-list.component.html',
  styleUrls: ['./purchase-list.component.css']
})
export class PurchaseList implements OnInit {
  title = 'frontend';

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>|undefined;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>|undefined;

  editedPurchase: Purchase = null;
  purchases: Array<Purchase>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: PurchaseService,
              private location: Location) {
    this.purchases = new Array<Purchase>();
  }

  ngOnInit() {
    this.loadPurchases();
  }

  private loadPurchases() {
    this.serv.getPurchases().subscribe((data: Array<Purchase>) => {
      this.purchases = data;
    });
  }

  public addPurchase() {
    this.editedPurchase = new Purchase(0, 0,"",0, 0, 0, 0,0,0, 0);
    this.purchases.push(this.editedPurchase);
    this.isNewRecord = true;
  }

  public editPurchase(purchase: Purchase) {
    this.editedPurchase = new Purchase(purchase.id, purchase.date, purchase.productName, purchase.priceForOne, purchase.amount, purchase.purchasePrice, purchase.logistics, purchase.costPrice, purchase.batchPrice, purchase.extra);
  }

  public loadTemplate(purchase: Purchase) {
    if (this.editedPurchase && this.editedPurchase.id === purchase.id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  public savePurchase() {
    if (this.isNewRecord) {
      this.serv.createPurchase(this.editedPurchase).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены';
          this.loadPurchases();
      });
      this.isNewRecord = false;
      this.editedPurchase = null;
    } else {
      this.serv.updatePurchase(this.editedPurchase as Purchase).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены';
          this.loadPurchases();
      });
      this.editedPurchase = null;
    }
  }

  public cancel() {
    if (this.isNewRecord) {
      this.purchases.pop();
      this.isNewRecord = false;
    }
    this.editedPurchase = null;
  }

  public deletePurchase(id: number) {
    this.serv.deletePurchase(id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены';
        this.loadPurchases();
    });
  }

  public isReadOnly(purchase: Purchase): boolean {
    return !this.isEditable(purchase);
  }

  public isEditable(purchase: Purchase): boolean {
    return isPresent(this.editedPurchase) && this.editedPurchase.id === purchase.id;
  }

  public back(): void {
      this.location.back();
  }
}
