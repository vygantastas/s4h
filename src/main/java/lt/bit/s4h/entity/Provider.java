package lt.bit.s4h.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@Column(name = "username", nullable = false)
	@NotBlank // " ", " ", "\n", null
	@Size(min = 3, max = 25)
	private String username;

	@Column(name = "password", nullable = false)
	@Size(min = 3, max = 20)
	private String password;

	@Column(name = "name")
	private String name;

	@Size(min = 7, max = 12)
	private String phone;

	@Column
	private String sort;

	public Provider() {
	}

	public Provider(@NotNull int id, @NotBlank @Size(min = 3, max = 25) String username,
			@Size(min = 3, max = 20) String password, @Size(min = 7, max = 12) String phone) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public Provider setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
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

	public String getPassword() {
		return password;
	}

	public Provider setPassword(String password) {
		this.password = password;
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
