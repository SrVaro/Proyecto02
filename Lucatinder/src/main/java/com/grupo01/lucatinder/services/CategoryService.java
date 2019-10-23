package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.List;
import com.grupo01.lucatinder.models.Category;


public interface CategoryService {

	Optional<Category> getCategoryId(int id);

	void updateCategory(Category profile);

	void deleteCategory(int id);

	Category addCategory(Category p);

	List<Category> getAllCategorys();
}
