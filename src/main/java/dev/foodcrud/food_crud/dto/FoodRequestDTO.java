package dev.foodcrud.food_crud.dto;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import dev.foodcrud.food_crud.model.Food;
import lombok.Getter;

@Getter
public class FoodRequestDTO {
    private String name;
    private DateTimeFormat expirationDate;
    private Integer quantity;
    private BigDecimal price;

    public Food transformToObject() {
        return new Food(name, expirationDate, quantity, price);
    }
}