package com.colorly.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import com.colorly.backend.model.Item;
import com.colorly.backend.repository.ItemRepository;
import com.colorly.backend.util.ColorPaletteCompare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> search(String color1, String color2, String color3) {
        ArrayList<Color> inputColors = new ArrayList<Color>();
        inputColors.add(Color.decode(color1));
        inputColors.add(Color.decode(color2));
        inputColors.add(Color.decode(color3));
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item item : itemRepository.findAll()) {
            ArrayList<Color> itemColors = new ArrayList<Color>();
            itemColors.add(Color.decode(item.getColor1()));
            itemColors.add(Color.decode(item.getColor2()));
            itemColors.add(Color.decode(item.getColor3()));
            if (ColorPaletteCompare.areClose(inputColors, itemColors)) {
                result.add(item);
            }
        }
        return result;
    }
}
