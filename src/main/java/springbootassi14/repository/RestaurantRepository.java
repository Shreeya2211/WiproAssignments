package springbootassi14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootassi14.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> { }
