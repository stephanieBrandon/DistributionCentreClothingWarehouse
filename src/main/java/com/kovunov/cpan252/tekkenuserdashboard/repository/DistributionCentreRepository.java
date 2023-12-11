package com.kovunov.cpan252.tekkenuserdashboard.repository;

import com.kovunov.cpan252.tekkenuserdashboard.model.Item;
import org.springframework.data.repository.CrudRepository;

import com.kovunov.cpan252.tekkenuserdashboard.model.DistributionCentre;

import java.util.List;

public interface DistributionCentreRepository extends CrudRepository<DistributionCentre, Integer> {
//    List<Item> findByItemName(Item item);
    //-sb - Monday - add searchBy Item brand and name for end point (4.) in Final Project Requirements

}
