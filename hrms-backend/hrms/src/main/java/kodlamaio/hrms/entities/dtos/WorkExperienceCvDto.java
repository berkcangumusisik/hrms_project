package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceCvDto {
	private int workExperienceId;
	private String workplaceName;
	private LocalDate startingDate;
	private LocalDate endingdate;
	private String positionName;
	private String jobSeekerFirstname;
	private String jobSeekerLastname;

}
