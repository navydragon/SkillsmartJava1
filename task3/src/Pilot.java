// Класс пилота с инкапсуляцией
class Pilot {
    // Инкапсуляция: поля приватные
    private String name;
    private int experienceYears;
    private String specialization;
    private boolean certifiedForWarp;
    private int completedMissions;
    private double stressLevel; // 0..1

    // Конструктор с параметрами
    Pilot(String n, int exp, String spec, boolean warp) {
        this.name = n;
        this.experienceYears = exp;
        this.specialization = spec;
        this.certifiedForWarp = warp;
        this.completedMissions = 0;
        this.stressLevel = 0.0;
    }

    // Геттеры
    public String getName() {
        return this.name;
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }

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
    public void setName(String n) {
        this.name = n;
    }

    public void setExperienceYears(int exp) {
        if (exp < 0) {
            this.experienceYears = 0;
        } else {
            this.experienceYears = exp;
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
        this.experienceYears++;
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
        this.setExperienceYears(this.experienceYears + years);
    }

    public void relax() {
        this.rest(0.2);
    }
}

