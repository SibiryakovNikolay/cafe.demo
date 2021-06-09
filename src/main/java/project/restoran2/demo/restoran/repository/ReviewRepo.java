package project.restoran2.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.restoran2.demo.restoran.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
