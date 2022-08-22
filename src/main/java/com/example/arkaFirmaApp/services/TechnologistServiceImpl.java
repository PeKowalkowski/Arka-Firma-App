package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Technologist;
import com.example.arkaFirmaApp.repositories.TechnologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class TechnologistServiceImpl implements ProjectService<Technologist> {

    @Autowired
    private TechnologistRepository technologistRepository;

    @Override
    public Page<Technologist> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.technologistRepository.findAll(pageable);
    }

    @Override
    public void saveProject(Technologist technologist) {
        this.technologistRepository.save(technologist);
    }

    @Override
    public Technologist findProjectById(Long id) {
        Optional<Technologist> technologistOptional = technologistRepository.findById(id);
        Technologist technologist = null;
        if(technologistOptional.isPresent()){
            technologist = technologistOptional.get();
        }else {
            throw new RuntimeException("Projekt o id : " + id + " nie istnieje.");
        }
        return technologist;
    }

    @Override
    public void deleteProject(Long id) {
        technologistRepository.deleteById(id);
    }
}
