package filters;

import models.File;

public interface Filter {

    boolean match(File file);
}
