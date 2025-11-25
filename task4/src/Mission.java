// Класс миссии с инкапсуляцией
class Mission {
    // Инкапсуляция: поля приватные
    private String codeName;
    private String targetSystem;
    private int durationDays;
    private String status;
    private double budgetMillions;
    private int riskLevel; // 1..10

    // Конструктор с параметрами
    Mission(String code, String target, int duration, double budget, int risk) {
        this.codeName = code;
        this.targetSystem = target;
        this.durationDays = duration;
        this.status = "подготовка";
        this.budgetMillions = budget;
        this.setRiskLevel(risk); // используем сеттер для контроля
    }

    // Геттеры
    public String getCodeName() {
        return this.codeName;
    }

    public String getTargetSystem() {
        return this.targetSystem;
    }

    public int getDurationDays() {
        return this.durationDays;
    }

    public String getStatus() {
        return this.status;
    }

    public double getBudgetMillions() {
        return this.budgetMillions;
    }

    public int getRiskLevel() {
        return this.riskLevel;
    }

    // Сеттеры с контролем
    public void setCodeName(String code) {
        this.codeName = code;
    }

    public void setTargetSystem(String target) {
        this.targetSystem = target;
    }

    public void setDurationDays(int duration) {
        if (duration < 0) {
            this.durationDays = 0;
        } else {
            this.durationDays = duration;
        }
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setBudgetMillions(double budget) {
        if (budget < 0.0) {
            this.budgetMillions = 0.0;
        } else {
            this.budgetMillions = budget;
        }
    }

    public void setRiskLevel(int risk) {
        if (risk < 1) {
            this.riskLevel = 1;
        } else if (risk > 10) {
            this.riskLevel = 10;
        } else {
            this.riskLevel = risk;
        }
    }

    // Методы
    public void start() {
        this.status = "исполнение";
    }

    public void complete() {
        this.status = "завершена";
    }

    public void cancel() {
        this.status = "отменена";
    }

    public void increaseBudget(double amount) {
        this.setBudgetMillions(this.budgetMillions + amount);
    }

    public void decreaseBudget(double amount) {
        this.setBudgetMillions(this.budgetMillions - amount);
    }

    public void increaseRisk(int level) {
        this.setRiskLevel(this.riskLevel + level);
    }

    public void decreaseRisk(int level) {
        this.setRiskLevel(this.riskLevel - level);
    }

    public void extendDuration(int days) {
        this.setDurationDays(this.durationDays + days);
    }
}

