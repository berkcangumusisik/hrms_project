package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceJobPositionDto {

	private int workExperienceId;
	private int jobPositionId;
	private String workplaceName;
	private LocalDate startingDate;
	private LocalDate endingdate;
	private String positionName;

}
