package com.kovunov.cpan252.tekkenuserdashboard;

import com.kovunov.cpan252.tekkenuserdashboard.controller.DistributionCentreController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.kovunov.cpan252.tekkenuserdashboard.model.DistributionCentre;
import com.kovunov.cpan252.tekkenuserdashboard.model.Item;
import com.kovunov.cpan252.tekkenuserdashboard.repository.DistributionCentreRepository;
import com.kovunov.cpan252.tekkenuserdashboard.repository.ItemRepository;

@SpringBootApplication
public class TekkenuserdashboardApplication {

	public static void main(String[] args) {

//		SpringApplication.run(TekkenuserdashboardApplication.class, args);
		ApplicationContext context = SpringApplication.run(TekkenuserdashboardApplication.class, args);
		DistributionCentreController controller = context.getBean(DistributionCentreController.class);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository itemRepository, DistributionCentreRepository dcRepository) {
		return args -> {
			var distributionCentre1 = dcRepository
					.save(DistributionCentre.builder().name("DC1").latitude(10.0).longitude(10.9).build());
			var distributionCentre2 = dcRepository
					.save(DistributionCentre.builder().name("DC2").latitude(43.72852).longitude(-79.606307).build());
			var distributionCentre3 = dcRepository
					.save(DistributionCentre.builder().name("DC3").latitude(43.6425640).longitude(-79.387087).build());
			var distributionCentre4 = dcRepository
					.save(DistributionCentre.builder().name("DC4").latitude(43.6425640).longitude(-79.387087).build());
			var distributionCentre5 = dcRepository
					.save(DistributionCentre.builder().name("DC5").latitude(43.6425640).longitude(-79.387087).build());
			itemRepository
					.save(Item.builder().name("Shirts").description("Item1 description").quantity(10)
							.distributionCentre(distributionCentre1).build());
			itemRepository
					.save(Item.builder().name("Pants").description("Item2 description").quantity(10)
							.distributionCentre(distributionCentre1).build());
			itemRepository
					.save(Item.builder().name("Shoes").description("Item3 description").quantity(10)
							.distributionCentre(distributionCentre1).build());
			itemRepository
					.save(Item.builder().name("Shirts").description("Item1 description").quantity(10)
							.distributionCentre(distributionCentre2).build());
			itemRepository
					.save(Item.builder().name("Pants").description("Item2 description").quantity(10)
							.distributionCentre(distributionCentre2).build());
			itemRepository
					.save(Item.builder().name("Shoes").description("Item3 description").quantity(10)
							.distributionCentre(distributionCentre3).build());
			itemRepository
					.save(Item.builder().name("Shoes").description("Item3 description").quantity(10)
							.distributionCentre(distributionCentre4).build());
			itemRepository
					.save(Item.builder().name("Shoes").description("Item3 description").quantity(10)
							.distributionCentre(distributionCentre5).build());
		};
	}

}
