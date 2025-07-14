package dev.foodcrud.food_crud.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.foodcrud.food_crud.dto.FoodRequestDTO;
import dev.foodcrud.food_crud.dto.FoodResponseDTO;
import dev.foodcrud.food_crud.service.FoodService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/")
public class FoodController {
  private final FoodService foodService;

  public FoodController(FoodService foodService) {
    this.foodService = foodService;
  }

  @PostMapping("/create")
  public ResponseEntity<FoodResponseDTO> create(@RequestBody FoodRequestDTO foodRequestDTO) {
    FoodResponseDTO newFood = foodService.createFood(foodRequestDTO);
    return ResponseEntity.status(201).body(newFood);
  }

  @GetMapping("/")
  public ResponseEntity<List<FoodResponseDTO>> getAll() {
    List<FoodResponseDTO> response = foodService.getFood();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FoodResponseDTO> getById(@PathVariable UUID id) {
    FoodResponseDTO response = foodService.getFoodById(id);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<FoodResponseDTO> updateById(@PathVariable UUID id, @RequestBody FoodRequestDTO foodRequestDTO) {
    FoodResponseDTO response = foodService.updateFoodById(id, foodRequestDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    foodService.deleteFood(id);
    return ResponseEntity.noContent().build();
  }

}
