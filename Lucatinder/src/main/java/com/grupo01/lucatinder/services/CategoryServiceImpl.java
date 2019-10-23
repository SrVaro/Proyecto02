package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.Random;

import javax.persistence.NoResultException;

import java.io.IOException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.grupo01.lucatinder.models.Category;
import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.CategoryRepository;
import com.grupo01.lucatinder.repository.ProfileRepository;

@Repository
public class CategoryServiceImpl implements CategoryService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRep;

	CategoryServiceImpl() {
	}

	@Override
	public Category addCategory(Category p) {
		try {
			p = categoryRep.save(p);
		} catch (Exception ex) {
			p = null;
		}
		return p;
	}
	
	@Override
	public void deleteCategory(int id) {
		categoryRep.deleteById(id);
	}

	@Override
	public void updateCategory(Category profile) {
		categoryRep.save(profile);
	}

	@Override
	public Optional<Category> getCategoryId(int id) {
		return categoryRep.findById(id);
	}

}
