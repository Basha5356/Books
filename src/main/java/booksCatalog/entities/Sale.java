package booksCatalog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sales")
public class Sale {
	@EmbeddedId
	private SalePk key;

	@Column(name = "qty_sold")
	private String qtySold;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="store_id",insertable = false, updatable = false)
	private Store store;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    @JoinColumn(name = "title_id",insertable = false, updatable = false) 
    private Title title;

	public SalePk getKey() {
		return key;
	}

	public void setKey(SalePk key) {
		this.key = key;
	}

	public String getQtySold() {
		return qtySold;
	}

	public void setQtySold(String qtySold) {
		this.qtySold = qtySold;
	}

	@Override
	public String toString() {
		return "Sale [key=" + key + ", qtySold=" + qtySold + "]";
	}

}
