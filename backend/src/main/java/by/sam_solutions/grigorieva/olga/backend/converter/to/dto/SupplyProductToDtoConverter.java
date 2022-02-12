package by.sam_solutions.grigorieva.olga.backend.converter.to.dto;

import by.sam_solutions.grigorieva.olga.backend.dto.PurchaseDto;
import by.sam_solutions.grigorieva.olga.backend.dto.StorageDto;
import by.sam_solutions.grigorieva.olga.backend.dto.SupplyTableRowDto;
import by.sam_solutions.grigorieva.olga.backend.entity.SupplyProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor
public class SupplyProductToDtoConverter implements Converter<SupplyProduct, SupplyTableRowDto> {

    private final ConversionService conversionService;

    @Override
    public SupplyTableRowDto convert(SupplyProduct supplyProduct) {
        SupplyTableRowDto supplyTableRowDto = new SupplyTableRowDto();
        supplyTableRowDto.setId(supplyProduct.getSupply().getId());
        supplyTableRowDto.setPurchase(conversionService.convert(supplyProduct.getSupply().getPurchase(), PurchaseDto.class));
        supplyTableRowDto.setStorage(conversionService.convert(supplyProduct.getSupply().getStorage(), StorageDto.class));
        supplyTableRowDto.setDate(supplyProduct.getSupply().getDate());
        supplyTableRowDto.setProduct(supplyProduct.getProduct());
        supplyTableRowDto.setAmount(supplyProduct.getAmount());
        supplyTableRowDto.setLogistics(supplyProduct.getSupply().getLogistics());
        supplyTableRowDto.setPurchasePrice(supplyProduct.getSupply().getPurchasePrice());
        supplyTableRowDto.setFulfillment(supplyProduct.getSupply().getFulfillment());
        supplyTableRowDto.setCostPrice(supplyProduct.getSupply().getCostPrice());
        return supplyTableRowDto;
    }
}
