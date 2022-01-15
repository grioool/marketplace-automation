package by.sam_solutions.grigorieva.olga.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaleWBDto {

    @JsonProperty("number")
    private String number;

    @JsonProperty("date")
    private String date;

    @JsonProperty("lastChangeDate")
    private String lastChangeDate;

    @JsonProperty("supplierArticle")
    private String supplierArticle;

    @JsonProperty("techSize")
    private String techSize;

    @JsonProperty("barcode")
    private String barcode;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("totalPrice")
    private String totalPrice;

    @JsonProperty("discountPercent")
    private String discountPercent;

    @JsonProperty("isSupply")
    private String isSupply;

    @JsonProperty("isRealization")
    private String isRealization;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("promoCodeDiscount")
    private String promoCodeDiscount;

    @JsonProperty("warehouseName")
    private String warehouseName;

    @JsonProperty("countryName")
    private String countryName;

    @JsonProperty("oblastOkrugName")
    private String oblastOkrugName;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("incomeID")
    private String incomeID;

    @JsonProperty("saleID")
    private String saleID;

    @JsonProperty("odid")
    private String odid;

    @JsonProperty("spp")
    private String spp;

    @JsonProperty("forPay")
    private String forPay;

    @JsonProperty("finishedPrice")
    private String finishedPrice;

    @JsonProperty("priceWithDisc")
    private String priceWithDisc;

    @JsonProperty("nmId")
    private String nmId;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("category")
    private String category;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("IsStorno")
    private String IsStorno;

    @JsonProperty("gNumber")
    private String gNumber;

}