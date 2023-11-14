package booksCatalog.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Publishers")
public class Publisher {

	@Id
	@Column(name = "pub_id")
	private String pubId;

	@Column(name = "pub_name")
	private String pubName;

	@Column(name = "email")
	private String email;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	public Publisher(String pubId, String pubName, String email, String city, String country, List<Title> titles) {
		super();
		this.pubId = pubId;
		this.pubName = pubName;
		this.email = email;
		this.city = city;
		this.country = country;
		this.titles = titles;
	}

	public Publisher() {
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
	@JsonIgnore
	private List<Title> titles = new ArrayList<>();

	public String getPubId() {
		return pubId;
	}

	public void setPubId(String pubId) {
		this.pubId = pubId;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	@Override
	public String toString() {
		return "Publisher [pubId=" + pubId + ", pubName=" + pubName + ", email=" + email + ", city=" + city
				+ ", country=" + country + ", titles=" + titles + "]";
	}

}
