package com.skilldistillery.rewardforpay.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private  String name;
	
	@Column(name="manager_id")
	private  Integer managerId;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	private String description;
	
	@Column(name="website_url")
	private String websiteUrl;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
	
	
	
	
	
	public Department() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Company getCompanyId() {
		return company;
	}

	public void setCompanyId(Company company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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
		Department other = (Department) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", description=");
		builder.append(description);
		builder.append(", websiteUrl=");
		builder.append(websiteUrl);
		builder.append("]");
		return builder.toString();
	}
	
	
}
