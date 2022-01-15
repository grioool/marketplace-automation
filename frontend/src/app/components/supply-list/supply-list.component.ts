import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {Supply} from '../../classes/supply';
import {isPresent} from "../../../util";
import {SupplyService} from "../../services/supply.service";
import {Purchase} from "../../classes/purchase";

@Component({
  selector: 'supply-root',
  templateUrl: './supply-list.component.html',
  styleUrls: ['./supply-list.component.css']
})
export class SupplyList implements OnInit {
  title = 'frontend';

  @ViewChild('readOnlyTemplate', {static: false}) readOnlyTemplate: TemplateRef<any>|undefined;
  @ViewChild('editTemplate', {static: false}) editTemplate: TemplateRef<any>|undefined;

  editedSupply: Supply = null;
  supplies: Array<Supply>;
  isNewRecord: boolean = false;
  statusMessage: string = "";

  constructor(private serv: SupplyService) {
    this.supplies = new Array<Supply>();
  }

  ngOnInit() {
    this.loadSupplies();
  }

  private loadSupplies() {
    this.serv.getSupplies().subscribe((data: Array<Supply>) => {
      this.supplies = data;
    });
  }

  addSupply() {
   // this.editedSupply = new Supply(-1, 0,0,"", 0, 0, 0,0,0);
    this.supplies.push(this.editedSupply);
    this.isNewRecord = true;
  }

  editSupply(supply: Supply) {
    this.editedSupply = new Supply(supply._id, supply.purchase, supply.storage, supply.date, supply.product, supply.amount, supply.logistics, supply.purchasePrice, supply.fulfillment, supply.costPrice);
  }

  loadTemplate(supply: Supply) {
    if (this.editedSupply && this.editedSupply._id === supply._id) {
      return this.editTemplate;
    } else {
      return this.readOnlyTemplate;
    }
  }

  saveSupply() {
    if (this.isNewRecord) {
      this.serv.createSupply(this.editedSupply as Supply).subscribe(data => {
        this.statusMessage = 'Данные успешно добавлены';
          this.loadSupplies();
      });
      this.isNewRecord = false;
      this.editedSupply = null;
    } else {
      this.serv.updateSupply(this.editedSupply as Supply).subscribe(data => {
        this.statusMessage = 'Данные успешно обновлены';
          this.loadSupplies();
      });
      this.editedSupply = null;
    }
  }

  cancel() {
    if (this.isNewRecord) {
      this.supplies.pop();
      this.isNewRecord = false;
    }
    this.editedSupply = null;
  }

  deletePurchase(id: number) {
    this.serv.deleteSupply(id).subscribe(data => {
      this.statusMessage = 'Данные успешно удалены';
        this.loadSupplies();
    });
  }

  public isReadOnly(supply: Supply): boolean {
    return !this.isEditable(supply);
  }

  public isEditable(supply: Supply): boolean {
    return isPresent(this.editedSupply) && this.editedSupply._id === supply._id;
  }
}
