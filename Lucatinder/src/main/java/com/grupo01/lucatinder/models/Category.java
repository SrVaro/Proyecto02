package com.grupo01.lucatinder.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categorys")
public class Category {
	
	private int id_category;
	private String name;
	
	@JsonIgnore
	private List<Profile> profile;
	
	@Id
    @GeneratedValue
    @Column(name = "id_category")
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	
	@ManyToMany (mappedBy="category")
	public List<Profile> getProfile() {
		return profile;
	}
	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}
}
