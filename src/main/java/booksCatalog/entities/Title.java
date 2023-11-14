	package booksCatalog.entities;
	
	import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "Titles")
	public class Title {
	
		@Id
		@Column(name = "title_id")
		private String titleId;
	
		@Column(name = "title")
		private String title;
	
		@Column(name = "price")
		private Double price;
	
		@Column(name = "pub_id")
		private String pubId;
	
		@Column(name = "ytd_sales")
		private Integer ytdSales;
	
		@Column(name = "release_year")
		private LocalDate releaseYear;
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JsonIgnore
		@JoinColumn(name = "pub_id", insertable = false, updatable = false)
		private Publisher publisher;
	
		@ManyToMany
		@JsonIgnore
		@JoinTable(name = "Titleauthors", joinColumns = @JoinColumn(name = "title_id"), inverseJoinColumns = @JoinColumn(name = "au_id"))
		Set<Author> authors = new HashSet<Author>();
		
		 @OneToMany(mappedBy = "title", cascade = CascadeType.ALL)
		    private List<Sale> sales = new ArrayList<>();
		
		
		@ManyToMany(mappedBy = "titles")
		@JsonIgnore
		Set<Store> stores = new HashSet<>();
	
		public Title(String titleId, String title, Double price, String pubId, Integer ytdSales, LocalDate releaseYear,
				Publisher publisher, Set<Author> authors, Set<Store> stores) {
			this.titleId = titleId;
			this.title = title;
			this.price = price;
			this.pubId = pubId;
			this.ytdSales = ytdSales;
			this.releaseYear = releaseYear;
			this.publisher = publisher;
			this.authors = authors;
			this.stores = stores;
		}
	
		public Title() {
		}
	
		public String getTitleId() {
			return titleId;
		}
	
		public void setTitleId(String titleId) {
			this.titleId = titleId;
		}
	
		public String getTitle() {
			return title;
		}
	
		public void setTitle(String title) {
			this.title = title;
		}
	
		public Double getPrice() {
			return price;
		}
	
		public void setPrice(Double price) {
			this.price = price;
		}
	
		public String getPubId() {
			return pubId;
		}
	
		public void setPubId(String pubId) {
			this.pubId = pubId;
		}
	
		public Integer getYtdSales() {
			return ytdSales;
		}
	
		public void setYtdSales(Integer ytdSales) {
			this.ytdSales = ytdSales;
		}
	
		public LocalDate getReleaseYear() {
			return releaseYear;
		}
	
		public void setReleaseYear(LocalDate releaseYear) {
			this.releaseYear = releaseYear;
		}
	
		public Publisher getPublisher() {
			return publisher;
		}
	
		public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
		}
	
		public Set<Author> getAuthors() {
			return authors;
		}
	
		public void setAuthors(Set<Author> authors) {
			this.authors = authors;
		}
	
		public Set<Store> getStores() {
			return stores;
		}
	
		public void setStores(Set<Store> stores) {
			this.stores = stores;
		}
	
		@Override
		public String toString() {
			return "Title [titleId=" + titleId + ", title=" + title + ", price=" + price + ", pubId=" + pubId
					+ ", ytdSales=" + ytdSales + ", releaseYear=" + releaseYear + ", publisher=" + publisher + ", authors="
					+ authors + ", stores=" + stores + "]";
		}
	
	}