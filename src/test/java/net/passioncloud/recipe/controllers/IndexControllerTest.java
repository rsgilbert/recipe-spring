package net.passioncloud.recipe.controllers;

import net.passioncloud.recipe.domain.Recipe;
import net.passioncloud.recipe.repositories.CategoryRepository;
import net.passioncloud.recipe.repositories.UnitOfMeasureRepository;
import net.passioncloud.recipe.services.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController indexController;

    @Mock
    RecipeService recipeService;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;
    @Mock
    CategoryRepository categoryRepository;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService, categoryRepository, unitOfMeasureRepository);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getIndex_returnsIndex() {
        // given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe rec2 = new Recipe();
        rec2.setId(7L);
        recipes.add(rec2);
        Mockito.when(recipeService.recipeList()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        String result = indexController.getIndex(model);
        Assertions.assertEquals("index", result);
        Mockito.verify(recipeService, Mockito.times(1)).recipeList();
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        Assertions.assertEquals(2, setInController.size());
    }

}