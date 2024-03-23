package co.istad.springwebmvc.service;

import co.istad.springwebmvc.dto.CategoryRequest;
import co.istad.springwebmvc.dto.CategoryResponse;
import co.istad.springwebmvc.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponse> findAllCategory();

    void createNewProduct(CategoryRequest categoryRequest);

    CategoryResponse editCategoryById(Integer id, CategoryRequest request);

    void deleteProductById(Integer id);
    CategoryResponse findCategoryById(Integer id);

}
