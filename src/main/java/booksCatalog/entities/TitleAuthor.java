package booksCatalog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Titleauthors")
public class TitleAuthor {

	@EmbeddedId
	private TitleAuthorPk key;

	@Column(name = "royalty_pct")
	private Integer royaltyPct;

	public TitleAuthorPk getKey() {
		return key;
	}

	public void setKey(TitleAuthorPk key) {
		this.key = key;
	}

	public Integer getRoyaltyPct() {
		return royaltyPct;
	}

	public void setRoyaltyPct(Integer royaltyPct) {
		this.royaltyPct = royaltyPct;
	}

	@Override
	public String toString() {
		return "TitleAuthor [key=" + key + ", royaltyPct=" + royaltyPct + "]";
	}

}
