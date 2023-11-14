package booksCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import booksCatalog.entities.Sale;
import booksCatalog.entities.repo.SaleRepo;
import booksCatalog.entities.repo.dto.SaleByTitleDTO;
import booksCatalog.entities.repo.dto.StoreSumOfQtyDTO;
import jakarta.transaction.Transactional;

@RestController
public class SalesController {

	@Autowired
	SaleRepo sr;
	

	@GetMapping("/sales")
	public List<Sale> ListSale() {
		return sr.findAll();
	}

	// 1
	@PostMapping("/addSale")
	public void addSale(@RequestBody Sale newSale) {
		sr.save(newSale);
	}

	// 1
	@PutMapping("/updateSale")
	public void updateSale(@RequestBody Sale updatedSale) {
		var opSale = sr.findById(updatedSale.getKey());
		if (opSale.isPresent()) {
			var sale = opSale.get();
			sale.setQtySold(updatedSale.getQtySold());
			sr.save(sale);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sale Not Found!");
		}
	}

	// 1
	@Transactional
	@DeleteMapping("/deletSale")
	public void deleteSale(@RequestBody Sale updatedSale) {

		sr.deleteById(updatedSale.getKey());
	}
	
	@GetMapping("/AllSales")
	public List<Sale> ListAllSales() {
		return sr.findAll();
	}
	
	@GetMapping("/top5stores")
	public List<StoreSumOfQtyDTO > displayTop5Sales (){
		var listStores= sr.findByTitleSold(PageRequest.of(0, 3));
		return listStores;
	}
	
	@GetMapping("/salesByTitle")
	public List<SaleByTitleDTO> displaySalesByTitle(@RequestParam("titleId") String titleId){
		var listSales= sr.findSalesByTitle(titleId);
		
		return listSales;
	}
	
	
			
	
	
		
	
	
		
}
