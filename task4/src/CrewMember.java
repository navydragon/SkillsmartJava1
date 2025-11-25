abstract class CrewMember {
    private final String name;
    private int experienceYears;
    private final String role;

    CrewMember(String name, int experienceYears, String role) {
        this.name = name;
        this.experienceYears = Math.max(0, experienceYears);
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getRole() {
        return role;
    }

    public void addExperience(int years) {
        if (years > 0) {
            this.experienceYears += years;
        }
    }

    public String describe() {
        return role + " " + name + " (" + experienceYears + " лет опыта)";
    }

    public abstract void performDuty();
}

