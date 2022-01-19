import {Purchase} from "./purchase";
import {Storage} from "./storage";

export class Supply {
  constructor(
    public id: number,
    public purchase: Purchase,
    public storage: Storage,
    public date: number,
    public product: string,
    public amount: number,
    public logistics: number,
    public purchasePrice: number,
    public fulfillment: number,
    public costPrice: number
  ) { }
}
