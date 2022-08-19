package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.Logistican;
import com.example.arkaFirmaApp.entities.MainProject;
import com.example.arkaFirmaApp.services.LogisticanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LogisticanController {


    private LogisticanService logisticanService;

    public LogisticanController(LogisticanService logisticanService) {
        this.logisticanService = logisticanService;
    }

    @GetMapping("/showLogisticanProjectIndex")
    public String viewLogisticanProjectPage(Model model){
        return findPaginatedLogisticanProject(1, "projectName", "asc", model);
    }

    @GetMapping("/showLogisticanProjectIndex/page/{pageNo}")
    public String findPaginatedLogisticanProject(@PathVariable(value = "pageNo") int pageNo,
                                           @RequestParam("sortField") String sortField,
                                           @RequestParam("sortDir") String sortDir,
                                           Model model) {
        int pageSize = 5;
        Page<Logistican> page = logisticanService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Logistican> logisticanProjectList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("logisticanProjectList", logisticanProjectList);


        return "logistican_Project_Index";
    }

    @GetMapping("/showNewLogisticanProjectForm")
    public String showNewLogisticanProjectForm(Model model){
        Logistican logistican = new Logistican();
        model.addAttribute("logistican", logistican);
        return "new_Logistican_Project";

    }
    @PostMapping("/saveLogisticanProject")
    public String saveLogisticanProject(@ModelAttribute("logisticanProject") Logistican logistican){
        logisticanService.saveLogisticanProject(logistican);
        return "redirect:/showLogisticanProjectIndex";
    }

    @GetMapping("/showFormForUpdateLogisticanProject/{id}")
    public String updateLogisticanProject(@PathVariable(value = "id") Long id, Model model){
        Logistican logistican = logisticanService.getLogisticanProjectById(id);
        model.addAttribute("logistican",logistican);
        return "update_Logistican_Project";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteLogisticanProject/{id}")
    public String deleteLogisticanProject(@PathVariable(value = "id") Long id){
        logisticanService.deleteLogisticanProject(id);
        return "redirect:/showLogisticanProjectIndex";
    }


}
