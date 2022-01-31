package learnersadmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "teachers")
@Table(name = "teachers")
public class TeacherModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = false, nullable = false, length = 150)
	private String fullName;

	private String phoneNumber;

	@Column(unique = true, nullable = false, length = 150)
	private String email;

	public TeacherModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherModel(int id, String fullName, String phoneNumber, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public TeacherModel(String fullName, String phoneNumber, String email) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "TeacherModel [id=" + id + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}

}
