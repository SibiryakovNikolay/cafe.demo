package project.restoran2.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.restoran2.demo.restoran.model.Tables;

public interface TableRepo extends JpaRepository<Tables, Integer> {
}
