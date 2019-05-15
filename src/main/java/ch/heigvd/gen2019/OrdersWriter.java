package ch.heigvd.gen2019;

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
        for (Order order : this.orders) {
            sb.append(order.getAsJson());
        }

        /* Removes the last 2 characters if there where products */
        if (this.orders.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }
}