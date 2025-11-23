class Spaceship {
    String callsign;
    String hullType;
    double massTons;
    double remainingFuel;
    int crewCapacity;
    double topSpeed; // доля скорости света

    // Конструктор с параметрами
    Spaceship(String call, String hull, double mass, double fuel, int crew, double speed) {
        this.callsign = call;
        this.hullType = hull;
        this.massTons = mass;
        this.remainingFuel = fuel;
        this.crewCapacity = crew;
        this.topSpeed = speed;
    }

    // Заправить корабль
    void refuel(double amount) {
        this.remainingFuel += amount;
        if (this.remainingFuel > 100.0) {
            this.remainingFuel = 100.0; // максимум 100%
        }
    }

    // Потратить топливо
    void consumeFuel(double amount) {
        this.remainingFuel -= amount;
        if (this.remainingFuel < 0.0) {
            this.remainingFuel = 0.0; // минимум 0%
        }
    }

    // Установить скорость
    void setSpeed(double speed) {
        this.topSpeed = speed;
    }

    // Ускориться
    void accelerate(double increment) {
        this.topSpeed += increment;
    }

    // Замедлиться
    void decelerate(double decrement) {
        this.topSpeed -= decrement;
        if (this.topSpeed < 0.0) {
            this.topSpeed = 0.0;
        }
    }

    // Лететь (тратит топливо)
    void fly(double distance) {
        double fuelConsumption = distance * 0.1; // условный расход
        this.consumeFuel(fuelConsumption);
    }

    // Остановиться (скорость = 0)
    void stop() {
        this.topSpeed = 0.0;
    }
}

