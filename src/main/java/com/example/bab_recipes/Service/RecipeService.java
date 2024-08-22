package com.example.bab_recipes.Service;

import com.example.bab_recipes.Domain.MongoRecipe;
import com.example.bab_recipes.Repository.mongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private mongoRepository mongoRepository;

    @Autowired
    private CategoryService categoryService;

    // 모든 레시피 가져오기
    public List<MongoRecipe> getAllRecipes() {
        return mongoRepository.findAll();
    }

    // 카테고리별 레시피 가져오기
    public List<MongoRecipe> getRecipesByCategoryCode(String categoryCode) {
        String categoryName = categoryService.getCategory(categoryCode);
        return mongoRepository.findByCategory(categoryName);
    }
}
