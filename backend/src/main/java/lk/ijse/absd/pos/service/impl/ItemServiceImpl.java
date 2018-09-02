package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.entity.Item;
import lk.ijse.absd.pos.repository.ItemRepository;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:40 AM
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveItem(ItemDTO dto) {
        itemRepository.save(new Item(dto.getItemId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateItem(int id, ItemDTO dto) {
        if (itemRepository.existsById(id)) {
            itemRepository.save(new Item(dto.getItemId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
        } else {
            throw new RuntimeException("Item not found.");
        }
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteItem(int id) {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public ItemDTO findItem(int id) {
        Item item = itemRepository.findById(id).get();
        return new ItemDTO(item.getItemId(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    @Override
    public List<ItemDTO> findAllItems() {
        List<Item> itemList = itemRepository.findAll();
        List<ItemDTO> dtoList = new ArrayList<>();
        itemList.forEach(item -> {
            dtoList.add(new ItemDTO(item.getItemId(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        });
        return dtoList;
    }

    @Override
    public List<ItemDTO> findItemsLike(String description) {
        List<Item> itemList = itemRepository.findItemsLike("%" + description + "%");
        List<ItemDTO> dtoList = new ArrayList<>();
        itemList.forEach(item -> {
            dtoList.add(new ItemDTO(item.getItemId(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        });
        return dtoList;
    }

    @Override
    public long getItemCount() {
        return itemRepository.count();
    }
}
