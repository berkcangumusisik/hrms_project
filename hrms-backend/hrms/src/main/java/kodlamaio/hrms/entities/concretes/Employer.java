package kodlamaio.hrms.entities.concretes;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id" , referencedColumnName = "id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisement" })
@EqualsAndHashCode(callSuper = false)
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Employer extends User{

	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	@Column(name = "update_status")
	private boolean updateStatus;

	@Column(name = "update_employer")
	@Type(type = "jsonb")
	private Map<String, Object> update;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;
}
