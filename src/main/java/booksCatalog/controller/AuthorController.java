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

import booksCatalog.entities.Author;
import booksCatalog.entities.repo.AuthorRepo;
import jakarta.transaction.Transactional;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorRepo ar;
	
	@GetMapping("/authors")
	public List<Author> ListAuthors() {
		return ar.findAll();
	}

	// 1
	@PostMapping("/addAuthor")
	public void addAuthor(@RequestBody Author newAuthor) {
		ar.save(newAuthor);
	}

	// 1
	@PutMapping("/updateAuthor/{id}")
	public void updateAuthor(@PathVariable("id") String id, @RequestBody Author updatedAuthor) {
		var opAuthor = ar.findById(id);
		if (opAuthor.isPresent()) {
			var  author=opAuthor.get();
			author.setEmail(updatedAuthor.getEmail());
			ar.save(author);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author Name Not Found!");
		}
	}
	
	@Transactional
	@DeleteMapping("/deleteAuthor/{id}")
	public void deleteAuthor(@PathVariable("id") String id) {

		ar.deleteById(id);
	}
}
