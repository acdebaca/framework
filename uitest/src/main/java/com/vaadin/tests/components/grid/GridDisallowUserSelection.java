package com.vaadin.tests.components.grid;

import com.vaadin.data.ValueProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.GridSelectionModel;

/**
 * @author Vaadin Ltd
 *
 */
public class GridDisallowUserSelection extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        Grid<String> grid = new Grid<>();
        grid.addColumn(ValueProvider.identity());
        grid.setItems("a", "b");
        GridSelectionModel<String> model = grid
                .setSelectionMode(SelectionMode.SINGLE);
        model.setUserSelectionAllowed(false);

        addComponent(grid);

        Button button = new Button("Multi select", event -> {
            GridSelectionModel<String> multi = grid
                    .setSelectionMode(SelectionMode.MULTI);
            multi.setUserSelectionAllowed(false);
        });
        addComponent(button);
    }
}
