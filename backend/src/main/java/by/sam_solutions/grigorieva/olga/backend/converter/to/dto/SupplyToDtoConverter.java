package by.sam_solutions.grigorieva.olga.backend.converter.to.dto;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.dto.StorageDto;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
public class SupplyToDtoConverter implements Converter<Supply, SupplyDto> {

    private final ConversionService conversionService;

    @Override
    public SupplyDto convert(Supply supply) {
        SupplyDto supplyDto = new SupplyDto();
        supplyDto.setId(supply.getId());
        supplyDto.setPurchase(conversionService.convert(supply.getPurchase(), PurchaseDto.class));
        supplyDto.setStorage(conversionService.convert(supply.getStorage(), StorageDto.class));
        supplyDto.setDate(supply.getDate());
        supplyDto.setProduct(supply.getProduct());
        supplyDto.setAmount(supply.getAmount());
        supplyDto.setLogistics(supply.getLogistics());
        supplyDto.setPurchasePrice(supply.getPurchasePrice());
        supplyDto.setFulfillment(supply.getFulfillment());
        supplyDto.setCostPrice(supply.getCostPrice());
        return supplyDto;
    }
}
