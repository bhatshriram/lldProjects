package filters;

import filters.Filter;
import models.File;

public class ExtensionFilter implements Filter {
    private String extension;

    public ExtensionFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean match(File file) {
        return file.getExtension().equals(extension);
    }
}
