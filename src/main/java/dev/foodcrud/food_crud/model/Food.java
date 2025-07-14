package dev.foodcrud.food_crud.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

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
  private UUID id;
  private String name;
  private LocalDate expirationDate;
  private Integer quantity;
  private BigDecimal price;

  public Food(UUID id, String name, LocalDate expirationDate, Integer quantity, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.expirationDate = expirationDate;
    this.quantity = quantity;
    this.price = price;
  }
}
