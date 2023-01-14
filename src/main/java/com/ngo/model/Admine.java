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
@Table(name="Admine")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long admineId;
	
	@Column(name="Admine_Name")
	private String admineName;
	
	@Column(name="Contact")
	private String admineContact;
	
	@Column(name="Admine_Adhar")
	private String admineAdhar;
	
	@Column(name="PanCart_Number")
	private String pan_no;
	
	@Column(name="Gender")
	private String admineGender;

}
