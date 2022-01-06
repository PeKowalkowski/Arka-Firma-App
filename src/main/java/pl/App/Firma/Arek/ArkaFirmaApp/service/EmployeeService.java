package pl.App.Firma.Arek.ArkaFirmaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.App.Firma.Arek.ArkaFirmaApp.model.Employee;
import pl.App.Firma.Arek.ArkaFirmaApp.repository.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List < Employee > getAllEmployees() {
        return employeeRepo.findAll();
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
    }
}
