package project.demo.restoran.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo.restoran.repository.TableRepo;
import project.demo.restoran.model.Tables;
import project.demo.restoran.service.RestoranService;

import java.util.List;
import java.util.Optional;

@Service
public class TableService implements RestoranService<Tables> {
    private TableRepo tableRepo;

    @Autowired
    public TableService(TableRepo tableRepo) {
        this.tableRepo = tableRepo;
    }

    @Override
    public List<Tables> getAllList() {
        List<Tables> tablesList = tableRepo.findAll();
        return tablesList;
    }

    @Override
    public void save(Tables tables) {
        tableRepo.save(tables);
    }

    @Override
    public void deleteById(int id) {
        tableRepo.deleteById(id);
    }

    @Override
    public Tables findById(int id) {
        Tables tables = null;
        Optional<Tables> findId = tableRepo.findById(id);
        if(findId.isPresent()){
            tables =findId.get();
        }
        return tables;
    }
}
