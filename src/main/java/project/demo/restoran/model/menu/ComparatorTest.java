package project.demo.restoran.model.menu;

import java.util.Comparator;

public class ComparatorTest implements Comparator<Food> {
    @Override
    public int compare(Food x1, Food x2) {
            if(x1.getCost()>x2.getCost()){
                return 1; }
            else if(x1.getCost()<x2.getCost()){
                return -1; }
            else
                return 0;
    }


}
