package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_personnel")
@EqualsAndHashCode(callSuper = false)

public class SystemPersonnel extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;


}
