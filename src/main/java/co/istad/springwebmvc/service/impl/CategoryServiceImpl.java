package co.istad.springwebmvc.service.impl;

import co.istad.springwebmvc.dto.CategoryRequest;
import co.istad.springwebmvc.dto.CategoryResponse;
import co.istad.springwebmvc.model.Category;
import co.istad.springwebmvc.repository.CategoryRepository;
import co.istad.springwebmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> findAllCategory() {
        List<Category> categories = categoryRepository.findAll();
     return  categories.stream().map(category -> new CategoryResponse(
                category.getName(),
                category.getDescription()
        )).toList();

    }

    @Override
    public void createNewProduct(CategoryRequest categoryRequest) {
        if(categoryRepository.existsByName(categoryRequest.name())){
                throw  new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Category already exited!!"
                );
        }
        Category category = new Category();
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description());
        categoryRepository.save(category);
    }

    @Override
    public CategoryResponse editCategoryById(Integer id, CategoryRequest request) {
       Category category = categoryRepository.findById(id).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category has not been found!!")
       );
       category.setName(request.name());
       category.setDescription(request.description());
       categoryRepository.save(category);
       return  this.findCategoryById(id);
    }

    @Override
    public void deleteProductById(Integer id) {
      if(!categoryRepository.existsById(id)){
          throw new ResponseStatusException(
                  HttpStatus.NOT_FOUND,
                  "Category has not been found!!"
          );
      }
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
       Category category = categoryRepository.findById(id).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category has not been found!!"));
       return new CategoryResponse(category.getName(), category.getDescription());
    }




}
