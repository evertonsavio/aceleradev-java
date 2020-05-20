package challenge;

import javax.persistence.*;

@Entity
@Table(name = "scripts")
public class Quote {

	private String actor;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "detail")
	public String quote;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
			this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

}
