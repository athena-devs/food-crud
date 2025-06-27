package dev.foodcrud.food_crud.service.impl;
import java.util.List;
import dev.foodcrud.food_crud.dto.FoodRequestDTO;
import dev.foodcrud.food_crud.dto.FoodResponseDTO;
import dev.foodcrud.food_crud.model.Food;
import dev.foodcrud.food_crud.repository.FoodRepository;
import dev.foodcrud.food_crud.service.FoodService;

public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository){
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
        return new FoodResponseDTO(saveFood.getId(), saveFood.getName(), saveFood.getExpirationDate(), saveFood.getQuantity(), saveFood.getPrice());
    }

    @Override
    public List<FoodResponseDTO> getFood() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFood'");
    }

    @Override
    public FoodResponseDTO getFoodById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFoodById'");
    }
}
