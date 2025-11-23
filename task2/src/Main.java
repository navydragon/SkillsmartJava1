public class Main {

    public static void main(String[] args) {
        demonstrateSpaceship();
        demonstratePilot();
        demonstrateMission();
        demonstrateMethodCombination();
    }

    private static void demonstrateSpaceship() {
        System.out.println("=== Корабли экспедиции ===");
        
        Spaceship explorer = new Spaceship("Asteria", "Исследовательский крейсер", 4200, 78.5, 32, 0.18);
        printSpaceship(explorer);
        
        System.out.println("\nКорабль заправляется (+20%):");
        explorer.refuel(20.0);
        printSpaceship(explorer);
        
        System.out.println("\nКорабль летит (расходует топливо):");
        explorer.fly(50.0);
        printSpaceship(explorer);
        
        System.out.println("\nКорабль ускоряется:");
        explorer.accelerate(0.05);
        printSpaceship(explorer);
        
        System.out.println("\nКорабль останавливается:");
        explorer.stop();
        printSpaceship(explorer);
        
        Spaceship courier = new Spaceship("Draco", "Лёгкий курьер", 950, 55.0, 12, 0.32);
        System.out.println("\n" + courier.callsign + " создан:");
        printSpaceship(courier);
    }

    private static void demonstratePilot() {
        System.out.println("\n=== Пилоты ===");
        
        Pilot leadPilot = new Pilot("Элли Рю", 12, "гравитационные манёвры", true);
        leadPilot.completedMissions = 18;
        leadPilot.stressLevel = 0.28;
        printPilot(leadPilot);
        
        System.out.println("\nПилот завершает миссию:");
        leadPilot.completeMission();
        printPilot(leadPilot);
        
        System.out.println("\nПилот отдыхает:");
        leadPilot.relax();
        printPilot(leadPilot);
        
        Pilot rookiePilot = new Pilot("Ильдар Вега", 3, "навигация по туманностям", false);
        rookiePilot.completedMissions = 4;
        rookiePilot.stressLevel = 0.46;
        System.out.println("\n" + rookiePilot.name + " создан:");
        printPilot(rookiePilot);
        
        System.out.println("\nПилот получает варп-сертификацию:");
        rookiePilot.certifyForWarp();
        printPilot(rookiePilot);
    }

    private static void demonstrateMission() {
        System.out.println("\n=== Миссии ===");
        
        Mission deepSurvey = new Mission("Atlas-7", "Kepler-442", 210, 820, 4);
        printMission(deepSurvey);
        
        System.out.println("\nМиссия начинается:");
        deepSurvey.start();
        printMission(deepSurvey);
        
        System.out.println("\nБюджет миссии увеличивается (+100 млн):");
        deepSurvey.increaseBudget(100.0);
        printMission(deepSurvey);
        
        System.out.println("\nРиск миссии увеличивается:");
        deepSurvey.increaseRisk(2);
        printMission(deepSurvey);
        
        System.out.println("\nМиссия завершается:");
        deepSurvey.complete();
        printMission(deepSurvey);
        
        Mission rescueRun = new Mission("Echo-13", "TRAPPIST-1", 95, 260, 6);
        System.out.println("\n" + rescueRun.codeName + " создана:");
        printMission(rescueRun);
        
        System.out.println("\nМиссия продлевается (+10 дней):");
        rescueRun.extendDuration(10);
        printMission(rescueRun);
    }

    private static void demonstrateMethodCombination() {
        System.out.println("\n=== Комбинирование методов ===");
        
        Spaceship ship = new Spaceship("Hermes", "Транспорт снабжения", 1800, 62.5, 15, 0.22);
        System.out.println("Корабль " + ship.callsign + " перед полётом:");
        printSpaceship(ship);
        
        System.out.println("\nКорабль заправляется и летит (fly вызывает consumeFuel):");
        ship.refuel(10.0);
        ship.fly(30.0);
        printSpaceship(ship);
        
        Pilot pilot = new Pilot("Тестовый пилот", 5, "тестирование", false);
        pilot.stressLevel = 0.5;
        System.out.println("\nПилот " + pilot.name + " перед миссией:");
        printPilot(pilot);
        
        System.out.println("\nПилот завершает миссию (вызывает increaseStress):");
        pilot.completeMission();
        printPilot(pilot);
        
        System.out.println("\nПилот отдыхает (relax вызывает rest):");
        pilot.relax();
        printPilot(pilot);
        
        Mission mission = new Mission("Test-1", "Test System", 100, 500, 5);
        System.out.println("\nМиссия " + mission.codeName + " создана:");
        printMission(mission);
        
        System.out.println("\nМиссия начинается, бюджет увеличивается:");
        mission.start();
        mission.increaseBudget(50.0);
        printMission(mission);
    }

    private static void printSpaceship(Spaceship ship) {
        System.out.printf(
                "Корабль %s | корпус: %s | масса: %.0f т | топливо: %.1f%% | экипаж: %d | c %.2f c%n",
                ship.callsign,
                ship.hullType,
                ship.massTons,
                ship.remainingFuel,
                ship.crewCapacity,
                ship.topSpeed
        );
    }

    private static void printPilot(Pilot pilot) {
        System.out.printf(
                "Пилот %s | опыт: %d лет | специализация: %s | варп-сертификация: %s | миссий: %d | стресс: %.2f%n",
                pilot.name,
                pilot.experienceYears,
                pilot.specialization,
                pilot.certifiedForWarp ? "да" : "нет",
                pilot.completedMissions,
                pilot.stressLevel
        );
    }

    private static void printMission(Mission mission) {
        System.out.printf(
                "Миссия %s | цель: %s | длительность: %d дн | статус: %s | бюджет: %.0f млн | риск: %d%n",
                mission.codeName,
                mission.targetSystem,
                mission.durationDays,
                mission.status,
                mission.budgetMillions,
                mission.riskLevel
        );
    }
}
