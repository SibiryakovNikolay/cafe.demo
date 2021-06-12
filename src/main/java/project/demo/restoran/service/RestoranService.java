package project.demo.restoran.service;

import java.util.List;

public interface RestoranService <T>{
    List<T> getAllList();
    void save (T t);
    void deleteById(int id);
    T findById(int id);

}
