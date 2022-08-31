package net.passioncloud.recipe.services;

import lombok.extern.slf4j.Slf4j;
import net.passioncloud.recipe.domain.Recipe;
import net.passioncloud.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{
    public final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        log.info("How are you my runner?");
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Iterable<Recipe> recipeList() {
        return recipeRepository.findAll();
    }
}
