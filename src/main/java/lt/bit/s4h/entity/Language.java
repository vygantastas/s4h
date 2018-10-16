package lt.bit.s4h.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	private byte direction;
	private byte work;
	private LocalDate free;
	private byte rating;

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

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

	public byte getDirection() {
		return direction;
	}

	public void setDirection(byte direction) {
		this.direction = direction;
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

}
