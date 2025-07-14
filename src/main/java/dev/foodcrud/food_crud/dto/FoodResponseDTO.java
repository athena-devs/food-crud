package dev.foodcrud.food_crud.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import dev.foodcrud.food_crud.model.Food;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodResponseDTO {
  private UUID id;
  private String name;
  private LocalDate expirationDate;
  private Integer quantity;
  private BigDecimal price;

  public FoodResponseDTO(Food food) {
    this.id = food.getId();
    this.name = food.getName();
    this.expirationDate = food.getExpirationDate();
    this.quantity = food.getQuantity();
    this.price = food.getPrice();
  }
}
