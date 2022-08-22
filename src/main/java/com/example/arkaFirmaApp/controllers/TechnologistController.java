package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.Supplier;
import com.example.arkaFirmaApp.entities.Technologist;
import com.example.arkaFirmaApp.services.TechnologistServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TechnologistController {

    private TechnologistServiceImpl technologistService;

    public TechnologistController(TechnologistServiceImpl technologistService) {
        this.technologistService = technologistService;
    }

    @GetMapping("/showTechnologistProjectIndex")
    public String viewMainProjectPage(Model model) {
        return findPaginatedTechnologistProject(1, "projectName", "asc", model);
    }

    @GetMapping("/showTechnologistProjectIndex/page/{pageNo}")
    public String findPaginatedTechnologistProject(@PathVariable(value = "pageNo") int pageNo,
                                               @RequestParam("sortField") String sortField,
                                               @RequestParam("sortDir") String sortDir,
                                               Model model) {
        int pageSize = 5;
        Page<Technologist> page = technologistService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Technologist> technologistProjectList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("technologistProjectList", technologistProjectList);


        return "technologist_Project_Index";
    }

    @GetMapping("showNewTechnologistProjectForm")
    private String technologistProjectList(Model model){
        Technologist technologist = new Technologist();
        model.addAttribute("technologist", technologist);
        return "new_Technologist_Project";
    }
    @PostMapping("saveTechnologistProject")
    private String saveTechnologistProject(@ModelAttribute ("technologistProject") Technologist technologist){
        technologistService.saveProject(technologist);
        return "redirect:/showTechnologistProjectIndex";
    }
    @GetMapping("showFormForUpdateTechnologistProject/{id}")
    private String updateTechnologistProject(@PathVariable ("id") Long id, Model model ){
        Technologist technologist = technologistService.findProjectById(id);
        model.addAttribute("technologist", technologist);
        return "update_Technologist_Project";
    }
    @GetMapping("deleteTechnologistProject/{id}")
    private String deleteTechnologistProject(@PathVariable("id") Long id){
        technologistService.deleteProject(id);
        return "redirect:/showTechnologistProjectIndex";
    }



}
