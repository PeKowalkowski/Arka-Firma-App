package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Logistican;
import com.example.arkaFirmaApp.repositories.LogisticanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogisticanService {
    
    @Autowired
    private LogisticanRepository logisticanRepository;

    public Page<Logistican> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.logisticanRepository.findAll(pageable);
    }

    public void saveLogisticanProject(Logistican logistican) {
        this.logisticanRepository.save(logistican);
    }

    public Logistican getLogisticanProjectById(Long id) {
        Optional<Logistican> logisticanOptional = logisticanRepository.findById(id);
        Logistican logistican = null;
        if(logisticanOptional.isPresent()){
            logistican = logisticanOptional.get();
        }else {
            throw new RuntimeException("Projekt o id : " + id + " nie istnieje.");
        }
        return logistican;
    }

    public void deleteLogisticanProject(Long id) {
        logisticanRepository.deleteById(id);
    }
}
