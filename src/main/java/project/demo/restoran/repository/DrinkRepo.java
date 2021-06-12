package project.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.restoran.model.menu.DrinkMenu;

public interface DrinkRepo extends JpaRepository<DrinkMenu, Integer> {
}