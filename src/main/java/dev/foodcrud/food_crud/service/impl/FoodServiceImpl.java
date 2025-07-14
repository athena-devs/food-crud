package dev.foodcrud.food_crud.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.foodcrud.food_crud.dto.FoodRequestDTO;
import dev.foodcrud.food_crud.dto.FoodResponseDTO;
import dev.foodcrud.food_crud.exceptions.ResourceNotFoundException;
import dev.foodcrud.food_crud.model.Food;
import dev.foodcrud.food_crud.repository.FoodRepository;
import dev.foodcrud.food_crud.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

  private final FoodRepository foodRepository;

  public FoodServiceImpl(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  @Override
  public FoodResponseDTO createFood(FoodRequestDTO foodRequestDTO) {
    Food food = new Food();
    food.setName(foodRequestDTO.getName());
    food.setExpirationDate(foodRequestDTO.getExpirationDate());
    food.setQuantity(foodRequestDTO.getQuantity());
    food.setPrice(foodRequestDTO.getPrice());

    Food saveFood = foodRepository.save(food);
    return new FoodResponseDTO(saveFood);
  }

  @Override
  public List<FoodResponseDTO> getFood() {
    return foodRepository.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());
  }

  @Override
  public FoodResponseDTO getFoodById(UUID id) {
    return foodRepository.findById(id).map(FoodResponseDTO::new)
        .orElseThrow(() -> new ResourceNotFoundException("Food not found"));
  }

  @Override
  public FoodResponseDTO updateFoodById(UUID id, FoodRequestDTO foodRequestDTO) {
    Food foodToUpdate = foodRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Food not found"));

    foodToUpdate.setName(foodRequestDTO.getName());
    foodToUpdate.setExpirationDate(foodRequestDTO.getExpirationDate());
    foodToUpdate.setQuantity(foodRequestDTO.getQuantity());
    foodToUpdate.setPrice(foodRequestDTO.getPrice());

    Food updatedFood = foodRepository.save(foodToUpdate);
    return new FoodResponseDTO(updatedFood);
  }

  @Override
  public void deleteFood(UUID id) {
    foodRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Food not found"));

    foodRepository.deleteById(id);
  }
}
