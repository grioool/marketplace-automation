package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
public class PurchaseDto {

    public static Purchase toEntity(PurchaseDto dto) {
        Purchase purchase = new Purchase();
        purchase.setId(dto.getId());
        purchase.setDate(dto.getDate());
        purchase.setProductName(dto.getProductName());
        purchase.setPriceForOne(dto.getPriceForOne());
        purchase.setAmount(dto.getAmount());
        purchase.setPurchasePrice(dto.getPurchasePrice());
        purchase.setLogistics(dto.getLogistics());
        purchase.setCostPrice(dto.getCostPrice());
        purchase.setBatchPrice(dto.getBatchPrice());
        purchase.setExtra(dto.getExtra());
        return purchase;
    }

    public static PurchaseDto toDto(Purchase purchase) {
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setId(purchase.getId());
        purchaseDto.setDate(purchase.getDate());
        purchaseDto.setProductName(purchase.getProductName());
        purchaseDto.setPriceForOne(purchase.getPriceForOne());
        purchaseDto.setAmount(purchase.getAmount());
        purchaseDto.setPurchasePrice(purchase.getPurchasePrice());
        purchaseDto.setLogistics(purchase.getLogistics());
        purchaseDto.setCostPrice(purchase.getCostPrice());
        purchaseDto.setBatchPrice(purchase.getBatchPrice());
        purchaseDto.setExtra(purchase.getExtra());
        return purchaseDto;
    }

    private Integer id;

    @NotEmpty
    private Timestamp date;

    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,15}")
    @NotEmpty
    private String productName;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double priceForOne;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Integer amount;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Integer purchasePrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double logistics;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double costPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double batchPrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double extra;

}
