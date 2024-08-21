package com.example.bab_recipes.Controller;

import com.example.bab_recipes.Domain.MongoRecipe;
import com.example.bab_recipes.Service.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TodayController {

    @Autowired
    private TodayService todayService;
    /*
    Today - today_eat / eat_detail
     */
    @GetMapping("/Today")
    public String Today_eat(){
        return "/Today_eat";
    }

    @PostMapping("/search")
    @ResponseBody
    public ModelAndView todayEatSearch(@RequestBody Map<String, List<String>> requestData) {
        List<String> fridgeItems = requestData.get("fridgeItems");
        List<String> excludedItems = requestData.get("excludedItems");
        String[] fridgeItemsArray = fridgeItems.toArray(new String[0]);
        String[] excludeItemsArray = excludedItems.toArray(new String[0]);

        List<MongoRecipe> recipes = todayService.searchRecipes(fridgeItemsArray, excludeItemsArray);

        ModelAndView modelAndView = new ModelAndView("Today_eat_detail");
        modelAndView.addObject("fridgeItems", fridgeItems);
        modelAndView.addObject("excludedItems", excludedItems);
        modelAndView.addObject("recipes", recipes);

        return modelAndView;
    }
}
