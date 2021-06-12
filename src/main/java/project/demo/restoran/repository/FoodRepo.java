package project.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.restoran.model.menu.FoodMenu;


public interface FoodRepo extends JpaRepository<FoodMenu, Integer> {

}
