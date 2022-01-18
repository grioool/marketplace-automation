package by.sam_solutions.grigorieva.olga.backend.dto;

import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
public class SupplyDto {

    public static Supply toEntity(SupplyDto dto) {
        Supply supply = new Supply();
        supply.setId(dto.getId());
        supply.setPurchase(PurchaseDto.toEntity(dto.getPurchase()));
        supply.setStorage(StorageDto.toEntity(dto.getStorage()));
        supply.setDate(dto.getDate());
        supply.setProduct(dto.getProduct());
        supply.setAmount(dto.getAmount());
        supply.setLogistics(dto.getLogistics());
        supply.setPurchasePrice(dto.getPurchasePrice());
        supply.setFulfillment(dto.getFulfillment());
        supply.setCostPrice(dto.getCostPrice());
        return supply;
    }

    public static SupplyDto toDto(Supply supply) {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setId(supply.getId());
        supplyDto.setPurchase(PurchaseDto.toDto(supply.getPurchase()));
        supplyDto.setStorage(StorageDto.toDto(supply.getStorage()));
        supplyDto.setDate(supply.getDate());
        supplyDto.setProduct(supply.getProduct());
        supplyDto.setAmount(supply.getAmount());
        supplyDto.setLogistics(supply.getLogistics());
        supplyDto.setPurchasePrice(supply.getPurchasePrice());
        supplyDto.setFulfillment(supply.getFulfillment());
        supplyDto.setCostPrice(supply.getCostPrice());
        return supplyDto;
    }

    private Integer id;

    @NotEmpty
    private PurchaseDto purchase;

    @NotEmpty
    private StorageDto storage;

    @NotEmpty
    private Timestamp date;

    @Pattern(regexp="^[A-Za-zА-Яа-яЁё]{2,15}")
    @NotEmpty
    private String product;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Integer amount;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double logistics;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double purchasePrice;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double fulfillment;

    @Pattern(regexp="^[0-9]{2,15}")
    @NotEmpty
    private Double costPrice;
}
