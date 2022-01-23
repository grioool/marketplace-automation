package by.sam_solutions.grigorieva.olga.backend.converter.to.entity;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.dto.StorageDto;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Purchase;
import by.sam_solutions.grigorieva.olga.backend.entity.Storage;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
public class SupplyToEntityConverter implements Converter<SupplyDto, Supply> {

    private final ConversionService conversionService;

    @Override
    public Supply convert(SupplyDto supplyDto) {
        Supply supply = new Supply();
        supply.setId(supplyDto.getId());
        supply.setPurchase(conversionService.convert(supplyDto.getPurchase(), Purchase.class));
        supply.setStorage(conversionService.convert(supplyDto.getStorage(), Storage.class));
        supply.setDate(supplyDto.getDate());
        supply.setProduct(supplyDto.getProduct());
        supply.setAmount(supplyDto.getAmount());
        supply.setLogistics(supplyDto.getLogistics());
        supply.setPurchasePrice(supplyDto.getPurchasePrice());
        supply.setFulfillment(supplyDto.getFulfillment());
        supply.setCostPrice(supplyDto.getCostPrice());
        return supply;
    }
}
