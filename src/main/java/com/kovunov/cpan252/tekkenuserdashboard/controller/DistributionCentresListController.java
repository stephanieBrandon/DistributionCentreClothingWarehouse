package com.kovunov.cpan252.tekkenuserdashboard.controller;

import com.kovunov.cpan252.tekkenuserdashboard.repository.DistributionCentreRepository;
import com.kovunov.cpan252.tekkenuserdashboard.repository.DistributionCentreRepositoryPaginated;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/centersList")
public class DistributionCentresListController {
    private static final int PAGE_SIZE = 3;
    private DistributionCentreRepository distributionCentreRepository;
    private DistributionCentreRepositoryPaginated distributionCentreRepositoryPaginated;

    public DistributionCentresListController (DistributionCentreRepository distributionCentreRepository, DistributionCentreRepositoryPaginated distributionCentreRepositoryPaginated ){
        this.distributionCentreRepository = distributionCentreRepository;
        this.distributionCentreRepositoryPaginated = distributionCentreRepositoryPaginated;
    }
    @GetMapping
    public String showCentres(Model model) { return "centersList";}

    @ModelAttribute
    public void centres (Model model){
        var centrePage = distributionCentreRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("centres", centrePage);
        model.addAttribute("currentPage", centrePage.getNumber());
        model.addAttribute("totalPages", centrePage.getTotalPages());
    }
    @GetMapping("/switchPage")
    public String switchPage(Model model,
                             @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "centersList";
        }
        var centrePage = distributionCentreRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("centres", centrePage.getContent());
        model.addAttribute("currentPage", centrePage.getNumber());
        return "centersList";
    }
}
