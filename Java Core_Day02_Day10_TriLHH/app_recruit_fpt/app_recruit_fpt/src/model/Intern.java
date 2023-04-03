package model;

public class Intern extends Candidate {
    private String majors;
    private int semester;

    private String universityName;

    public Intern() {
    }


    public Intern(String majors, int semester, String universityName) {
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public Intern(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType, String majors, int semester, String universityName) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String showMe() {
        return super.showMe() + " -|-- Intern -|-- " +
                "-|-- majors='" + getMajors() + '\'' +
                "-|-- semester=" + getSemester() +
                "-|-- universityName='" + getUniversityName() + '\'' +
                '|' + "\n"
                + "_____________________________________________________________________________________________________________________________";
    }
}
