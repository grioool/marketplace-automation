export class Sale {

    constructor(
        public gNumber: string,
        public number: string,
        public date: number,
        public lastChangeDate: number,
        public supplierArticle: string,
        public techSize: string,
        public barcode: string,
        public quantity: number,
        public totalPrice:number,
        public discountPercent: number,
        public isSupply: boolean,
        public isRealization: boolean,
        public promoCodeDiscount: number,
        public warehouseName: string,
        public countryName: string,
        public oblastOkrugName: string,
        public regionName: string,
        public incomeID: number,
        public saleID: string,
        public odid: number,
        public spp: number,
        public forpay: number,
        public finishedPrice: number,
        public pricewithdisc: number,
        public nmid: number,
        public subject: string,
        public category: string,
        public brand: string,
    ) { }

}
