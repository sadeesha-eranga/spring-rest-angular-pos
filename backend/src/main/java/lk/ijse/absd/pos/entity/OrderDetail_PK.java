package lk.ijse.absd.pos.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:35 AM
 */
public class OrderDetail_PK implements Serializable {

    private int orderId;
    private int itemId;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(int orderId, int itemId) {
        this.setOrderId(orderId);
        this.setItemId(itemId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderDetail_PK{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}
