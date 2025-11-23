public class Main {

    public static void main(String[] args) {
        demonstrateEncapsulation();
        demonstrateInheritance();
        demonstrateMethodOverride();
    }

    private static void demonstrateEncapsulation() {
        System.out.println("=== 1. Инкапсуляция ===");
        System.out.println("Поля классов теперь приватные, доступ через геттеры/сеттеры\n");
        
        Pilot pilot = new Pilot("Элли Рю", 12, "гравитационные манёвры", true);
        pilot.setStressLevel(0.28);
        
        // Используем геттеры для доступа к приватным полям
        System.out.println("Пилот: " + pilot.getName());
        System.out.println("Опыт: " + pilot.getExperienceYears() + " лет");
        System.out.println("Стресс: " + pilot.getStressLevel());
        
        // Используем сеттеры с контролем
        System.out.println("\nПопытка установить стресс > 1.0:");
        pilot.setStressLevel(1.5);
        System.out.println("Фактический стресс (ограничен до 1.0): " + pilot.getStressLevel());
        
        System.out.println("\nПопытка установить отрицательный стресс:");
        pilot.setStressLevel(-0.5);
        System.out.println("Фактический стресс (ограничен до 0.0): " + pilot.getStressLevel());
    }

    private static void demonstrateInheritance() {
        System.out.println("\n=== 2. Наследование ===");
        System.out.println("ExplorerShip и CourierShip наследуются от Spaceship, который наследуется от Vehicle\n");
        
        // Создаём объекты дочерних классов
        ExplorerShip explorer = new ExplorerShip("Asteria", 4200, 78.5, 32, 0.18, 5);
        CourierShip courier = new CourierShip("Draco", 950, 55.0, 12, 0.32, 150);
        
        System.out.println("Исследовательский корабль:");
        System.out.println("  Позывной: " + explorer.getCallsign());
        System.out.println("  Тип корпуса: " + explorer.getHullType());
        System.out.println("  Масса: " + explorer.getMassTons() + " т");
        System.out.println("  Топливо: " + explorer.getRemainingFuel() + "%");
        System.out.println("  Исследовательских модулей: " + explorer.getResearchModules());
        
        System.out.println("\nКурьерский корабль:");
        System.out.println("  Позывной: " + courier.getCallsign());
        System.out.println("  Тип корпуса: " + courier.getHullType());
        System.out.println("  Масса: " + courier.getMassTons() + " т");
        System.out.println("  Топливо: " + courier.getRemainingFuel() + "%");
        System.out.println("  Грузоподъёмность: " + courier.getCargoCapacity() + " т");
        
        // Демонстрация наследования методов
        System.out.println("\nОба корабля используют унаследованные методы:");
        explorer.refuel(10.0);
        courier.refuel(10.0);
        System.out.println("После заправки:");
        System.out.println("  " + explorer.getCallsign() + ": " + explorer.getRemainingFuel() + "%");
        System.out.println("  " + courier.getCallsign() + ": " + courier.getRemainingFuel() + "%");
    }

    private static void demonstrateMethodOverride() {
        System.out.println("\n=== 3. Переопределение методов ===");
        System.out.println("Каждый тип корабля переопределяет метод move() по-своему\n");
        
        Vehicle vehicle = new Vehicle("Базовый транспорт", 1000, 50.0, 0.1);
        ExplorerShip explorer = new ExplorerShip("Asteria", 4200, 78.5, 32, 0.18, 5);
        CourierShip courier = new CourierShip("Draco", 950, 55.0, 12, 0.32, 150);
        
        System.out.println("Базовое транспортное средство:");
        System.out.println("  Топливо до движения: " + vehicle.getRemainingFuel() + "%");
        vehicle.move(10.0);
        System.out.println("  Топливо после движения: " + vehicle.getRemainingFuel() + "%");
        
        System.out.println("\nИсследовательский корабль (переопределённый move):");
        System.out.println("  Топливо до движения: " + explorer.getRemainingFuel() + "%");
        explorer.move(10.0);
        System.out.println("  Топливо после движения: " + explorer.getRemainingFuel() + "%");
        
        System.out.println("\nКурьерский корабль (переопределённый move):");
        System.out.println("  Топливо до движения: " + courier.getRemainingFuel() + "%");
        System.out.println("  Скорость до движения: " + courier.getTopSpeed());
        courier.move(10.0);
        System.out.println("  Топливо после движения: " + courier.getRemainingFuel() + "%");
        System.out.println("  Скорость после движения: " + courier.getTopSpeed());
        
        System.out.println("\nСпецифичные методы дочерних классов:");
        explorer.conductResearch();
        courier.deliverCargo();
    }
}

