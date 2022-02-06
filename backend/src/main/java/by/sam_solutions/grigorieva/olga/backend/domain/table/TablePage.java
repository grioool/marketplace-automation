package by.sam_solutions.grigorieva.olga.backend.domain.table;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class TablePage<Item> {

    private List<Item> items;

    private Integer totalCount;

    public static <TItem> TablePage<TItem> slice(List<TItem> items, int shift, int itemsPerPage) {
        return new TablePage<>(items.subList(shift, Math.min(items.size(), shift + itemsPerPage)), items.size());
    }

    public static <TItem>TablePage<TItem> blank() {
        return new TablePage<>(new ArrayList<>(), 0);
    }
}
