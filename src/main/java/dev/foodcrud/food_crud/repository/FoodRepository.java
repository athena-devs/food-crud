package dev.foodcrud.food_crud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.foodcrud.food_crud.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
}
