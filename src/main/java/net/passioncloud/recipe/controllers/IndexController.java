package net.passioncloud.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import net.passioncloud.recipe.domain.Category;
import net.passioncloud.recipe.domain.UnitOfMeasure;
import net.passioncloud.recipe.repositories.CategoryRepository;
import net.passioncloud.recipe.repositories.UnitOfMeasureRepository;
import net.passioncloud.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(RecipeService recipeService, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @RequestMapping("")
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeService.recipeList());
        return "index";
    }
}
