package pl.App.Firma.Arek.ArkaFirmaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.App.Firma.Arek.ArkaFirmaApp.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
