public class Main {

    public static void main(String[] args) {
        createObjectsDemo();
        demonstrateReferenceEffect();
    }

    private static void createObjectsDemo() {
        System.out.println("=== Корабли экспедиции ===");
        Spaceship explorer = new Spaceship();
        explorer.callsign = "Asteria";
        explorer.hullType = "Исследовательский крейсер";
        explorer.massTons = 4200;
        explorer.remainingFuel = 78.5;
        explorer.crewCapacity = 32;
        explorer.topSpeed = 0.18;

        Spaceship courier = new Spaceship();
        courier.callsign = "Draco";
        courier.hullType = "Лёгкий курьер";
        courier.massTons = 950;
        courier.remainingFuel = 55.0;
        courier.crewCapacity = 12;
        courier.topSpeed = 0.32;

        printSpaceship(explorer);
        printSpaceship(courier);

        System.out.println("\n=== Пилоты ===");
        Pilot leadPilot = new Pilot();
        leadPilot.name = "Элли Рю";
        leadPilot.experienceYears = 12;
        leadPilot.specialization = "гравитационные манёвры";
        leadPilot.certifiedForWarp = true;
        leadPilot.completedMissions = 18;
        leadPilot.stressLevel = 0.28;

        Pilot rookiePilot = new Pilot();
        rookiePilot.name = "Ильдар Вега";
        rookiePilot.experienceYears = 3;
        rookiePilot.specialization = "навигация по туманностям";
        rookiePilot.certifiedForWarp = false;
        rookiePilot.completedMissions = 4;
        rookiePilot.stressLevel = 0.46;

        printPilot(leadPilot);
        printPilot(rookiePilot);

        System.out.println("\n=== Миссии ===");
        Mission deepSurvey = new Mission();
        deepSurvey.codeName = "Atlas-7";
        deepSurvey.targetSystem = "Kepler-442";
        deepSurvey.durationDays = 210;
        deepSurvey.status = "подготовка";
        deepSurvey.budgetMillions = 820;
        deepSurvey.riskLevel = 4;

        Mission rescueRun = new Mission();
        rescueRun.codeName = "Echo-13";
        rescueRun.targetSystem = "TRAPPIST-1";
        rescueRun.durationDays = 95;
        rescueRun.status = "исполнение";
        rescueRun.budgetMillions = 260;
        rescueRun.riskLevel = 6;

        printMission(deepSurvey);
        printMission(rescueRun);
    }

    private static void demonstrateReferenceEffect() {
        System.out.println("\n=== Передача по ссылке ===");
        Spaceship primaryShip = new Spaceship();
        primaryShip.callsign = "Hermes";
        primaryShip.hullType = "Транспорт снабжения";
        primaryShip.remainingFuel = 62.5;
        primaryShip.massTons = 1800;
        primaryShip.crewCapacity = 15;
        primaryShip.topSpeed = 0.22;

        Spaceship aliasShip = primaryShip; // обе переменные указывают на один объект
        aliasShip.remainingFuel = 10.0;    // изменение через aliasShip

        System.out.println("primaryShip.remainingFuel = " + primaryShip.remainingFuel);
        System.out.println("aliasShip.remainingFuel    = " + aliasShip.remainingFuel);
        System.out.println("Изменение остатка топлива через aliasShip затронуло primaryShip,");
        System.out.println("потому что обе переменные держат ссылку на один и тот же объект.");
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

class Spaceship {
    String callsign;
    String hullType;
    double massTons;
    double remainingFuel;
    int crewCapacity;
    double topSpeed; // доля скорости света
}

class Pilot {
    String name;
    int experienceYears;
    String specialization;
    boolean certifiedForWarp;
    int completedMissions;
    double stressLevel; // 0..1
}

class Mission {
    String codeName;
    String targetSystem;
    int durationDays;
    String status;
    double budgetMillions;
    int riskLevel; // 1..10
}


