package sg.edu.nus.iss.paf_day23_wsA.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {
    
    private int orderId;
    private LocalDate orderDate;
    private int customerId;
    private float totalPrice;
    private float costPrice;


    public Order() {
    }


    public static Order toOrder(SqlRowSet rs) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDate orderDate = LocalDate.parse(rs.getString("orderDate"), formatter);

        Order order = new Order();
            order.setOrderId(rs.getInt("orderId"));
            order.setOrderDate(orderDate);
            order.setCustomerId(rs.getInt("customerId"));
            order.setTotalPrice(rs.getFloat("totalPrice"));
            order.setCostPrice(rs.getFloat("costPrice"));

        return order;
    }


    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId + ", totalPrice="
                + totalPrice + ", costPrice=" + costPrice + "]";
    }


    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public float getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public float getCostPrice() {
        return costPrice;
    }
    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

}
