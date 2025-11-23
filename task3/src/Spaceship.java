// Класс корабля наследуется от Vehicle
class Spaceship extends Vehicle {
    // Инкапсуляция: поля приватные
    private String hullType;
    private int crewCapacity;

    // Конструктор с вызовом родительского конструктора
    Spaceship(String call, String hull, double mass, double fuel, int crew, double speed) {
        super(call, mass, fuel, speed); // вызов конструктора Vehicle
        this.hullType = hull;
        this.crewCapacity = crew;
    }

    // Геттеры
    public String getHullType() {
        return this.hullType;
    }

    public int getCrewCapacity() {
        return this.crewCapacity;
    }

    // Сеттеры с контролем
    public void setHullType(String hull) {
        this.hullType = hull;
    }

    public void setCrewCapacity(int crew) {
        if (crew < 0) {
            this.crewCapacity = 0;
        } else {
            this.crewCapacity = crew;
        }
    }

    // Переопределение метода move() - корабли летят
    @Override
    public void move(double distance) {
        // Корабли тратят больше топлива при полёте
        double fuelConsumption = distance * 0.15;
        this.consumeFuel(fuelConsumption);
        System.out.println("Корабль " + this.getCallsign() + " пролетел " + distance + " единиц расстояния");
    }

    // Специфичный метод для кораблей
    public void fly(double distance) {
        this.move(distance);
    }
}

