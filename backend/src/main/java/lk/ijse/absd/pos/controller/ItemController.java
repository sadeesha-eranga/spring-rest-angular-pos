package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveItem(@RequestBody ItemDTO itemDTO) {
        return itemService.saveItem(itemDTO);
    }

    @PostMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(Integer.parseInt(id), itemDTO);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteItem(@PathVariable int id) {
        return itemService.deleteItem(id);
    }

    @GetMapping("{id}")
    public ItemDTO findItem(@PathVariable int id) {
        return itemService.findItem(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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
