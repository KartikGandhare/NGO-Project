package com.ngo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdmineDto;
import com.ngo.exception.ResourceNotFoundException;
import com.ngo.model.Admine;
import com.ngo.repository.Adminerepository;
import com.ngo.service.AdmineService;

@Service
public class AdmineServiceImpl implements AdmineService{
	
	@Autowired
	private Adminerepository adminerepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdmineDto createAdmine(AdmineDto admineDto) {
		Admine admine = this.modelMapper.map(admineDto, Admine.class);
		Admine saveAdmine = this.adminerepository.save(admine);
		return this.modelMapper.map(saveAdmine, AdmineDto.class);
	}

	@Override
	public AdmineDto updateAdmine(AdmineDto admineDto, Long admineId) {
		
		Admine admine1 = this.adminerepository.findById(admineId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.Admine_Id_Not_Found +admineId));
		admine1.setAdmineName(admineDto.getAdmineName());
		admine1.setAdmineContact(admineDto.getAdmineContact());
		admine1.setAdmineAdhar(admineDto.getAdmineAdhar());
		admine1.setPan_no(admineDto.getPan_no());
		admine1.setAdmineGender(admineDto.getAdmineGender());
		
		Admine updateAdmine = this.adminerepository.save(admine1);
		return  this.modelMapper.map(updateAdmine,AdmineDto.class );
		
		
	}

	@Override
	public AdmineDto getAdmine( Long admineId) {
		Admine getadmine = this.adminerepository.findById(admineId)
				.orElseThrow(()-> new ResourceNotFoundException(AppConstants.Admine_Id_Not_Found));
		return this.modelMapper.map(getadmine, AdmineDto.class) ;
	}

	@Override
	public List<AdmineDto> getAllAdmine() {
		List<Admine> list= this.adminerepository.findAll();
		 List<AdmineDto> getalladmine = list.stream().map((Admine)-> this.modelMapper.map(Admine, AdmineDto.class))
		 .collect(Collectors.toList());
		return getalladmine;
	}

	@Override
	public void deleteAdmineById(Long admineId) {
		Admine deleteAdmine = this.adminerepository.findById(admineId).orElseThrow(()-> new ResourceNotFoundException(AppConstants.Admine_Id_Not_Found));
			this.adminerepository.delete(deleteAdmine);
		
	}

	@Override
	public void deleteAlladmine() {
		this.adminerepository.deleteAll();
		
		
	}

}
