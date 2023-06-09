package com.meds.repository;

import com.meds.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    public boolean existsCategoriesById(long id);
    public boolean existsCategoriesByName(String name);
}
