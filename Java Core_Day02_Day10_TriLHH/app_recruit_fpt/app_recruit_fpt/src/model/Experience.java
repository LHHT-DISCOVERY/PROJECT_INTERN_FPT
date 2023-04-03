package model;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType, int expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String showMe() {
        return super.showMe() + " -|-- Experience{" +
                " -|-- expInYear=" + getExpInYear() +
                " -|-- proSkill='" + getProSkill() + '\'' +
                '|' +"\n"
                + "_____________________________________________________________________________________________________________________________";
    }
}
