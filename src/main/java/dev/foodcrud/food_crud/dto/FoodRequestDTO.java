package dev.foodcrud.food_crud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import dev.foodcrud.food_crud.model.Food;
import lombok.Getter;

@Getter
public class FoodRequestDTO {
  private UUID id;
  private String name;
  private LocalDate expirationDate;
  private Integer quantity;
  private BigDecimal price;

  public Food transformToObject() {
    return new Food(id, name, expirationDate, quantity, price);
  }
}
