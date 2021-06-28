package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
	private String firstName;
	private String lastName;
	private String email;
	private int dateOfBirth;
	
}
