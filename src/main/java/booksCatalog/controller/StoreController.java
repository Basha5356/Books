package booksCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import booksCatalog.entities.Store;
import booksCatalog.entities.repo.StoreRepo;
import booksCatalog.entities.repo.dto.StoreIdAndTitleDTO;

@RestController
public class StoreController {

	@Autowired
	StoreRepo storeRepo;
	
	@GetMapping("/stores")
	public List<Store> displayStores(){
		var listStore = storeRepo.findAll();
		return listStore;
	}
	
	@PostMapping("/stores/addStore")
	public void addStore(@RequestBody Store newStore) {
		storeRepo.save(newStore);
	}
		
	@PutMapping("/stores/updateStore/{id}")
	public void updateStore(@PathVariable("id") String id ,@RequestBody Store updateStore) {
		var opStore = storeRepo.findById(id);
		if (opStore.isPresent()) {
			var store = opStore.get();
			store.setCity(updateStore.getCity());
			storeRepo.save(store);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Title Name Not Found!");
		}
	}
	
	
	@GetMapping("/listStoreIdAndTitle")
	List<StoreIdAndTitleDTO> displayStoreIdAndTitle(){
		var listObj= storeRepo.findByStoreIdAndTitle();
		return listObj;
	}
	
	
	
	
}
