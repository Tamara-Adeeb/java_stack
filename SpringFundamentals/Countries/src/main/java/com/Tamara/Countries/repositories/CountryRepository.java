package com.Tamara.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Tamara.Countries.models.Country;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

// how can i use order by in queries 
//how i can defined a value in queries
// does the order of the join have effect
//how i can use different type of join in the jspl
public interface CountryRepository extends CrudRepository<Country, Long> {
	@Query(value = "SELECT countries.name,languages.language,languages.percentage FROM countries LEFT JOIN languages ON countries.id = languages.country_id WHERE languages.language = ?1", nativeQuery = true)
	List<Object[]> findCountrySpekeslanguage(String launguage);

	@Query("SELECT c.name,COUNT(ci.id) as city_count FROM Country c JOIN c.cities ci GROUP BY c.name ")
	List<Object[]> findNumberOfCitiesInCountry(Sort sort);
	// sort.by("city_count")

	@Query("SELECT c.name, ci.name,ci.population FROM Country c JOIN c.cities ci WHERE c.name=?1 AND ci.population > 500,000")
	List<Object[]> findCountryCityPopulation(String name, Sort sort);
	// sort.by(sort.Direction.DESC,"population")

	@Query("SELECT languages.language,countries.name,languages.percentage FROM countries LEFT JOIN languages On countries.id = languages.country_id WHERE languages.percentage > 89.0")
	List<Object[]> findCountryLaungagePersentage(Sort sort);
	
	@Query("SELECT * FROM countries WHERE surface_area=501 AND population >100000")
	List<Country> findAllCountryWIthSurfavweareaOF501AndPopulationMore100000();
	
	@Query("SELECT c FROM Country c WHERE c.governmentForm=?1 AND c.surfaceArea > 200 AND c.lifeExpectancy >75")
	List<Country> findAllCountryWith200And75(String governmentForm);
	
	@Query("SELECT c.name,ci.name,ci.district,ci.population FROM Country c JOIN c.cities ci WHERE c.name=Argentina AND ci.district = Buenos Aires AND ci.population > 500000  ")
	List<Object[]> findAllCityiesInArgentinaAndBuenosaires();
	
	@Query("SELECT c.region COUNT(c.id) FROM Country c GROUP BY c.region ")
	List<Object[]> findAllRegionCountryNumber(Sort sort);

}
