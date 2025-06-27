package dev.foodcrud.food_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import dev.foodcrud.food_crud.dto.FoodRequestDTO;
import dev.foodcrud.food_crud.dto.FoodResponseDTO;
import dev.foodcrud.food_crud.service.FoodService;

public class FoodController {
    private final FoodService foodService;
    
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    public ResponseEntity<FoodResponseDTO> create(@RequestBody FoodRequestDTO foodRequestDTO) {
        FoodResponseDTO newFood = foodService.createFood(foodRequestDTO);
        return ResponseEntity.status(201).body(newFood); 
    }
}
