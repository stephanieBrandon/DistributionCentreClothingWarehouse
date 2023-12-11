package com.kovunov.cpan252.tekkenuserdashboard.repository;

import com.kovunov.cpan252.tekkenuserdashboard.model.DistributionCentre;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DistributionCentreRepositoryPaginated extends PagingAndSortingRepository<DistributionCentre, Long> {
}
