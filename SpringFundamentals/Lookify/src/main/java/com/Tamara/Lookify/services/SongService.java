package com.Tamara.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Tamara.Lookify.models.Song;
import com.Tamara.Lookify.repositories.LookifyRepository;

@Service
public class SongService {
	private final LookifyRepository lookifyRepository;
	public SongService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	public Song finaSongById(Long id) {
		Optional<Song> optionalSong =  lookifyRepository.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}
		return null;
	}
	
	public Song createSong(Song song) {
		return this.lookifyRepository.save(song);
	}
	public List<Song> finaAllSongs(){
		return this.lookifyRepository.findAll();
	}
	
	public List<Song> searchByArtist(String search){
		return this.lookifyRepository.findByArtistContaining(search);
	}
	public void deleteById(Long id) {
		this.lookifyRepository.deleteById(id);
//		this.lookifyRepository.delete(this.finaSongById(id));
	}
	public List<Song> findAllOrderByRating(){
		return this.lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
}
