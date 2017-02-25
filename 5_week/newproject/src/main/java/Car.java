class Car {
    private int id;
    private String model;
    private String make;
    private int price;
    private Engine engine;

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getPrice() {
        return price;
    }

    public Car(int id, String model, String make, int price) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.price = price;
    }

    public Car(int id, String model, String make, int price, Engine engine) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.price = price;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", model = '" + model + '\'' +
                ", make = '" + make + '\'' +
                ", price = " + price;
    }
}