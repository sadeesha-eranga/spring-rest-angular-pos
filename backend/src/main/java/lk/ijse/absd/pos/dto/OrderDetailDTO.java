package lk.ijse.absd.pos.dto;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:44 AM
 */
public class OrderDetailDTO {

    private int qty;
    private double totalPrice;
    private ItemDTO itemDTO;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int qty, double totalPrice, ItemDTO itemDTO) {
        this.setQty(qty);
        this.setTotalPrice(totalPrice);
        this.setItemDTO(itemDTO);
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

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "qty=" + qty +
                ", totalPrice=" + totalPrice +
                ", itemDTO=" + itemDTO +
                '}';
    }
}
