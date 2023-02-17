package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.Supplier;
import com.example.arkaFirmaApp.services.SupplierServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {

    private SupplierServiceImpl supplierService;

    public SupplierController(SupplierServiceImpl supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/showSupplierProjectIndex")
    public String viewMainProjectPage(Model model) {
        return findPaginatedSupplierProject(1, "projectName", "asc", model);
    }

    @GetMapping("/showSupplierProjectIndex/page/{pageNo}")
    public String findPaginatedSupplierProject(@PathVariable(value = "pageNo") int pageNo,
                                               @RequestParam("sortField") String sortField,
                                               @RequestParam("sortDir") String sortDir,
                                               Model model) {
        int pageSize = 5;
        Page<Supplier> page = supplierService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Supplier> supplierProjectList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("supplierProjectList", supplierProjectList);


        return "supplier_Project_Index";
    }

    @GetMapping("/showNewSupplierProjectForm")
    private String showNewSupplierProjectForm(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "new_Supplier_Project";
    }

    @PostMapping("saveSupplierProject")
    private String saveSupplierProject(@ModelAttribute("supplierProject") Supplier supplier) {
        supplierService.saveProject(supplier);
        return "redirect:/showSupplierProjectIndex";
    }

    @GetMapping("showFormForUpdateSupllierProject/{id}")
    private String updateSupplierProject(@PathVariable("id") Long id, Model model) {
        Supplier supplier = supplierService.findProjectById(id);
        model.addAttribute("supplier", supplier);
        return "update_Supplier_Project";
    }

    @GetMapping("deleteSupplierProject/{id}")
    private String deleteSupplierProject(@PathVariable("id") Long id) {
        supplierService.deleteProject(id);
        return "redirect:/showSupplierProjectIndex";
    }
}
