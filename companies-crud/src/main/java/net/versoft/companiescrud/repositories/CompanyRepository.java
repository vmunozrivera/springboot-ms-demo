package net.versoft.companiescrud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.versoft.companiescrud.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	Optional<Company> findByName(String name); 
}
