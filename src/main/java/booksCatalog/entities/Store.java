package booksCatalog.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Stores")
public class Store {

	@Id
	@Column(name = "store_id")
	private String storeId;

	@Column(name = "location")
	private String location;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "Sales", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "title_id"))
	Set<Title> titles = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="store")
	@JsonIgnore
	List<Sale>sales = new ArrayList<>();

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Title> getTitles() {
		return titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", location=" + location + ", city=" + city + ", country=" + country
				+ ", titles=" + titles + ", sales=" + sales + "]";
	}

	

}
