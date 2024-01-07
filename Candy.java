package task4;

import java.util.ArrayList;
import java.util.List;

public class Candy {

    private String name;
    private int energy;
    private List<String> types;
    private int water;
    private int sugar;
    private String ingredientType;
    private String production;

    public Candy() {
        types =  new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public List<String> getTypes() {
        return types;
    }

    public int getWater() {
        return water;
    }

    public int getSugar() {
        return sugar;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public String getProduction() {
        return production;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", types=" + types +
                ", water=" + water +
                ", sugar=" + sugar +
                ", ingredientType='" + ingredientType + '\'' +
                ", production='" + production + '\'' +
                '}';
    }
}
