package com.ngo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdmineDto {

private Long admineId;
	
	@NotEmpty
	@Size(min=3,message="Name must be atlist 3 character!!")
	private String admineName;
	
	@NotEmpty
	@Size(min=10,message="Number must be atlist 10 character!!")
	private String admineContact;
	
	@NotEmpty
	@Size(min=10,max=12,message="UID must be between 10 to 12 character!!")
	private String admineAdhar;
	
	@NotEmpty
	@Size(min=10,max=12,message="Pan must be between 10 to 12 character!!")
	@Pattern(regexp = "[A-z]{5}[0-9]{4}[A-Z]{1}")
	private String pan_no;
	
	@NotEmpty
	private String admineGender;

}
