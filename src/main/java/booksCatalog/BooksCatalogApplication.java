package booksCatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import booksCatalog.entities.repo.AuthorRepo;
import booksCatalog.entities.repo.PublisherRepo;
import booksCatalog.entities.repo.SaleRepo;
import booksCatalog.entities.repo.StoreRepo;
import booksCatalog.entities.repo.TitleRepo;

@SpringBootApplication
public class BooksCatalogApplication implements CommandLineRunner {

		
	@Autowired
	PublisherRepo pr;
	
	@Autowired
	SaleRepo sr;
	
	@Autowired
	AuthorRepo ar;
	
	@Autowired
	TitleRepo tr;
	
	@Autowired
	StoreRepo storeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BooksCatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
