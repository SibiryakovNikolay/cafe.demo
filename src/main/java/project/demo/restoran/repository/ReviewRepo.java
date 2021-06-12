package project.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.restoran.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
