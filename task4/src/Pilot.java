// Класс пилота с инкапсуляцией
class Pilot extends CrewMember {
    // Инкапсуляция: поля приватные
    private String specialization;
    private boolean certifiedForWarp;
    private int completedMissions;
    private double stressLevel; // 0..1

    // Конструктор с параметрами
    Pilot(String name, int exp, String spec, boolean warp) {
        super(name, exp, "Пилот");
        this.specialization = spec;
        this.certifiedForWarp = warp;
        this.completedMissions = 0;
        this.stressLevel = 0.0;
    }

    // Геттеры
    public String getSpecialization() {
        return this.specialization;
    }

    public boolean isCertifiedForWarp() {
        return this.certifiedForWarp;
    }

    public int getCompletedMissions() {
        return this.completedMissions;
    }

    public double getStressLevel() {
        return this.stressLevel;
    }

    // Сеттеры с контролем
    public void setExperienceYears(int exp) {
        if (exp < 0) {
            exp = 0;
        }
        int delta = exp - getExperienceYears();
        if (delta > 0) {
            addExperience(delta);
        }
    }

    public void setSpecialization(String spec) {
        this.specialization = spec;
    }

    public void setStressLevel(double stress) {
        if (stress < 0.0) {
            this.stressLevel = 0.0;
        } else if (stress > 1.0) {
            this.stressLevel = 1.0;
        } else {
            this.stressLevel = stress;
        }
    }

    // Методы
    public void completeMission() {
        this.completedMissions++;
        this.addExperience(1);
        this.increaseStress(0.1);
    }

    public void increaseStress(double amount) {
        this.setStressLevel(this.stressLevel + amount);
    }

    public void rest(double amount) {
        this.setStressLevel(this.stressLevel - amount);
    }

    public void certifyForWarp() {
        this.certifiedForWarp = true;
    }

    public void gainExperience(int years) {
        if (years > 0) {
            this.addExperience(years);
        }
    }

    public void relax() {
        this.rest(0.2);
    }

    @Override
    public void performDuty() {
        System.out.println("Пилот " + getName() + " ведёт корабль (" + specialization + ")");
    }
}

