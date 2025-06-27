package dev.foodcrud.food_crud.model;
import java.math.BigDecimal;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    private DateTimeFormat expirationDate;
    private Integer quantity;
    private BigDecimal price;

    public Food(String name, DateTimeFormat expirationDate, Integer quantity, BigDecimal price){
        this.name = name;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.price = price;
    }


}