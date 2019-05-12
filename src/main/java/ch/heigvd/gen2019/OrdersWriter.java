package ch.heigvd.gen2019;

import ch.heigvd.gen2019.size.NoSize;
import ch.heigvd.gen2019.color.Color;
import ch.heigvd.gen2019.size.Size;

import java.util.List;

public class OrdersWriter {
    private List<Order> orders;

    public OrdersWriter(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * Write an order in a JSON format
     * @return a string of the order formatted in JSON
     */
    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        /* For every order */
        for (Order order : orders) {
            appendOrderID(sb, order.getOrderId());
            sb.append("\"products\": [");

            /* For every product */
            for (int j = 0; j < order.getProductsCount(); j++) {
                Product product = order.getProduct(j);
                appendProductCode(sb, product.getCode());
                appendProductColor(sb, product.getColor());

                /* Append a size only if the product has a Size */
                if (product.getSize().getClass() != NoSize.class) {
                    appendProductSize(sb, product.getSize());
                }

                appendProductPrice(sb, product.getPrice());
                appendProductCurrency(sb, product.getCurrency());
            }

            /* Removes the last 2 characters if there is not product */
            if (order.getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]}, ");
        }

        /* Removes the last 2 characters if there where products */
        if (orders.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private void appendOrderID(StringBuffer sb, int orderID) {
        sb.append("{\"id\": ").append(orderID).append(", ");
    }

    private void appendProductCode(StringBuffer sb, String productCode) {
        sb.append("{\"code\": \"").append(productCode).append("\", ");
    }

    private void appendProductColor(StringBuffer sb, Color color) {
        sb.append("\"color\": \"").append(color).append("\", ");
    }

    private void appendProductSize(StringBuffer sb, Size size) {
        sb.append("\"size\": \"").append(size).append("\", ");
    }

    private void appendProductPrice(StringBuffer sb, double price) {
        sb.append("\"price\": ").append(price).append(", ");
    }

    private void appendProductCurrency(StringBuffer sb, String currency) {
        sb.append("\"currency\": \"").append(currency).append("\"}, ");
    }
}