package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:37 AM
 */
@RestController
@CrossOrigin
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PutMapping
    public void saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
    }

    @PostMapping("{id}")
    public void updateItem(@RequestParam String id, @RequestBody ItemDTO itemDTO) {
        itemService.updateItem(Integer.parseInt(id), itemDTO);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }

    @GetMapping("{id}")
    public ItemDTO findItem(@PathVariable int id) {
        return itemService.findItem(id);
    }

    @GetMapping()
    public Object findAllItems(@RequestParam(required = false) String action, @RequestParam(required = false) String description) {
        if (null != action) {
            switch (action) {
                case "count": {
                    return itemService.getItemCount();
                }

                case "like": {
                    return itemService.findItemsLike(description);
                }

                default: {
                    return itemService.findAllItems();
                }
            }
        } else {
            return itemService.findAllItems();
        }
    }


}
