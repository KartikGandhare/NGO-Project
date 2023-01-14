package com.ngo.service;

import java.util.List;

import com.ngo.dto.AdmineDto;

public interface AdmineService {
	
	public AdmineDto createAdmine(AdmineDto admineDto);
	
	public AdmineDto updateAdmine(AdmineDto admineDto, Long admineId);
	
	public AdmineDto getAdmine( Long admineId);
	
	public List<AdmineDto> getAllAdmine();
	
	public void deleteAdmineById(Long admineId);
	
	public void deleteAlladmine();

}
