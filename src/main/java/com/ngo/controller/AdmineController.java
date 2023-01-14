package com.ngo.controller;

import java.util.List;

//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.constants.AppConstants;
import com.ngo.dto.AdmineDto;
import com.ngo.exception.ApiResponse;
import com.ngo.serviceImpl.AdmineServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admine")
public class AdmineController {
	
	@Autowired
	private AdmineServiceImpl admineServiceImpl;
	
	
	
	@PostMapping("/create")
	public ResponseEntity<AdmineDto> saveAdmine(@Valid @RequestBody AdmineDto admineDto){
		
		AdmineDto save = this.admineServiceImpl.createAdmine(admineDto);
	//	logger.info("complete Addmine Controller for save admine");
		return new ResponseEntity<AdmineDto>(save,HttpStatus.CREATED) ;
	}
	@GetMapping("/{admineId}")
	public ResponseEntity<AdmineDto> getAdmine( @PathVariable Long admineId){
		 AdmineDto get = this.admineServiceImpl.getAdmine(admineId);
		return new ResponseEntity<AdmineDto>(get,HttpStatus.OK) ;
}
	@GetMapping("/getall")
	public ResponseEntity<List<AdmineDto>> getall(){
		  List<AdmineDto> allAdmine = this.admineServiceImpl.getAllAdmine();
		return new ResponseEntity<>(allAdmine,HttpStatus.OK);
}
	@PutMapping("/update/{admineId}")
	public ResponseEntity<AdmineDto> updateById(@RequestBody AdmineDto admineDto, @PathVariable Long admineId){
		AdmineDto update = this.admineServiceImpl.updateAdmine(admineDto, admineId);
		return new ResponseEntity<AdmineDto>(update,HttpStatus.OK);
		}
	@DeleteMapping("/delete")
	public ResponseEntity<ApiResponse> deleteAdmine(){
		this.admineServiceImpl.deleteAlladmine();
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.All_Admine_Delete, false),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{AdmineId}")
	public ResponseEntity<ApiResponse> deleteAdmineById(@PathVariable Long AdmineId){
		this.admineServiceImpl.deleteAdmineById(AdmineId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.Admine_Delete, false),HttpStatus.OK);
	}
	
	
	
}