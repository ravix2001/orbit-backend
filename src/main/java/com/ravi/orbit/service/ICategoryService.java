package com.ravi.orbit.service;

import com.ravi.orbit.dto.CategoryDTO;
import com.ravi.orbit.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ICategoryService {

    CategoryDTO handleCategory(CategoryDTO categoryDTO);

    Page<CategoryDTO> getAllCategories(Pageable pageable);

    CategoryDTO getCategoryDTOById(UUID id);

    void deleteCategory(UUID id);

    void deleteCategoryHard(UUID id);

    Category getCategoryById(UUID id);

}
