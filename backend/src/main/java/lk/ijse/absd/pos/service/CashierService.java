package lk.ijse.absd.pos.service;

import lk.ijse.absd.pos.dto.OrderDTO;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:58 AM
 */
public interface CashierService {

    boolean saveOrder(OrderDTO orderDTO);

    long getTotalOrders();

}
