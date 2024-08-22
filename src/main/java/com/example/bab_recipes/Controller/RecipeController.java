package com.example.bab_recipes.Controller;

import com.example.bab_recipes.Domain.MongoRecipe;
import com.example.bab_recipes.Service.RecipeService;
import com.example.bab_recipes.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/main/search")
    public String showRecipes(@RequestParam(value = "category", required = false) String category, Model model) {
        List<MongoRecipe> recipes;

        if (category == null || category.equals("all")) {
            recipes = recipeService.getAllRecipes();
        } else {
            recipes = recipeService.getRecipesByCategoryCode(category);
        }

        // 카테고리 리스트와 레시피 데이터를 모델에 추가
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("recipes", recipes);
        model.addAttribute("selectedCategory", category); // 현재 선택된 카테고리 전달

        return "main_search";
    }
}
