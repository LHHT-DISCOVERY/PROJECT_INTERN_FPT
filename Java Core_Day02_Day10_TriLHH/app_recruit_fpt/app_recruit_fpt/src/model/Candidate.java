package model;

import java.util.Comparator;

public abstract class Candidate {
    public static int candidate_count = 0;
    private int CandidateID;
    private String FullName;
    private String BirthDay;
    private String Phone;
    private String Email;
    private Certificate certificates;

    private int candidateType;

    public Candidate() {
    }

    public Candidate(int candidateID, String fullName, String birthDay, String phone, String email, int candidateType) {
        CandidateID = candidateID;
        FullName = fullName;
        BirthDay = birthDay;
        Phone = phone;
        Email = email;
        this.candidateType = candidateType;
    }

    public int getCandidateID() {
        return CandidateID;
    }

    public void setCandidateID(int candidateID) {
        CandidateID = candidateID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Certificate getCertificates() {
        return certificates;
    }

    public void setCertificates(Certificate certificates) {
        this.certificates = certificates;
    }

    public static int getCandidate_count() {
        return candidate_count;
    }

    public static void setCandidate_count(int candidate_count) {
        Candidate.candidate_count = candidate_count;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    public String showMe() {
        return "Candidate -+-  " +
                " CandidateID : " + getCandidateID() +
                "-|- FullName : " + getFullName() +
                "-|- BirthDay : " + getBirthDay() +
                "-|- Phone : " + getPhone() +
                "-|- Email : " + getEmail() +
                "-|- candidateType = " + getCandidateType();
    }
}
