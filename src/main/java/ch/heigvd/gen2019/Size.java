package ch.heigvd.gen2019;

public class Size {
    int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public String getSizeAstring() {
        if (this.size < 1 || this.size > ProductSize.values().length) {
            return "Invalid size.";
        } else {
            return ProductSize.values()[size].name();
        }
    }

    private enum ProductSize {
        XXS("XXS"), XS("XS"), S("S"), M("M"), L("L"), XL("XL");

        private final String size;

        ProductSize(String value) {
            size = value;
        }
    }
}
