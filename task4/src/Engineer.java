class Engineer extends CrewMember {
    private int maintainedSystems;
    private boolean roboticsExpert;

    Engineer(String name, int experienceYears, int maintainedSystems, boolean roboticsExpert) {
        super(name, experienceYears, "Инженер");
        this.maintainedSystems = Math.max(0, maintainedSystems);
        this.roboticsExpert = roboticsExpert;
    }

    public int getMaintainedSystems() {
        return maintainedSystems;
    }

    public boolean isRoboticsExpert() {
        return roboticsExpert;
    }

    public void maintainSystem() {
        maintainedSystems++;
    }

    public void toggleRoboticsExpertise() {
        roboticsExpert = !roboticsExpert;
    }

    @Override
    public void performDuty() {
        System.out.println("Инженер " + getName() + " обслуживает системы (" +
                maintainedSystems + " завершено)");
    }
}

