package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationWithCvWithUniversityWithUniversityDepartmentDto {

	private int EducationInformationId;
	private String firstName;
	private String lastName;
	private int cvId;
	private int universityId;
	private String universityName;
	private int UniversityDepartmentId;
	private String universityDepartmentName;
	private String startingDate;
	private String graduationDate;
	
}