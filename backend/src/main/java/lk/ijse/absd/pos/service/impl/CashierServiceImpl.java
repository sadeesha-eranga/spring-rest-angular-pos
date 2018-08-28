package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.dto.OrderDTO;
import lk.ijse.absd.pos.dto.OrderDetailDTO;
import lk.ijse.absd.pos.entity.*;
import lk.ijse.absd.pos.repository.OrderRepository;
import lk.ijse.absd.pos.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:59 AM
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CashierServiceImpl implements CashierService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveOrder(OrderDTO orderDTO) {
        Order order = new Order();

        Customer customer = new Customer(orderDTO.getCustomerDTO().getCustomerId(), orderDTO.getCustomerDTO().getName(), orderDTO.getCustomerDTO().getAddress());

        List<OrderDetailDTO> orderDetailDTOList = orderDTO.getOrderDetailDTOList();

        List<OrderDetail> orderDetailList = new ArrayList<>();

        for (OrderDetailDTO orderDetailDTO : orderDetailDTOList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQty(orderDetailDTO.getQty());
            orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());

            Item item = new Item(orderDetailDTO.getItemDTO().getItemId(),
                    orderDetailDTO.getItemDTO().getDescription(),
                    orderDetailDTO.getItemDTO().getUnitPrice(),
                    orderDetailDTO.getItemDTO().getQtyOnHand());

            orderDetail.setItem(item);
            orderDetail.setOrderDetail_pk(new OrderDetail_PK(orderDTO.getOrderId(), item.getItemId()));
            orderDetail.setOrder(order);
            orderDetailList.add(orderDetail);
        }


        order.setOrderId(orderDTO.getOrderId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setCustomer(customer);
        order.setOrderDetailList(orderDetailList);

        orderRepository.save(order);

        return true;
    }

    @Override
    public long getTotalOrders() {
        return orderRepository.count();
    }
}
