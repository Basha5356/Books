package booksCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import booksCatalog.entities.Title;
import booksCatalog.entities.repo.TitleRepo;
import booksCatalog.entities.repo.dto.TitleAndAuthorDTO;
import booksCatalog.entities.repo.dto.TitleAndPublisherDTO;
import booksCatalog.entities.repo.dto.TitleDetailsDTO;
import jakarta.transaction.Transactional;

@RestController
public class TitleController {

	@Autowired
	TitleRepo tr;
	
	
	@GetMapping("/titles")
	public List<Title> ListTitles() {
		return tr.findAll();
	}

	// 1
	@PostMapping("/addTitle")
	public void addTitle(@RequestBody Title newTitle) {
		tr.save(newTitle);
	}

	// 1
	@PutMapping("/updateTitle/{id}")
	public void updateTitle(@PathVariable("id") String id, @RequestBody Title updatedTitle) {
		var opTitle = tr.findById(id);
		if (opTitle.isPresent()) {
			var title = opTitle.get();
			title.setPrice(updatedTitle.getPrice());
			tr.save(title);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Title Name Not Found!");
		}
	}

	// 1
	@Transactional
	@DeleteMapping("/deleteTitle/{id}")
	public void deleteTitle(@PathVariable("id") String id) {

		tr.deleteById(id);
	}
	
	@GetMapping("/titleAndpublisher")
	public List<TitleAndPublisherDTO> displayTitleAndPublisher() {
		return  tr.findTitleAndPublisher();
	}
	
	@GetMapping("/titleAndAuthors")
	public List<TitleAndAuthorDTO> displayTitleAndAuthors(){
		var listObj=tr.findTitleAndAuthor();
		return listObj;
	}
	
	@GetMapping("/listTitlesByName/{str}")
	public List<Title> displayTitleByTitle(@PathVariable("str") String str){
		var listobj=tr.findByTitleContaining(str);
		return listobj;	
	}
	@GetMapping("/TitlesByPrice/{min}/{max}")
	public List<Title> displayTitleByPrice(@PathVariable("min") Double min, @PathVariable("max") Double max){
		var listTitles= tr.findByPriceBetween(min, max);
		return listTitles;
	}
	
	@GetMapping("/TitlesOrderByYtdSales")
	public List<Title> displayTop5Titles(){
		var listTitles =tr.findFirst5ByOrderByYtdSalesDesc();
		return listTitles;
	}
	
	@GetMapping("/allDetailsByTitle")
	public List<TitleDetailsDTO > displayTitleDetails(@RequestParam("titleId") String titleId){
		var title = tr.findAllDetailsByTitle(titleId);
		return title;
	}
		
}
 