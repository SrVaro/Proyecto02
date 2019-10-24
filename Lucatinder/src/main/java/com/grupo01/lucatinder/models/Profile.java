package com.grupo01.lucatinder.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



import javax.persistence.JoinColumn;

/**
 * 
 * @author Andres
 * 
 * @Date 16/10/19
 *
 */

@Entity
@Table(name = "profiles")
public class Profile {

	private int id_profile;
	private String name;
	private boolean gender;
	private int age;
	private String description;
	private boolean desired_gender;
	private int desired_age_max;
	private int desired_age_min;
	private String image;
	private String password;
    private List<Category> category;
	
	public Profile() {
	
	}

	
	public Profile(int id_profile, String name, boolean gender, int age, String description, boolean desired_gender,
			int desired_age_max, int desired_age_min, String image) {
		super();
		this.id_profile = id_profile;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.description = description;
		this.desired_gender = desired_gender;
		this.desired_age_max = desired_age_max;
		this.desired_age_min = desired_age_min;
		this.image = image;
		
	}

	public Profile(String name, boolean gender, int age, String description, boolean desired_gender,
			int desired_age_max, int desired_age_min) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.description = description;
		this.desired_gender = desired_gender;
		this.desired_age_max = desired_age_max;
		this.desired_age_min = desired_age_min;
	}

	@Id
	@GeneratedValue
	public int getId_profile() {
		return id_profile;
	}
	
	public void setId_profile(int id_profile) {
		this.id_profile = id_profile;
	}

	@ManyToMany
    @JoinTable(name="profile_category",
                joinColumns=
                    @JoinColumn (name="id_profile", referencedColumnName="id_profile"),
                inverseJoinColumns=
                    @JoinColumn (name="id_category", referencedColumnName="id_category"))
	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getDesired_gender() {
		return desired_gender;
	}

	public void setDesired_gender(boolean desired_gender) {
		this.desired_gender = desired_gender;
	}

	public int getDesired_age_max() {
		return desired_age_max;
	}

	public void setDesired_age_max(int desired_age_max) {
		this.desired_age_max = desired_age_max;
	}

	public int getDesired_age_min() {
		return desired_age_min;
	}

	public void setDesired_age_min(int desired_age_min) {
		this.desired_age_min = desired_age_min;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Profile [id_profile=" + id_profile + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", description=" + description + ", desired_gender=" + desired_gender + ", desired_age_max="
				+ desired_age_max + ", desired_age_min=" + desired_age_min + ", image=" + image + ", password="
				+ password + ", category=" + category + "]";
	}

}
