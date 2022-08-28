package net.passioncloud.recipe.services;

import net.passioncloud.recipe.domain.Recipe;
import net.passioncloud.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    public final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> recipeList() {
        return recipeRepository.findAll();
    }
}
