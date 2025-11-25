import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Expedition {
    private final Mission mission;
    private final Spaceship flagship;
    private final List<CrewMember> crew = new ArrayList<>();

    Expedition(Mission mission, Spaceship flagship) {
        this.mission = mission;
        this.flagship = flagship;
    }

    public void addCrewMember(CrewMember member) {
        crew.add(member);
    }

    public List<CrewMember> getCrew() {
        return Collections.unmodifiableList(crew);
    }

    public Spaceship getFlagship() {
        return flagship;
    }

    public Mission getMission() {
        return mission;
    }

    public void printManifest() {
        System.out.println("=== Манифест экспедиции " + mission.getCodeName() + " ===");
        System.out.println("Флагман: " + flagship.getCallsign() + " (" + flagship.getHullType() + ")");
        System.out.println("Цель: " + mission.getTargetSystem());
        System.out.println("Экипаж (" + crew.size() + "):");
        for (CrewMember member : crew) {
            System.out.println(" • " + member.describe());
        }
    }

    public void launch() {
        System.out.println(">>> Экспедиция " + mission.getCodeName() + " стартует");
        mission.start();
        flagship.fly(15.0);
        crew.forEach(CrewMember::performDuty);
    }
}

