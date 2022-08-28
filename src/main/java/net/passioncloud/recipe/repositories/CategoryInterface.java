package net.passioncloud.recipe.repositories;

import net.passioncloud.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryInterface extends CrudRepository<Category, Long> {
}
