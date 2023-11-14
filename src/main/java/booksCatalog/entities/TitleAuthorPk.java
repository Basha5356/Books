package booksCatalog.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TitleAuthorPk implements Serializable {

	@Column(name = "title_id")
	private String titleId;

	@Column(name = "au_id")
	private String auId;

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getAuId() {
		return auId;
	}

	public void setAuId(String auId) {
		this.auId = auId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auId, titleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TitleAuthorPk other = (TitleAuthorPk) obj;
		return Objects.equals(auId, other.auId) && Objects.equals(titleId, other.titleId);
	}

	@Override
	public String toString() {
		return "TitleAuthorPk [titleId=" + titleId + ", auId=" + auId + "]";
	}

}
