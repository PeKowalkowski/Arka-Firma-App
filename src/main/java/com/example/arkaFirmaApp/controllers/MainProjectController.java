package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.MainProject;
import com.example.arkaFirmaApp.services.MainProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainProjectController {


    private MainProjectService mainProjectService;

    public MainProjectController(MainProjectService mainProjectService) {
        this.mainProjectService = mainProjectService;
    }

    @GetMapping("/showMainProjectIndex")
    public String viewMainProjectPage(Model model) {
        return findPaginatedMainProject(1, "projectName", "asc", model);
    }

    @GetMapping("/showMainProjectIndex/page/{pageNo}")
    public String findPaginatedMainProject(@PathVariable(value = "pageNo") int pageNo,
                                           @RequestParam("sortField") String sortField,
                                           @RequestParam("sortDir") String sortDir,
                                           Model model) {
        int pageSize = 5;
        Page<MainProject> page = mainProjectService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<MainProject> mainProjectList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("mainProjectList", mainProjectList);


        return "main_Project_Index";
    }

    @GetMapping("/showNewMainProjectForm")
    public String showNewMainProjectForm(Model model) {
        MainProject mainProject = new MainProject();
        model.addAttribute("mainProject", mainProject);
        return "new_Main_Project";
    }

    @PostMapping("/saveNewProject")
    public String saveProject(@ModelAttribute("mainProject") MainProject mainProject) {
        mainProjectService.saveMainProject(mainProject);
        return "redirect:/showMainProjectIndex";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/showFormForUpdateProject/{id}")
    public String showFormForUpdateProject(@PathVariable(value = "id") Long id, Model model) {
        MainProject mainProject = mainProjectService.getProjectById(id);
        model.addAttribute("mainProject", mainProject);
        return "update_Main_Project";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable(value = "id") Long id) {
        mainProjectService.deleteProject(id);
        return "redirect:/showMainProjectIndex";
    }

}
