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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import booksCatalog.entities.Publisher;
import booksCatalog.entities.repo.PublisherRepo;

@RestController
public class PublisherController {

	
	@Autowired
	PublisherRepo pr;
	
	
	@GetMapping("/publisher")
	public List<Publisher> ListPublisher() {
		return pr.findAll();
	}

	// 2
	@PostMapping("/addPublisher")
	public void addPublisher(@RequestBody Publisher newPublisher) {
		pr.save(newPublisher);
	}
	
	@PutMapping("/updatePublisher/{id}")
	public void updatePublisher(@PathVariable("id") String id, @RequestBody Publisher updatePublisher) {
		var opPublisher=pr.findById(id);
		if(opPublisher.isPresent()) {
			var publisher=opPublisher.get();
			publisher.setEmail(updatePublisher.getEmail());
			pr.save(publisher);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "publisher id Not Found!");
		}
	}
	
	@DeleteMapping("/deletePublisher/{id}")
	public void deletePublisher(@PathVariable("id") String id) {
		var opPublisher=pr.findById(id);
		if(opPublisher.isPresent()) {
			pr.deleteById(id);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "publisher id Not Found!");
		}
	}
	
}
