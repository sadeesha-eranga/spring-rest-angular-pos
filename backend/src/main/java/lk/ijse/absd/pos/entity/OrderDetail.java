package lk.ijse.absd.pos.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:34 AM
 */
@Entity
public class OrderDetail {

    @EmbeddedId
    private OrderDetail_PK orderDetail_pk;
    private int qty;
    private double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private Item item;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetail_PK orderDetail_pk, int qty, double totalPrice, Order order, Item item) {
        this.setOrderDetail_pk(orderDetail_pk);
        this.setQty(qty);
        this.setTotalPrice(totalPrice);
        this.setOrder(order);
        this.setItem(item);
    }

    public OrderDetail_PK getOrderDetail_pk() {
        return orderDetail_pk;
    }

    public void setOrderDetail_pk(OrderDetail_PK orderDetail_pk) {
        this.orderDetail_pk = orderDetail_pk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetail_pk=" + orderDetail_pk +
                ", qty=" + qty +
                ", totalPrice=" + totalPrice +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}