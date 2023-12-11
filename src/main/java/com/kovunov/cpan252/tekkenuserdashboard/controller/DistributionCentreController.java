package com.kovunov.cpan252.tekkenuserdashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kovunov.cpan252.tekkenuserdashboard.model.DistributionCentre;
import com.kovunov.cpan252.tekkenuserdashboard.model.Item;
import com.kovunov.cpan252.tekkenuserdashboard.repository.DistributionCentreRepository;
import com.kovunov.cpan252.tekkenuserdashboard.repository.ItemRepository;

@RestController
@RequestMapping("/api/distribution")
public class DistributionCentreController {

    private final DistributionCentreRepository dcRepository;
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
