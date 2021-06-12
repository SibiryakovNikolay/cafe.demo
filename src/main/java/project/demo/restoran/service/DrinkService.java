package project.demo.restoran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.restoran.model.menu.DrinkMenu;
import project.demo.restoran.repository.DrinkRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService implements RestoranService<DrinkMenu>{
    private final DrinkRepo drinkRepo;

    @Autowired
    public DrinkService(DrinkRepo drinkRepo) {
        this.drinkRepo = drinkRepo;
    }
    @Override
    public List<DrinkMenu> getAllList() {
        List<DrinkMenu> list = drinkRepo.findAll();
        return list;
    }
    @Override
    public void save(DrinkMenu drinkMenu) {
        drinkRepo.save(drinkMenu);
    }
    @Override
    public DrinkMenu findById(int id) {
        DrinkMenu drinkMenu=null;
        Optional<DrinkMenu> findId = drinkRepo.findById(id);
        if(findId.isPresent()){
        drinkMenu=findId.get();}
        return drinkMenu;

    }
    @Override
    public void deleteById(int id) {
        drinkRepo.deleteById(id);
    }
}

