package booksCatalog.entities.repo;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booksCatalog.entities.Sale;
import booksCatalog.entities.SalePk;
import booksCatalog.entities.repo.dto.SaleByTitleDTO;
import booksCatalog.entities.repo.dto.StoreSumOfQtyDTO;

public interface SaleRepo extends JpaRepository<Sale, SalePk> {

	@Query("select  s.store.storeId as storeId, sum(s.qtySold) as sumOfQtySold from Sale s Group By storeId Order By sumOfQtySold Desc")
	List<StoreSumOfQtyDTO > findByTitleSold(PageRequest pageRequest);
	
	@Query(" select s.store.storeId as storeId, s.qtySold as qtySold from Sale s join s.title t where t.titleId like  %:titleId% ")
	List<SaleByTitleDTO> findSalesByTitle(@Param("titleId") String titleId);
	
}
