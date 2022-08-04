package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.MainProject;
import com.example.arkaFirmaApp.repositories.MainProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainProjectService {

    @Autowired
    private MainProjectRepository mainProjectRepository;

    public Page<MainProject> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.mainProjectRepository.findAll(pageable);
    }

    public void saveMainProject(MainProject mainProject) {
        this.mainProjectRepository.save(mainProject);
    }

    public MainProject getProjectById(Long id) {
        Optional<MainProject> mainProjectOptional = mainProjectRepository.findById(id);
        MainProject mainProject = null;
        if(mainProjectOptional.isPresent()){
            mainProject = mainProjectOptional.get();
        }else {
            throw new RuntimeException("Projekt o id : " + id + " nie istnieje.");
        }
        return mainProject;
    }

    public void deleteProject(Long id) {
        mainProjectRepository.deleteById(id);
    }
}
