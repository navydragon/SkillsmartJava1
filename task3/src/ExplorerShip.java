// Исследовательский корабль - наследник Spaceship
class ExplorerShip extends Spaceship {
    private int researchModules;

    ExplorerShip(String call, double mass, double fuel, int crew, double speed, int modules) {
        super(call, "Исследовательский крейсер", mass, fuel, crew, speed);
        this.researchModules = modules;
    }

    public int getResearchModules() {
        return this.researchModules;
    }

    public void setResearchModules(int modules) {
        if (modules < 0) {
            this.researchModules = 0;
        } else {
            this.researchModules = modules;
        }
    }

    // Переопределение метода move() - исследовательские корабли тратят больше топлива
    @Override
    public void move(double distance) {
        // Исследовательские корабли тратят ещё больше топлива из-за оборудования
        double fuelConsumption = distance * 0.2;
        this.consumeFuel(fuelConsumption);
        System.out.println("Исследовательский корабль " + this.getCallsign() + 
                         " пролетел " + distance + " единиц, используя " + 
                         this.researchModules + " исследовательских модулей");
    }

    // Специфичный метод для исследовательских кораблей
    public void conductResearch() {
        System.out.println("Корабль " + this.getCallsign() + " проводит исследования");
    }
}

