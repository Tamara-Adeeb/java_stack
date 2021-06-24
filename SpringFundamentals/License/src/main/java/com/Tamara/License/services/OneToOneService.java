package com.Tamara.License.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.License.models.Licenses;
import com.Tamara.License.models.Person;
import com.Tamara.License.repositories.LicenseRepository;
import com.Tamara.License.repositories.PersonRepository;

@Service
public class OneToOneService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	
	public OneToOneService(LicenseRepository licenseRepository,PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;	
	}
	public int generateLicenseNumber() {
        Licenses license = this.licenseRepository.findTopByOrderByNumberDesc();
        if(license == null)	
            return 	1;
        String number = license.getNumber();
        int num =Integer.parseInt(number);  
        num++;
        return num;
    }
	public List<Person> finaAllPerson(){
		return this.personRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return this.personRepository.save(person);
	}
	public Licenses createLicense(Licenses license) {
		
		String num = String.format("%05d", this.generateLicenseNumber());
		license.setNumber(num);
		return this.licenseRepository.save(license);
	}
	public Person findPersonById(Long id) {
		Optional<Person> optionalPerson = this.personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		return null;
	}
	
	public List<Person> AllPersonWithoutLicense(){
		return this.personRepository.findByLiscensesIdIsNull();
	}
	public List<Licenses> findAllLicenses(){
		return this.licenseRepository.findAll();
	}
}
