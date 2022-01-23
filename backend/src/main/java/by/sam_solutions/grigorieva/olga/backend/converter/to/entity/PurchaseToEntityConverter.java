package by.sam_solutions.grigorieva.olga.backend.converter.to.entity;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import org.springframework.core.convert.converter.Converter;

public class PurchaseToEntityConverter implements Converter<PurchaseDto, Purchase> {

    @Override
    public Purchase convert(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        purchase.setId(purchaseDto.getId());
        purchase.setDate(purchaseDto.getDate());
        purchase.setProductName(purchaseDto.getProductName());
        purchase.setPriceForOne(purchaseDto.getPriceForOne());
        purchase.setAmount(purchaseDto.getAmount());
        purchase.setPurchasePrice(purchaseDto.getPurchasePrice());
        purchase.setLogistics(purchaseDto.getLogistics());
        purchase.setCostPrice(purchaseDto.getCostPrice());
        purchase.setBatchPrice(purchaseDto.getBatchPrice());
        purchase.setExtra(purchaseDto.getExtra());
        return purchase;
    }
}