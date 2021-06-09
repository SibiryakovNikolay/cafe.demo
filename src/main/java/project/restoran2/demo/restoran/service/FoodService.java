package project.restoran2.demo.restoran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.restoran2.demo.restoran.model.menu.FoodMenu;
import project.restoran2.demo.restoran.repository.FoodRepo;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements RestoranService<FoodMenu> {
    private final FoodRepo foodRepo;

    @Autowired
    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    @Override
    public List<FoodMenu> getAllList() {
        List<FoodMenu> list = foodRepo.findAll();
        return list;
    }

    @Override
    public void save(FoodMenu foodMenu) {
        foodRepo.save(foodMenu);
    }

    @Override
    public FoodMenu findById(int id) {
        FoodMenu foodMenu = null;
        Optional<FoodMenu> findId = foodRepo.findById(id);
        if (findId.isPresent()) {
            foodMenu = findId.get();
        }
        return foodMenu;
    }

    public void deleteById(int id) {
        foodRepo.deleteById(id);
    }
}
