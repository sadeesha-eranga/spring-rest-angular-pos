package lk.ijse.absd.pos.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:14 AM
 */
@Entity
@Table(name = "`Orders`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;

    public Order() {
    }

    public Order(String orderDate, Customer customer, List<OrderDetail> orderDetailList) {
        this.setOrderDate(orderDate);
        this.setCustomer(customer);
        this.setOrderDetailList(orderDetailList);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", customer=" + customer +
                ", orderDetailList=" + orderDetailList +
                '}';
    }

}
