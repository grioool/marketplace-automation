import {Supply} from "./supply";

export class Report {

  constructor(
    public id: number,
    public orderNumber: number,
    public name: string,
    public orderPrice: number,
    public proceeds: number,
    public logistics: number,
    public costPrice: number,
    public commission: number,
    public profit: number,
    public commissionPerCent: number,
    public commissionVAT: number,
    public dateSale: number,
    public dateOrder: number,
    public supply: Supply
  ) { }

}
