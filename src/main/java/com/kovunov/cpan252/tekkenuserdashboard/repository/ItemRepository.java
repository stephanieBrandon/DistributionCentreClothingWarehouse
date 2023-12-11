package com.kovunov.cpan252.tekkenuserdashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.kovunov.cpan252.tekkenuserdashboard.model.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findByBrandAndName(Item.Brand brand, String name);
}
