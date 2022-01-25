package by.sam_solutions.grigorieva.olga.backend.domain.table;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TablePage<Item> {

    private List<Item> items;

    private Integer totalCount;
}
