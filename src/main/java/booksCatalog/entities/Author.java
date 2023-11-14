package booksCatalog.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Authors")
public class Author {

	@Id
	@Column(name = "au_id")
	private String auId;

	@Column(name = "au_name")
	private String auName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@ManyToMany(mappedBy = "authors")
	@JsonIgnore
	private Set<Title> titles = new HashSet<>();

	public String getAuId() {
		return auId;
	}

	public void setAuId(String auId) {
		this.auId = auId;
	}

	public String getAuName() {
		return auName;
	}

	public void setAuName(String auName) {
		this.auName = auName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	@Override
	public String toString() {
		return "Author [auId=" + auId + ", auName=" + auName + ", email=" + email + ", mobile=" + mobile + ", city="
				+ city + ", country=" + country + ", titles=" + titles + "]";
	}

	

}
