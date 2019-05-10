package ch.heigvd.gen2019.size;

public abstract class Size {
    String size;

    Size(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return this.size;
    }
}
