package in.ravikalla.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import in.ravikalla.graphql.models.Employee;
import in.ravikalla.graphql.repos.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Mutation implements GraphQLMutationResolver {
    private EmployeeRepo employeeRepo;

    public Mutation(EmployeeRepo repo){
        this.employeeRepo = repo;
    }

    public Employee addEmployee(String name, Integer age){
        return employeeRepo.addEmployee(name, age);
    }

}
