package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.Production;
import com.example.arkaFirmaApp.services.ProductionServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductionController {


    private ProductionServiceImpl productionService;

    public ProductionController(ProductionServiceImpl productionService) {
        this.productionService = productionService;
    }

    @GetMapping("/showProductionProjectIndex")
    public String viewMainProjectPage(Model model) {
        return findPaginatedProductionProject(1, "projectName", "asc", model);
    }

    @GetMapping("/showProductionProjectIndex/page/{pageNo}")
    public String findPaginatedProductionProject(@PathVariable(value = "pageNo") int pageNo,
                                           @RequestParam("sortField") String sortField,
                                           @RequestParam("sortDir") String sortDir,
                                           Model model) {
        int pageSize = 5;
        Page<Production> page = productionService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Production> productionProjectList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("productionProjectList", productionProjectList);


        return "production_Project_Index";
    }

    @GetMapping("showNewProductionProjectForm")
    public String showNewProductionProjectForm(Model model){
        Production production = new Production();
        model.addAttribute("production", production);
        return "new_Production_Project";
    }

    @PostMapping("/saveProductionProject")
    public String saveProductionProject(@ModelAttribute ("productionProject") Production production){
        productionService.saveProject(production);
        return "redirect:/showProductionProjectIndex";
    }
    @GetMapping("showFormForUpdateProductionProject/{id}")
    public String updateProductionProject(@PathVariable(value = "id") Long id, Model model){
        Production production = productionService.findProjectById(id);
        model.addAttribute("production", production);
        return "update_Production_Project";

    }
    @GetMapping("deleteProductionProject/{id}")
    public String deleteProductionProject(@PathVariable ("id") Long id){
        productionService.deleteProject(id);
        return "redirect:/showProductionProjectIndex";
    }
}
