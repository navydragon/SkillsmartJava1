// Базовый класс для всех транспортных средств
class Vehicle {
    // Инкапсуляция: поля приватные
    private String callsign;
    private double massTons;
    private double remainingFuel;
    private double topSpeed; // доля скорости света

    // Конструктор
    Vehicle(String call, double mass, double fuel, double speed) {
        this.callsign = call;
        this.massTons = mass;
        this.remainingFuel = fuel;
        this.topSpeed = speed;
    }

    // Геттеры (инкапсуляция)
    public String getCallsign() {
        return this.callsign;
    }

    public double getMassTons() {
        return this.massTons;
    }

    public double getRemainingFuel() {
        return this.remainingFuel;
    }

    public double getTopSpeed() {
        return this.topSpeed;
    }

    // Сеттеры с контролем (инкапсуляция)
    public void setCallsign(String call) {
        this.callsign = call;
    }

    public void setMassTons(double mass) {
        if (mass < 0.0) {
            this.massTons = 0.0;
        } else {
            this.massTons = mass;
        }
    }

    public void setRemainingFuel(double fuel) {
        if (fuel < 0.0) {
            this.remainingFuel = 0.0;
        } else if (fuel > 100.0) {
            this.remainingFuel = 100.0;
        } else {
            this.remainingFuel = fuel;
        }
    }

    public void setTopSpeed(double speed) {
        if (speed < 0.0) {
            this.topSpeed = 0.0;
        } else {
            this.topSpeed = speed;
        }
    }

    // Методы базового класса
    public void refuel(double amount) {
        this.setRemainingFuel(this.remainingFuel + amount);
    }

    public void consumeFuel(double amount) {
        this.setRemainingFuel(this.remainingFuel - amount);
    }

    // Метод, который будет переопределён в дочерних классах
    public void move(double distance) {
        double fuelConsumption = distance * 0.1;
        this.consumeFuel(fuelConsumption);
    }

    public void stop() {
        this.topSpeed = 0.0;
    }

    public void accelerate(double increment) {
        this.setTopSpeed(this.topSpeed + increment);
    }

    public void decelerate(double decrement) {
        this.setTopSpeed(this.topSpeed - decrement);
    }
}

