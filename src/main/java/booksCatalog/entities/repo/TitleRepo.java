package booksCatalog.entities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booksCatalog.entities.Title;
import booksCatalog.entities.repo.dto.TitleAndAuthorDTO;
import booksCatalog.entities.repo.dto.TitleAndPublisherDTO;
import booksCatalog.entities.repo.dto.TitleDetailsDTO;

public interface TitleRepo extends JpaRepository<Title, String> {

	@Query
	List<Title> deleteByTitleId(String s);

	@Query("select p.title as title, p.publisher.pubName as pubName from Title p")
	List<TitleAndPublisherDTO> findTitleAndPublisher();

	@Query("SELECT t.title as title, a.auName as auName FROM Title t JOIN t.authors a")
	List<TitleAndAuthorDTO> findTitleAndAuthor();

	List<Title> findByTitleContaining(String str);

	List<Title> findByPriceBetween(Double min, Double max);
	
	List<Title> findFirst5ByOrderByYtdSalesDesc();
	
	@Query("select t.title as title ,t.price as price ,t.ytdSales as ytdSales,t.publisher.pubName as pubName ,a.auName  as auName from Title t join t.authors a where titleId like %:titleId%  ")
	List<TitleDetailsDTO > findAllDetailsByTitle(@Param("titleId") String titleId);
	
	
}
