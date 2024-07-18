package com.anudip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.entity.Batches;
import com.anudip.service.BatchesService;

import jakarta.validation.Valid;

@RestController
public class BatchesController {

	@Autowired
	BatchesService bservice;
	
	@PostMapping("/Batches/addBatches")
	public ResponseEntity<Batches> saveBatches(@Valid @RequestBody Batches batches)
	{
		return new ResponseEntity<Batches>(bservice.addBatches(batches),HttpStatus.CREATED);
	}
	
	@GetMapping("/Batches/get/{bid}")
	public ResponseEntity<Batches> getDepartment(@PathVariable("bid") int bid)
	{
		return new ResponseEntity<Batches>(bservice.getBatchesDetails(bid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Batches/remove/{bid}")
	public ResponseEntity<String> deleteBatches(@PathVariable("bid") int bid)
	{
		return new ResponseEntity<String>("Delete successfully...",HttpStatus.OK);
	}
	
	//use putmapping to edit existing data
	@PutMapping("/Batches/update/{bid}")
	public ResponseEntity<Batches> editBatches(@PathVariable("bid") Integer bid, @Valid @RequestBody Batches batches)
	{
		Batches updateBatches=bservice.updateBatches(batches , bid);
		return new ResponseEntity<Batches>(updateBatches , HttpStatus.OK); 
	}
}
