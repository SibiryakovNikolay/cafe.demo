package project.demo.restoran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.demo.restoran.model.Tables;

public interface TableRepo extends JpaRepository<Tables, Integer> {
}
