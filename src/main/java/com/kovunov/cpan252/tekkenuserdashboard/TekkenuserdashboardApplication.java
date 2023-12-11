package com.kovunov.cpan252.tekkenuserdashboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kovunov.cpan252.tekkenuserdashboard.model.DistributionCentre;
import com.kovunov.cpan252.tekkenuserdashboard.model.Item;
import com.kovunov.cpan252.tekkenuserdashboard.repository.DistributionCentreRepository;
import com.kovunov.cpan252.tekkenuserdashboard.repository.ItemRepository;

@SpringBootApplication
public class TekkenuserdashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TekkenuserdashboardApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository itemRepository, DistributionCentreRepository dcRepository) {
		return args -> {
			var distributionCentre = dcRepository
					.save(DistributionCentre.builder().name("DC1").latitude(10.0).longitude(10.9).build());
			itemRepository
					.save(Item.builder().name("Shirts").description("Item1 description").quantity(10)
							.distributionCentre(distributionCentre).build());
			itemRepository
					.save(Item.builder().name("Pants").description("Item2 description").quantity(10)
							.distributionCentre(distributionCentre).build());
			itemRepository
					.save(Item.builder().name("Shoes").description("Item3 description").quantity(10)
							.distributionCentre(distributionCentre).build());
		};
	}

}
