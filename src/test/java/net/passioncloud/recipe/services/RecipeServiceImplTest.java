package net.passioncloud.recipe.services;

import net.passioncloud.recipe.domain.Recipe;
import net.passioncloud.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void recipeList() {
        Recipe recipe1 = new Recipe();
        Set<Recipe> testRecipeSet = new HashSet<>();
        testRecipeSet.add(recipe1);
        Mockito.when(recipeRepository.findAll()).thenReturn(testRecipeSet);
        Iterable<Recipe> recipes = recipeService.recipeList();
        Set<Recipe> recipeSet = new HashSet<>();
        recipes.forEach(recipeSet::add);

        assertEquals(1, recipeSet.size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}