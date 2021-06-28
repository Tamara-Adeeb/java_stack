package com.Tamara.Countries.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.Tamara.Countries.models.Country;
import com.Tamara.Countries.repositories.CountryRepository;

@Service
public class CountryService {
	private final CountryRepository countryRepository;

	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public List<Object[]> findSloveneCountries() {
		return this.countryRepository.findCountrySpekeslanguage("Slovene");
	}
	
	public List<Object[]> findNumberOfCitiesInCountry(){
		return this.countryRepository.findNumberOfCitiesInCountry();
	}
	
//	public List<Object[]> findMaxicoPopulation(){
//		return this.countryRepository.findCountryCityPopulation();
//	}
	
	public List<Object[]> findLungugePersntage(){
		return this.countryRepository.findCountryLaungagePersentage();
	}
	public List<Country> findSurfaceArea501(){
		return this.countryRepository.findAllCountryWIthSurfavweareaOF501AndPopulationMore100000();
	}
	
	public List<Country> findCountryOfConstitutionalMonarchy(){
		return this.countryRepository.findAllCountryWith200And75();
	}
	public List<Object[]> findCitiesOfArgentina(){
		return this.countryRepository.findAllCityiesInArgentinaAndBuenosaires();
	}
	
	public List<Object[]> findRegionCountNumber(){
		return this.countryRepository.findAllRegionCountryNumber();
	}
}
