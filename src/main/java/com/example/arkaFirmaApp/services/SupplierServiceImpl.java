package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Production;
import com.example.arkaFirmaApp.entities.Supplier;
import com.example.arkaFirmaApp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierServiceImpl implements ProjectService<Supplier> {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Page<Supplier> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.supplierRepository.findAll(pageable);
    }

    @Override
    public void saveProject(Supplier supplier) {
        this.supplierRepository.save(supplier);
    }

    @Override
    public Supplier findProjectById(Long id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        Supplier supplier = null;
        if (supplierOptional.isPresent()) {
            supplier = supplierOptional.get();
        } else {
            throw new RuntimeException("Projekt o id : " + id + " nie istnieje.");
        }
        return supplier;
    }

    @Override
    public void deleteProject(Long id) {
        supplierRepository.deleteById(id);
    }
}
