package pl.App.Firma.Arek.ArkaFirmaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.App.Firma.Arek.ArkaFirmaApp.model.Employee;
import pl.App.Firma.Arek.ArkaFirmaApp.repository.EmployeeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        Employee employee = null;
        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        } else {
            throw new RuntimeException("Employee not found for id : " + id);
        }
        return employee;
    }
    public void deleteEmployee(Long id){
        this.employeeRepo.deleteById(id);
    }
}
