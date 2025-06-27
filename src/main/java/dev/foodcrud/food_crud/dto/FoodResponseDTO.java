package dev.foodcrud.food_crud.dto;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import dev.foodcrud.food_crud.model.Food;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class FoodResponseDTO {
    private Long id;
    private String name;
    private DateTimeFormat expirationDate;
    private Integer quantity;
    private BigDecimal price;

    public static FoodResponseDTO transformToDTO(Food food) {
      return new FoodResponseDTO(food.getId(), food.getName(), food.getExpirationDate(), food.getQuantity(), food.getPrice());
    }

}
