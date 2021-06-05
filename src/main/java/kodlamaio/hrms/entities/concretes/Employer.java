package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})

public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;

	public Employer(String email, String password, String companyName, String webSite, String phoneNumber, boolean verificationStatus) {
		super(email, password);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.verificationStatus = verificationStatus;
	}

	@OneToMany(mappedBy="employer")
	private List<JobAdvertisement> jobAdvertisement;
	
}
