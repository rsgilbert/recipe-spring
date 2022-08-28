package net.passioncloud.recipe.services;

import net.passioncloud.recipe.domain.Recipe;

import java.util.Iterator;
import java.util.List;

public interface RecipeService {
    Iterable<Recipe> recipeList();
}
