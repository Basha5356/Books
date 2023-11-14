package booksCatalog.entities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booksCatalog.entities.Store;
import booksCatalog.entities.repo.dto.StoreIdAndTitleDTO;

public interface StoreRepo extends JpaRepository<Store,String>	 {

	@Query("select s.storeId as storeId,t.title as title from Store s join s.titles t ")
	List<StoreIdAndTitleDTO> findByStoreIdAndTitle();

	
}
