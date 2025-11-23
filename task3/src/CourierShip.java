// Курьерский корабль - наследник Spaceship
class CourierShip extends Spaceship {
    private double cargoCapacity;

    CourierShip(String call, double mass, double fuel, int crew, double speed, double cargo) {
        super(call, "Лёгкий курьер", mass, fuel, crew, speed);
        this.cargoCapacity = cargo;
    }

    public double getCargoCapacity() {
        return this.cargoCapacity;
    }

    public void setCargoCapacity(double cargo) {
        if (cargo < 0.0) {
            this.cargoCapacity = 0.0;
        } else {
            this.cargoCapacity = cargo;
        }
    }

    // Переопределение метода move() - курьерские корабли быстрее и экономнее
    @Override
    public void move(double distance) {
        // Курьерские корабли тратят меньше топлива, но быстрее
        double fuelConsumption = distance * 0.08;
        this.consumeFuel(fuelConsumption);
        this.accelerate(0.05); // ускоряются при движении
        System.out.println("Курьерский корабль " + this.getCallsign() + 
                         " быстро пролетел " + distance + " единиц с грузом " + 
                         this.cargoCapacity + " тонн");
    }

    // Специфичный метод для курьерских кораблей
    public void deliverCargo() {
        System.out.println("Корабль " + this.getCallsign() + " доставляет груз");
    }
}

