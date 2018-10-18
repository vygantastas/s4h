package lt.bit.s4h.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "languages")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lang_id")
	private int langId;

	@Column(name = "prov_id")
	private int provId;

	@Column(name = "first", nullable = false)
	@NotBlank // " ", " ", "\n", null
	private String first;

	@Column(name = "second", nullable = false)
	@NotBlank // " ", " ", "\n", null
	private String second;

	@Column
	private byte work;
	@Column
	private LocalDate free;
	@Column
	private byte rating;

	@Column
	private float price;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	@ManyToOne
	@JoinColumn(name = "prov_id")
	public int getProvId() {
		return provId;
	}

	public void setProvId(int provId) {
		this.provId = provId;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String langFirst) {
		this.first = langFirst;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String langSecond) {
		this.second = langSecond;
	}

	public byte getWork() {
		return work;
	}

	public void setWork(byte work) {
		this.work = work;
	}

	public LocalDate getFree() {
		return free;
	}

	public void setFree(LocalDate free) {
		this.free = free;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Language [langId=" + langId + ", provId=" + provId + ", first=" + first + ", second=" + second
				+ ", work=" + work + ", free=" + free + ", rating=" + rating + ", price=" + price + "]";
	}
}
