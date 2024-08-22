package com.example.bab_recipes.Repository;

import com.example.bab_recipes.Domain.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipes, Long> {
    List<Recipes> findByCategories_CategoryName(String categoryName);
}
