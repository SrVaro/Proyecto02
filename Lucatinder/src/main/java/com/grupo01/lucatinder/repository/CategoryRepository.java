package com.grupo01.lucatinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grupo01.lucatinder.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>, ProfileRepositoryCustom {

}
