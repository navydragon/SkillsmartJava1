import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random(42);

    public static void main(String[] args) {
        demonstrateComposition();
        demonstrateSubtypePolymorphism();
        demonstrateAdHocPolymorphism();
    }

    // 4.1 Композиция между двумя иерархиями (корабли и члены экипажа)
    private static void demonstrateComposition() {
        System.out.println("=== 4.1 Композиция экспедиции ===");

        Mission mission = new Mission("Atlas-9", "Kepler-186f", 180, 620, 4);
        ExplorerShip explorer = new ExplorerShip("Asteria", 4200, 78.5, 32, 0.18, 5);
        Expedition expedition = new Expedition(mission, explorer);

        Pilot leadPilot = new Pilot("Элли Рю", 12, "гравитационные манёвры", true);
        Pilot deputyPilot = new Pilot("Ильдар Вега", 5, "навигация по туманностям", false);
        Engineer chiefEngineer = new Engineer("Мария Квант", 9, 42, true);

        expedition.addCrewMember(leadPilot);
        expedition.addCrewMember(deputyPilot);
        expedition.addCrewMember(chiefEngineer);

        expedition.printManifest();
        expedition.launch();
        System.out.println("Статус миссии после запуска: " + mission.getStatus());
        System.out.println("Оставшееся топливо флагмана: " + explorer.getRemainingFuel() + "%");
    }

    // 4.2 Полиморфизм подтипов + метод foo()
    private static void demonstrateSubtypePolymorphism() {
        System.out.println("\n=== 4.2 Полиморфизм подтипов и foo() ===");
        Spaceship[] fleet = new Spaceship[500];
        int explorers = 0;
        int couriers = 0;

        for (int i = 0; i < fleet.length; i++) {
            if (RANDOM.nextBoolean()) {
                fleet[i] = new ExplorerShip(
                        "EXP-" + i,
                        3500 + RANDOM.nextInt(700),
                        60 + RANDOM.nextDouble() * 30,
                        30,
                        0.15 + RANDOM.nextDouble() * 0.1,
                        3 + RANDOM.nextInt(4)
                );
                explorers++;
            } else {
                fleet[i] = new CourierShip(
                        "CRG-" + i,
                        900 + RANDOM.nextInt(300),
                        55 + RANDOM.nextDouble() * 35,
                        12,
                        0.25 + RANDOM.nextDouble() * 0.1,
                        80 + RANDOM.nextInt(120)
                );
                couriers++;
            }
        }

        for (Spaceship ship : fleet) {
            ship.foo();
        }

        System.out.println("Исследовательских кораблей: " + explorers);
        System.out.println("Курьерских кораблей: " + couriers);
        System.out.println("Вывод чередуется, потому что JVM вызывает переопределённый foo() каждого реального типа.");
    }

    // 4.3 Пример ad hoc (перегрузка методов)
    private static void demonstrateAdHocPolymorphism() {
        System.out.println("\n=== 4.3 Ad hoc полиморфизм (перегрузка) ===");
        ExplorerShip explorer = new ExplorerShip("Aurora", 3600, 70.0, 28, 0.2, 6);
        CourierShip courier = new CourierShip("Swift-7", 980, 65.0, 10, 0.35, 140);
        Mission recon = new Mission("Scout-5", "TRAPPIST-1", 40, 210, 3);
        Pilot pilot = new Pilot("Лина Орти", 8, "ориентирование", true);
        Engineer engineer = new Engineer("Дан Чжао", 6, 25, false);

        logAction(explorer);
        logAction(courier);
        logAction(pilot);
        logAction(engineer);
        logAction(explorer, recon);
    }

    private static void logAction(Spaceship ship) {
        System.out.println("[LOG] Проверка корпуса корабля " + ship.getCallsign() + " (" + ship.getHullType() + ")");
    }

    private static void logAction(CrewMember member) {
        System.out.println("[LOG] Брифинг для участника: " + member.describe());
    }

    private static void logAction(Spaceship ship, Mission mission) {
        System.out.println("[LOG] Корабль " + ship.getCallsign() + " назначен на миссию " + mission.getCodeName());
    }
}

