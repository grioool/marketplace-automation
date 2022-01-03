import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Purchase} from '../../classes/purchase';
import {PurchaseService} from '../../services/purchase.service';
import {isPresent} from "../../../util";

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

  constructor(private serv: PurchaseService) {
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

  addPurchase() {
    this.editedPurchase = new Purchase(-1,0,"",0, 0, 0, 0,0,0, 0);
    this.purchases.push(this.editedPurchase);
    this.isNewRecord = true;
  }

  editPurchase(purchase: Purchase) {
    this.editedPurchase = new Purchase(purchase._id, purchase.date, purchase.productName, purchase.priceForOne, purchase.amount, purchase.purchasePrice, purchase.logistics, purchase.costPrice, purchase.batchPrice, purchase.extra);
  }

  loadTemplate(purchase: Purchase) {
    if (this.editedPurchase && this.editedPurchase._id === purchase._id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  savePurchase() {
    if (this.isNewRecord) {
      this.serv.createPurchase(this.editedPurchase as Purchase).subscribe(data => {
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

  cancel() {
    if (this.isNewRecord) {
      this.purchases.pop();
      this.isNewRecord = false;
    }
    this.editedPurchase = null;
  }

  deletePurchase(id: number) {
    this.serv.deletePurchase(id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены';
        this.loadPurchases();
    });
  }

  public isReadOnly(purchase: Purchase): boolean {
    return !this.isEditable(purchase);
  }

  public isEditable(purchase: Purchase): boolean {
    return isPresent(this.editedPurchase) && this.editedPurchase._id === purchase._id;
  }
}
