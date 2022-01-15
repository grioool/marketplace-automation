package by.sam_solutions.grigorieva.olga.backend.controller.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderWBDto {

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

    @JsonProperty("warehouseName")
    private String warehouseName;

    @JsonProperty("oblast")
    private String oblast;

    @JsonProperty("incomeID")
    private String incomeID;

    @JsonProperty("odid")
    private String odid;

    @JsonProperty("nmId")
    private String nmId;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("category")
    private String category;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("isCancel")
    private String isCancel;

    @JsonProperty("cancel_dt")
    private String cancel_dt;

    @JsonProperty("gNumber")
    private String gNumber;

}
