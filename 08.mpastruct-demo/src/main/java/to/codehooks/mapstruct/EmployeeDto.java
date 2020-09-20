package to.codehooks.mapstruct;

import lombok.Data;

@Data
public class EmployeeDto {
    private int id;
    private String fullName; // FirstName + ' ' + lastName
}
