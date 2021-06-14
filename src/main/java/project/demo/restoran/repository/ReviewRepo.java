package project.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.demo.restoran.model.Review;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
