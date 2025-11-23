class Pilot {
    String name;
    int experienceYears;
    String specialization;
    boolean certifiedForWarp;
    int completedMissions;
    double stressLevel; // 0..1

    // Конструктор с параметрами
    Pilot(String n, int exp, String spec, boolean warp) {
        this.name = n;
        this.experienceYears = exp;
        this.specialization = spec;
        this.certifiedForWarp = warp;
        this.completedMissions = 0;
        this.stressLevel = 0.0;
    }

    // Завершить миссию (увеличивает опыт и стресс)
    void completeMission() {
        this.completedMissions++;
        this.experienceYears++;
        this.increaseStress(0.1);
    }

    // Увеличить стресс
    void increaseStress(double amount) {
        this.stressLevel += amount;
        if (this.stressLevel > 1.0) {
            this.stressLevel = 1.0; // максимум 1.0
        }
    }

    // Снизить стресс (отдых)
    void rest(double amount) {
        this.stressLevel -= amount;
        if (this.stressLevel < 0.0) {
            this.stressLevel = 0.0; // минимум 0.0
        }
    }

    // Получить варп-сертификацию
    void certifyForWarp() {
        this.certifiedForWarp = true;
    }

    // Увеличить опыт
    void gainExperience(int years) {
        this.experienceYears += years;
    }

    // Отдохнуть (комбинирует снижение стресса)
    void relax() {
        this.rest(0.2);
    }
}

