package booksCatalog.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SalePk implements Serializable {
	@Column(name = "store_id")
	private String storeID;

	@Column(name = "title_id")
	private String titleId;
	
	

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	@Override
	public String toString() {
		return "SalePk [storeID=" + storeID + ", titleId=" + titleId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(storeID, titleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalePk other = (SalePk) obj;
		return Objects.equals(storeID, other.storeID) && Objects.equals(titleId, other.titleId);
	}

}
