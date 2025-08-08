package springbootassi14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootassi14.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> { }
