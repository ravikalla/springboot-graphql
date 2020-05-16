package in.ravikalla.graphql.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.ravikalla.graphql.models.Employee;

@Component
public class EmployeeRepo {

    private List<Employee> lstEmployee = new ArrayList<Employee>();

    public EmployeeRepo(){ seedEmployees(); }

    private void seedEmployees(){
        Employee e1 = new Employee("Emp1", "Ravi Kalla", 34);
        Employee e2 = new Employee("Emp2", "Swathi Kalla", 32);

        this.lstEmployee.add(e1);
        this.lstEmployee.add(e2);
    }

    public List<Employee> getEmployees(){
        return this.lstEmployee;
    }

    public Employee getEmployeeById(String id){
        List<Employee> matched = this.lstEmployee.stream()
                .filter(c->c.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList());

        if( matched.size() > 0){
            return matched.get(0);
        }else{
            return null;
        }
    }

    public Employee addEmployee(String name, Integer age){
    	Employee newEmployee = new Employee("Emp" + this.lstEmployee.size(), name, age);
        this.lstEmployee.add(newEmployee);
        return newEmployee;
    }
}
