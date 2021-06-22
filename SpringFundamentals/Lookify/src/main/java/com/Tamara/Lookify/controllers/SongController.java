package com.Tamara.Lookify.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tamara.Lookify.models.Song;
import com.Tamara.Lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songservice;

	public SongController(SongService songservice) {
		this.songservice = songservice;
	}

	@RequestMapping("/")
	public String welcome() {
		return "welcome.jsp";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", this.songservice.finaAllSongs());
		return "dashboard.jsp";
	}

	@RequestMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Song song) {
		return "addSong.jsp";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createSond(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "addSong.jsp";
		}
		this.songservice.createSong(song);
		return "redirect:/songs/new";
	}

	@RequestMapping("songs/{id}")
	public String displaySong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", this.songservice.finaSongById(id));
		return "displaySong.jsp";
	}

	@RequestMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.songservice.deleteById(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/search/topTen")
	public String topTenSongs(Model model) {
		model.addAttribute("topTenSongs", this.songservice.findAllOrderByRating());
		return "topTenSongs.jsp";
		
	}
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam(value="artist") String artist) {
		return "redirect:/search/"+artist;
	}
	@RequestMapping ("/search/{artist}")
	public String artistSearch(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("artistSongs",this.songservice.searchByArtist(artist));
		model.addAttribute("artist", artist);
		return "searchSong.jsp";
	}
}
