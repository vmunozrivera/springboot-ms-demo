package net.versoft.companiescrud.services;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import net.versoft.companiescrud.entities.Category;
import net.versoft.companiescrud.entities.Company;
import net.versoft.companiescrud.repositories.CompanyRepository;

@Service
@Transactional
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository; 
	
	@Override
	public Company createCompany(Company company) {
		company.getWebSites().forEach(website -> {
			if (Objects.isNull(website.getCategory())) {
				website.setCategory(Category.NONE);
			}
		});
		return this.companyRepository.save(company);
	}

	@Override
	public Company getCompanyByName(String name) {
		return this.companyRepository.findByName(name)
				.orElseThrow(() -> new NoSuchElementException("Company not fount"));
	}

	@Override
	public Company updateCompany(Company company, String name) {
		var companyToUpdate = this.companyRepository.findByName(name)
				.orElseThrow(() -> new NoSuchElementException("Company not fount"));
		companyToUpdate.setLogo(company.getLogo());
		companyToUpdate.setFoundationDate(company.getFoundationDate());
		companyToUpdate.setFounder(company.getFounder());
		return this.companyRepository.save(companyToUpdate);
	}

	@Override
	public void deleteCompany(String name) {
		var companyToDelete = this.companyRepository.findByName(name)
				.orElseThrow(() -> new NoSuchElementException("Company not fount"));
		this.companyRepository.delete(companyToDelete);
	}

}
