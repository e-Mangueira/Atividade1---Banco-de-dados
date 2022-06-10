package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Professor implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer id;
		private String name;
		private String email;
		private Date birthDate;
		private Integer cpf;
		private Double baseSalary;
		
		private Department department;
		
		public Professor() {
		}

		public Professor(Integer id, String name, String email, Date birthDate, Integer cpf, Double baseSalary,
				Department department) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.birthDate = birthDate;
			this.cpf = cpf;
			this.baseSalary = baseSalary;
			this.department = department;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}

		public Integer getCpf() {
			return cpf;
		}

		public void setCpf(Integer cpf) {
			this.cpf = cpf;
		}

		public Double getBaseSalary() {
			return baseSalary;
		}

		public void setBaseSalary(Double baseSalary) {
			this.baseSalary = baseSalary;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Professor other = (Professor) obj;
			return Objects.equals(id, other.id);
		}

		@Override
		public String toString() {
			return "Professor [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", cpf="
					+ cpf + ", baseSalary=" + baseSalary + ", department=" + department + "]";
		}
		 
		 
}
