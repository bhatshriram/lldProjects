package filters;

import filters.Filter;
import models.File;

public class NameFilter implements Filter {
    private String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean match(File file) {
        return file.getName().equals(name);
    }
}
