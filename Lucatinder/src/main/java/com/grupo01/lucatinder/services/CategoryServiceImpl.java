package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.grupo01.lucatinder.models.Category;
import com.grupo01.lucatinder.repository.CategoryRepository;

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
	
	@Override
	public List<Category> getAllCategorys(){
		return categoryRep.findAll();
	}

}
