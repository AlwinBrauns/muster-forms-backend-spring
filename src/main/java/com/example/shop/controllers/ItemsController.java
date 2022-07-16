package com.example.shop.controllers;

import com.example.shop.models.Item;
import com.example.shop.repositories.ElementRepository;
import com.example.shop.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class ItemsController implements ControllerExceptions{
    final private ElementRepository elementRepository;
    final private ItemRepository itemRepository;

    @PostMapping("/item")
    public ResponseEntity<?> addItem(@Valid @RequestBody Item item){
        elementRepository.saveAll(item.getElements());
        Item result = itemRepository.save(item);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/item/all")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemRepository.findAll();
        return ResponseEntity.ok(items);
    }
}
