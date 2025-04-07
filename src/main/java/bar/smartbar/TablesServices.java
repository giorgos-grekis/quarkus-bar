package bar.smartbar;

import bar.smartbar.api.model.Table;

public class TablesServices {
    public Table get() {
        return new Table().name("Berlin");
    }
}
