package lk.ijse.absd.pos.dto;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:30 AM
 */
public class OrderDTO {

    private int orderId;
    private String orderDate;
    private CustomerDTO customerDTO;
    private List<OrderDetailDTO> orderDetailDTOList;

    public OrderDTO() {
    }

    public OrderDTO(String orderDate, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOList) {
        this.orderDate = orderDate;
        this.customerDTO = customerDTO;
        this.orderDetailDTOList = orderDetailDTOList;
    }

    public OrderDTO(int orderId, String orderDate, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOList) {
        this.setOrderId(orderId);
        this.setOrderDate(orderDate);
        this.setCustomerDTO(customerDTO);
        this.setOrderDetailDTOList(orderDetailDTOList);
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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTOList() {
        return orderDetailDTOList;
    }

    public void setOrderDetailDTOList(List<OrderDetailDTO> orderDetailDTOList) {
        this.orderDetailDTOList = orderDetailDTOList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", customerDTO=" + customerDTO +
                ", orderDetailDTOList=" + orderDetailDTOList +
                '}';
    }
}
