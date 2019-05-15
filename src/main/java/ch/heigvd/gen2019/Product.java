package ch.heigvd.gen2019;

import ch.heigvd.gen2019.color.Color;
import ch.heigvd.gen2019.size.NoSize;
import ch.heigvd.gen2019.size.Size;

public class Product {
    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    /**
     * Get current product in JSON format
     * @return a string of the product formatted in JSON
     */
    public String getAsJson() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"code\": \"").append(this.code).append("\", ");
        sb.append("\"color\": \"").append(this.color).append("\", ");

        /* Append a size only if the product has a Size */
        if (this.size.getClass() != NoSize.class) {
            sb.append("\"size\": \"").append(this.size).append("\", ");
        }

        sb.append("\"price\": ").append(this.price).append(", ");
        sb.append("\"currency\": \"").append(this.currency).append("\"}, ");

        return sb.toString();
    }
}