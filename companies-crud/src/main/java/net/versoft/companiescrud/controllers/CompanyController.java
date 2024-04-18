package net.versoft.companiescrud.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.versoft.companiescrud.entities.Company;
import net.versoft.companiescrud.services.CompanyService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/company")
public class CompanyController {

	private final CompanyService companyService;
	
	@GetMapping(path = "{name}")
	public ResponseEntity<Company> get(@PathVariable String name){
		log.info("GET: company {}", name);
		return ResponseEntity.ok(this.companyService.getCompanyByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Company> post(@RequestBody Company company) {
		log.info("POST: company {}", company.getName());
		Company companyCreated = this.companyService.createCompany(company);
		return ResponseEntity.created(URI.create(companyCreated.getName())).build();
	}
	
	@PutMapping(path = "{name}")
	public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name) {
		log.info("PUT: company {}", name);
		return ResponseEntity.ok(this.companyService.updateCompany(company, name));
	}
	
	@DeleteMapping(path = "{name}")
	public ResponseEntity<?> delete(@PathVariable String name) {
		log.info("DELETE: company {}", name);
		this.companyService.deleteCompany(name);
		return ResponseEntity.noContent().build();
	}
	
}
