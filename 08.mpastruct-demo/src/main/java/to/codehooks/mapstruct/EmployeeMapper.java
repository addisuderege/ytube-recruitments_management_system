package to.codehooks.mapstruct;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public abstract class EmployeeMapper {

    @Mapping(target="fullName", source = "emp", qualifiedByName = "fullNameByFirstAndLastName")
    public abstract EmployeeDto toDto(Employee emp);

    @InheritInverseConfiguration(name = "toDto")
    public abstract Employee fromDto(EmployeeDto dto);

    @Named("fullNameByFirstAndLastName")
    public String fullNameByFirstAndLastName(Employee emp) {
        return emp.getFirstName() + ' ' + emp.getLastName();
    }
}
