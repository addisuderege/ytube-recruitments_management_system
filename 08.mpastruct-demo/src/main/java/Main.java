import to.codehooks.mapstruct.Employee;
import to.codehooks.mapstruct.EmployeeDto;
import to.codehooks.mapstruct.EmployeeMapper;
import to.codehooks.mapstruct.EmployeeMapperImpl;

public class Main {

    private static EmployeeMapper mapper = new EmployeeMapperImpl();

    public static void main(String[] args) {
        Employee emp = Employee.builder()
                .id(1)
                .firstName("Code")
                .lastName("Hooks")
                .build();

        EmployeeDto employeeDto = mapper.toDto(emp);
        System.out.println(employeeDto);
    }
}
