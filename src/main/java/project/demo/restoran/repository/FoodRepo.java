package project.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.demo.restoran.model.menu.FoodMenu;

@Repository
public interface FoodRepo extends JpaRepository<FoodMenu, Integer> {

}
