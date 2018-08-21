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

    void saveItem(String id, ItemDTO dto);

    void updateItem(String id, ItemDTO dto);

    void deleteItem(String id);

    ItemDTO findItem(String id);

    List<ItemDTO> findAllItems();

    List<ItemDTO> findItemsLike(String description);

    long getItemCount();

}
