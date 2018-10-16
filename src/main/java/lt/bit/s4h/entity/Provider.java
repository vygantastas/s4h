package lt.bit.s4h.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "providers")
public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	@NotBlank // " ", " ", "\n", null
	@Size(min = 4, max = 25)
	private String name;

	@Column(name = "passw", nullable = false)
	@Size(min = 4, max = 20)
	private String passw;

	@Size(min = 7, max = 12)
	private String phone;

	public Provider() {

	}

	public Provider(@NotNull int id, @NotBlank @Size(min = 4, max = 100) String name,
			@Size(min = 4, max = 20) String passw, @Size(min = 7, max = 12) String phone) {
		this.id = id;
		this.name = name;
		this.passw = passw;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Provider setName(String name) {
		this.name = name;
		return this;
	}

	public String getPassw() {
		return passw;
	}

	public Provider setPassw(String passw) {
		this.passw = passw;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
