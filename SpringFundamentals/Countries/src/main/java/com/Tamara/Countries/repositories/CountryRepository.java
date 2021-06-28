package com.Tamara.Countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.Countries.models.Country;



@Repository
// how can i use order by in queries 
//how i can defined a value in queries
// does the order of the join have effect
//how i can use different type of join in the jspl
public interface CountryRepository extends CrudRepository<Country, Long> {
	@Query(value = "SELECT countries.name,languages.language,languages.percentage FROM countries LEFT JOIN languages ON countries.id = languages.country_id WHERE languages.language = ?1", nativeQuery = true)
	List<Object[]> findCountrySpekeslanguage(String launguage);

	@Query("SELECT c.name,COUNT(ci.id) as city_count FROM Country c JOIN c.cities ci GROUP BY c.name ")
	List<Object[]> findNumberOfCitiesInCountry();
	

//	@Query("SELECT c.name, ci.name,ci.population FROM Country c JOIN c.cities ci WHERE c.name='Mexico' AND ci.population > 500,000 GROUP BY ci.population DESC ")
//	List<Object[]> findCountryCityPopulation();
//	// sort.by(sort.Direction.DESC,"population")

	@Query(value="SELECT languages.language,countries.name,languages.percentage FROM countries LEFT JOIN languages On countries.id = languages.country_id WHERE languages.percentage > 89.0 GROUP BY languages.percentage DESC", nativeQuery = true)
	List<Object[]> findCountryLaungagePersentage();
	
	@Query(value="SELECT * FROM countries WHERE surface_area=501 AND population >100000", nativeQuery = true)
	List<Country> findAllCountryWIthSurfavweareaOF501AndPopulationMore100000();
	
	@Query("SELECT c FROM Country c WHERE c.governmentForm='Constitutional Monarchy' AND c.surfaceArea > 200 AND c.lifeExpectancy >75")
	List<Country> findAllCountryWith200And75();
	
	@Query("SELECT c.name,ci.name,ci.district,ci.population FROM Country c JOIN c.cities ci WHERE c.name='Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000  ")
	List<Object[]> findAllCityiesInArgentinaAndBuenosaires();
	
	@Query("SELECT c.region COUNT(c.id) FROM Country c GROUP BY c.region ")
	List<Object[]> findAllRegionCountryNumber();

}
