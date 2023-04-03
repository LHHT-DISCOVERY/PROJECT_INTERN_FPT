package fa.training.entities;

public class Experience extends Candidate{
    private int yearExperience;
    private String professionalSkill;

    public Experience() {
    }

    public Experience(int yearExperience, String professionalSkill) {
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    public Experience(String id, String firstName, String lastName, String birthday, String address, String phone, String email, int yearExperience, String professionalSkill) {
        super(id, firstName, lastName, birthday, address, phone, email);
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " , Experience{" +
                "yearExperience=" + yearExperience +
                ", professionalSkill='" + professionalSkill + '\'' +
                '}';
    }
    public String getStringToWrite() {
        return super.getStringToWrite() + "," +this.yearExperience + ","+this.professionalSkill;
    }

}
