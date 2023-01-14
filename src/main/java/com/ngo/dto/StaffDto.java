package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class StaffDto {
	
private Long staffId;
	
    @NotEmpty
    @Size(min=3,message="Name must be atlist 3 character!!")
	private String staffName;
	
    @NotEmpty
	@Size(min=10,message="Number must be atlist 10 character!!")
	private Long staffContact;
	
    @NotEmpty
	@Size(min=10,max=12,message="UID must be between 10 to 12 character!!")
	private String staffAdhare;
	
    @NotEmpty
	private String staffDesignation;
	
    @NotEmpty
	private String staffDepartment;
	
    @NotEmpty
	private String staffGender;
	
    @NotEmpty
	private String staffDOB;


}
