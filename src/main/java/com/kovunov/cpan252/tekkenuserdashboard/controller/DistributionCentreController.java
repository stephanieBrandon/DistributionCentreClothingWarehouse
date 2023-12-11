package com.kovunov.cpan252.tekkenuserdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kovunov.cpan252.tekkenuserdashboard.model.DistributionCentre;
import com.kovunov.cpan252.tekkenuserdashboard.model.Item;
import com.kovunov.cpan252.tekkenuserdashboard.repository.DistributionCentreRepository;
import com.kovunov.cpan252.tekkenuserdashboard.repository.ItemRepository;

@Controller

//@RequestMapping("/")
@SessionAttributes("CentresDirectory")
@RestController
@RequestMapping(value = {"/api/distribution", "/centerList"})
public class DistributionCentreController {
    @Autowired
    private final DistributionCentreRepository dcRepository;
    @Autowired
    private final ItemRepository itemRepository;

    public DistributionCentreController(DistributionCentreRepository dcRepository, ItemRepository itemRepository) {
        this.dcRepository = dcRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<DistributionCentre> getAllCentres() {
        return (List<DistributionCentre>) dcRepository.findAll();
    }

    @GetMapping("/{id}/items")
    public List<Item> getItemsForCentre(@PathVariable int id) {
        var currentDistributionCentre = dcRepository.findById(id);
        var items = currentDistributionCentre.get().getItems();
        return items;
    }

    @PostMapping("/{id}/items")
    public Item addItemToCentre(@PathVariable int id, @RequestBody Item item) {
        var currentDistributionCentre = dcRepository.findById(id);
        item.setDistributionCentre(currentDistributionCentre.get());
        var savedItem = itemRepository.save(item);
        return savedItem;
    }

}
