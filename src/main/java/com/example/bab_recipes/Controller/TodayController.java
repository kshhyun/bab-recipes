package com.example.bab_recipes.Controller;

import com.example.bab_recipes.Domain.MongoRecipe;
import com.example.bab_recipes.Service.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class TodayController {

    @Autowired
    private TodayService todayService;

    /*
    Today - today_eat / eat_detail
     */
    @GetMapping("/Today")
    public String Today_eat() {
        return "/Today_eat";
    }

    @PostMapping("/search")
    public ModelAndView todayEatSearch(@RequestParam(required = false) String fridgeTags, @RequestParam(required = false) String excludeTags) {
        String[] fridgeItemsArray = {};
        String[] excludeItemsArray = {};

        if (fridgeTags != null && !fridgeTags.isEmpty()) {
            fridgeItemsArray = fridgeTags.split(",");
        }

        if (excludeTags == null || excludeTags.isEmpty()) {
            System.out.println("if (searchOne): " + fridgeTags);
            List<MongoRecipe> recipes = todayService.searchOne(fridgeItemsArray);

            ModelAndView modelAndView = new ModelAndView("Today_eat_detail");
            modelAndView.addObject("fridgeItems", Arrays.asList(fridgeItemsArray));
            modelAndView.addObject("recipes", recipes);
            return modelAndView;
        } else {
            System.out.println("else (searchRecipes): " + fridgeTags + ", " + excludeTags);
            excludeItemsArray = excludeTags.split(",");
            List<MongoRecipe> recipes = todayService.searchRecipes(fridgeItemsArray, excludeItemsArray);

            ModelAndView modelAndView = new ModelAndView("Today_eat_detail");
            modelAndView.addObject("fridgeItems", Arrays.asList(fridgeItemsArray));
            modelAndView.addObject("excludedItems", Arrays.asList(excludeItemsArray));
            modelAndView.addObject("recipes", recipes);
            return modelAndView;
        }
    }

    @GetMapping("/recipe/detail/{recipeId}")
    public ModelAndView recipeDetail(@PathVariable("recipeId") Optional<String> recipeId) {
        String Id = Optional.of(recipeId.orElse("")).orElse("");

        Optional<MongoRecipe> recipe = todayService.detailRecipe(Id);

        System.out.println(recipe.get().getIngredients().keySet().toString());
        System.out.println(recipe.get().getIngredients().values());
        System.out.println(recipe.get().getSteps().keySet().toString());
        System.out.println(recipe.get().getSteps().values());
        if (recipe.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("Recipes_detail");
            modelAndView.addObject("recipe", recipe.get());
            return modelAndView;
        }

        return new ModelAndView("Today_eat");
    }
}
