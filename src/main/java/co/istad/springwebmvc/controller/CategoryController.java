package co.istad.springwebmvc.controller;

import co.istad.springwebmvc.dto.CategoryRequest;
import co.istad.springwebmvc.dto.CategoryResponse;
import co.istad.springwebmvc.model.Category;
import co.istad.springwebmvc.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<CategoryResponse> findCategories() {
        return categoryService.findAllCategory();
    };
    @GetMapping("{id}")
    CategoryResponse getCategoryById(@PathVariable Integer id) {
        return categoryService.findCategoryById(id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteProductById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    void createNewCategory(@Valid @RequestBody CategoryRequest request){
        categoryService.createNewProduct(request);
    }
    @PutMapping("{id}")
    CategoryResponse editCategoryById( @Valid @PathVariable Integer id, @RequestBody CategoryRequest request){
        return    categoryService.editCategoryById(id, request);
    }
}