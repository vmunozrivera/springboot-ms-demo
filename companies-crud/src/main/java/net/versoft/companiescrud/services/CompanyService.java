package net.versoft.companiescrud.services;

import net.versoft.companiescrud.entities.Company;

public interface CompanyService {

	Company createCompany(Company company);
	Company getCompanyByName(String name);
	Company updateCompany(Company company, String name);
	void deleteCompany(String name);
	
}
