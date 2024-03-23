package co.istad.springwebmvc.repository;

import co.istad.springwebmvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);
}
