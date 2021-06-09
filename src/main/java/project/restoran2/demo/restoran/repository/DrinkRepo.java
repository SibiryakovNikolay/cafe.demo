package project.restoran2.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.restoran2.demo.restoran.model.menu.DrinkMenu;

public interface DrinkRepo extends JpaRepository<DrinkMenu, Integer> {
}
