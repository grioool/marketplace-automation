package by.sam_solutions.grigorieva.olga.backend.converter.to.dto;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import org.springframework.core.convert.converter.Converter;

public class PurchaseToDtoConverter implements Converter<Purchase, PurchaseDto> {

    @Override
    public PurchaseDto convert(Purchase purchase) {
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
}
