package in.ravikalla.graphql.resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import in.ravikalla.graphql.models.Employee;
import in.ravikalla.graphql.repos.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Query implements GraphQLQueryResolver {

    private EmployeeRepo employeeRepo;

    public Query(EmployeeRepo repo){ this.employeeRepo = repo; }

    public List<Employee> employees(){ return employeeRepo.getEmployees(); }

    public Employee employeeById(String id){
        return employeeRepo.getEmployeeById(id);
    }
}
