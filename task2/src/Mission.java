class Mission {
    String codeName;
    String targetSystem;
    int durationDays;
    String status;
    double budgetMillions;
    int riskLevel; // 1..10

    // Конструктор с параметрами
    Mission(String code, String target, int duration, double budget, int risk) {
        this.codeName = code;
        this.targetSystem = target;
        this.durationDays = duration;
        this.status = "подготовка";
        this.budgetMillions = budget;
        this.riskLevel = risk;
    }

    // Начать миссию
    void start() {
        this.status = "исполнение";
    }

    // Завершить миссию
    void complete() {
        this.status = "завершена";
    }

    // Отменить миссию
    void cancel() {
        this.status = "отменена";
    }

    // Увеличить бюджет
    void increaseBudget(double amount) {
        this.budgetMillions += amount;
    }

    // Уменьшить бюджет
    void decreaseBudget(double amount) {
        this.budgetMillions -= amount;
        if (this.budgetMillions < 0.0) {
            this.budgetMillions = 0.0;
        }
    }

    // Увеличить риск
    void increaseRisk(int level) {
        this.riskLevel += level;
        if (this.riskLevel > 10) {
            this.riskLevel = 10; // максимум 10
        }
    }

    // Снизить риск
    void decreaseRisk(int level) {
        this.riskLevel -= level;
        if (this.riskLevel < 1) {
            this.riskLevel = 1; // минимум 1
        }
    }

    // Продлить миссию
    void extendDuration(int days) {
        this.durationDays += days;
    }

    // Установить статус
    void setStatus(String newStatus) {
        this.status = newStatus;
    }
}

