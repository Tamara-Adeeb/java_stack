package com.Tamara.DojoandNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.DojoandNinjas.models.Dojo;
import com.Tamara.DojoandNinjas.models.Ninja;
import com.Tamara.DojoandNinjas.repositories.DojoRepository;
import com.Tamara.DojoandNinjas.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	private NinjaRepository ninjaRepository;
	private DojoRepository dojoRepository;
	
	public DojoNinjaService(NinjaRepository ninjaRepository,DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepository.save(dojo);
	}
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepository.save(ninja);
	}
	public List<Dojo> findAllDojos(){
		return this.dojoRepository.findAll();
	}
//	public int numberOfNinjasinOneDojo(Ninja ninja) {
//		return this.dojoRepository.count(ninja);
//	}
	
	public List<Ninja> findAllNinjas(){
		return this.ninjaRepository.findAll();
	}
	
	public Dojo findDojoByid(Long id) {
		Optional<Dojo> optionalDojo = this.dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
}
