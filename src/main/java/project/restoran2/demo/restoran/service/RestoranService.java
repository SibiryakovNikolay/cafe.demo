package project.restoran2.demo.restoran.service;

import project.restoran2.demo.restoran.repository.DrinkRepo;

import java.util.List;

public interface RestoranService <T>{
    List<T> getAllList();
    void save (T t);
    void deleteById(int id);
    T findById(int id);

}
