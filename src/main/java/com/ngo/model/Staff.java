package com.ngo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Staff")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long staffId;
	
	@Column(name= "Staff_Name")
	private String staffName;
	
	@Column(name= "Staff_Contact")
	private Long staffContact;
	
	@Column(name= "Staff_Addhar")
	private String staffAdhare;
	
	@Column(name= "Staff_Designation")
	private String staffDesignation;
	
	@Column(name= "Staff_Department")
	private String staffDepartment;
	
	@Column(name= "Staff_Gender")
	private String staffGender;
	
	@Column(name= "Staff_DOB")
	private String staffDOB;

}
