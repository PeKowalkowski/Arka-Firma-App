package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Production;
import com.example.arkaFirmaApp.repositories.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductionServiceImpl implements ProjectService<Production> {

    @Autowired
    private ProductionRepository productionRepository;

    public Page<Production> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productionRepository.findAll(pageable);
    }

    @Override
    public void saveProject(Production production) {
        this.productionRepository.save(production);
    }

    @Override
    public Production findProjectById(Long id) {
        Optional<Production> productionOptional = productionRepository.findById(id);
        Production production = null;
        if(productionOptional.isPresent()){
            production = productionOptional.get();
        }else {
            throw new RuntimeException("Projekt o id : " + id + " nie istnieje.");
        }
        return production;
    }

    @Override
    public void deleteProject(Long id) {
        this.productionRepository.deleteById(id);
    }
}
