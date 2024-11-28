package filters;

import filters.Filter;
import models.File;

public class SizeFilter implements Filter {
    private int size;
    private String operator;

    public SizeFilter(int size, String operator) {
        this.size = size;
        this.operator = operator;
    }

    @Override
    public boolean match(File file) {
        switch (operator) {
            case ">":
                return file.getSize() > size;
            case ">=":
                return file.getSize() >= size;
            case "<":
                return file.getSize() < size;
            case "<=":
                return file.getSize() <= size;
            case "==":
                return file.getSize() == size;
            default:
                return false;
        }
    }
}
