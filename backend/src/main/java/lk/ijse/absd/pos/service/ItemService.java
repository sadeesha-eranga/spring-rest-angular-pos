package lk.ijse.absd.pos.service;

import lk.ijse.absd.pos.dto.ItemDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:39 AM
 */
public interface ItemService {

    boolean saveItem(ItemDTO dto);

    boolean updateItem(int id, ItemDTO dto);

    boolean deleteItem(int id);

    ItemDTO findItem(int id);

    List<ItemDTO> findAllItems();

    List<ItemDTO> findItemsLike(String description);

    long getItemCount();

}
