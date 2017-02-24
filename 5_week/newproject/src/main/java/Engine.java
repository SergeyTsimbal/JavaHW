import java.util.Set;

class Engine {
    private int id;
    private int displacement;
    private int power;
    private Set<Car> car;

    public int getId() {
        return id;
    }

    public int getDisplacement() {
        return displacement;
    }

    public int getPower() {
        return power;
    }

    public Engine(int id, int displacement, int power) {
        this.id = id;
        this.displacement = displacement;
        this.power = power;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", displacement = " + displacement +
                ", power = " + power;
    }
}