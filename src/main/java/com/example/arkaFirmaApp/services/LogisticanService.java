package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Logistican;
import com.example.arkaFirmaApp.repositories.LogisticanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class LogisticanService {
    
    @Autowired
    private LogisticanRepository logisticanRepository;

    public Page<Logistican> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
        return null;
    }

    public void saveLogisticanProject(Logistican logistican) {
    }

    public Logistican getLogisticanProjectById(Long id) {
    }

    public void deleteLogisticanProject(Long id) {
    }
}
