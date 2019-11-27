package org.qacademy.trello.runner;

import java.util.Locale;

import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;

import org.qacademy.trello.pages.BoardFields;

/**
 * Registers parameters types.
 */
public class ParameterTypes implements TypeRegistryConfigurer {

    /**
     * {@inheritDoc}
     */
    public Locale locale() {
        return Locale.ENGLISH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureTypeRegistry(io.cucumber.core.api.TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(BoardFields.class,
                (TableCellTransformer<BoardFields>) cell -> BoardFields.valueOf(cell.toUpperCase())));
    }
}
