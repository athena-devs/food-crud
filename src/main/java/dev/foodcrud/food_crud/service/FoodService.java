package dev.foodcrud.food_crud.service;

import java.util.List;

import dev.foodcrud.food_crud.dto.FoodRequestDTO;
import dev.foodcrud.food_crud.dto.FoodResponseDTO;

public interface FoodService {
    FoodResponseDTO createFood(FoodRequestDTO foodRequestDTO);
    List<FoodResponseDTO> getFood();
    FoodResponseDTO getFoodById(Long id);
}
