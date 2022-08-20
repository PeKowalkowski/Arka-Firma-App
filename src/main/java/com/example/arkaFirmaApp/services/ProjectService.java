package com.example.arkaFirmaApp.services;

import com.example.arkaFirmaApp.entities.Production;
import org.springframework.data.domain.Page;


public interface ProjectService<T> {

    Page<T> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);

    void saveProject(T t);

    T findProjectById(Long id);

    void deleteProject(Long id);
}
