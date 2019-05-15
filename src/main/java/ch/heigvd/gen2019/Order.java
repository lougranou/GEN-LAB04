package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    /**
     * Get current order in JSON format
     * @return a string of the order formatted in JSON
     */
    public String getAsJson() {
        StringBuffer sb = new StringBuffer();
        sb.append("{\"id\": ").append(this.id).append(", \"products\": [");

        /* For every product */
        for (int j = 0; j < this.products.size(); j++) {
            Product product = this.getProduct(j);
            sb.append(product.getAsJson());
        }

        /* Removes the last 2 characters if there is not product */
        if (this.products.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]}, ");
        return sb.toString();
    }
}
