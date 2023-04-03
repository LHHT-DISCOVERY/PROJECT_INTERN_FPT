package com.example.managerment_player_footbal.model.medical.MedicalReport;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.medical.Doctor.Doctor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="medical_report")
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull(message = "Triệu chứng không được để trống")
    @NotEmpty(message = "Triệu chứng không được chứa duy nhất các khoảng trống")
    @NotBlank(message = "Triệu chứng không được để trống")
    private String symptom;

    @NotNull(message = "Chuẩn đoán không được để trống")
    @NotEmpty(message = "Chuẩn đoán không được chứa duy nhất các khoảng trống")
    @NotBlank(message = "Chuẩn đoán không được để trống")
    private String diagnosis;

    @NotNull(message = "Nguyên nhân không được để trống")
    @NotEmpty(message = "Nguyên nhân không được chứa duy nhất các khoảng trống")
    @NotBlank(message = "Nguyên nhân không được để trống")
    private String cause;

    @NotNull(message = "Kết quả không được để trống")
    @NotEmpty(message = "Kết quả không được chứa duy nhất các khoảng trống")
    @NotBlank(message = "Kết quả không được để trống")
    private String testResult;

    @NotNull(message = "Trị liệu không được để trống")
    @NotEmpty(message = "Trị liệu không được chứa duy nhất các khoảng trống")
    @NotBlank(message = "Trị liệu không được để trống")
    private String treatment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportDate;

    public long getReportId() {
        return reportId;
    }
    public void setReportId(long reportId) {
        this.reportId = reportId;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getSymptom() {
        return symptom;
    }
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getTestResult() {
        return testResult;
    }
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    public String getTreatment() {
        return treatment;
    }
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    public LocalDate getReportDate() {
        return reportDate;
    }
    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }
    public String getCause() {
        return cause;
    }
    public void setCause(String cause) {
        this.cause = cause;
    }

}
