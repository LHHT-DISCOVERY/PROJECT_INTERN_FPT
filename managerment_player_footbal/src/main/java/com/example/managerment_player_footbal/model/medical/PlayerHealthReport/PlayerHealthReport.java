package com.example.managerment_player_footbal.model.medical.PlayerHealthReport;

import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.medical.Doctor.Doctor;
import com.example.managerment_player_footbal.util.Utils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player_health_report")
public class PlayerHealthReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @DecimalMin(value="30.0",message="Vui lòng nhập đúng cân nặng!")
    @DecimalMax(value="240.0",message="Vui lòng nhập đúng cân nặng!")
    private float weight;

    @DecimalMin(value="60.0",message="Vui lòng nhập đúng chiều cao!")
    @DecimalMax(value="240.0",message="Vui lòng nhập đúng chiều cao!")
    private float height;

    @Min(value=70,message="Vui lòng nhập đúng Cholesterol!")
    @Max(value=240,message="Vui lòng nhập đúng Cholesterol!")
    private int cholesterol;

    @Min(value=70,message="Vui lòng nhập đúng nhịp tim!")
    @Max(value=240,message="Vui lòng nhập đúng nhịp tim!")
    private int heartRate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inspectDate;

    public String getBmi() {
        String bmi = Utils.df.format(getWeight() / ((getHeight()/100) * (getHeight()/100)));
        return bmi;
    }

    public String getBmiStatus() {
        String status="";
        float bmi=Float.parseFloat(getBmi());
        if(bmi<18.5)
            status = "Thiếu cân";
        else if(bmi>=18.5 && bmi<25 )
            status = "Khỏe mạnh";
        else if(bmi>= 25 && bmi<30 )
            status = "Thừa cân";
        else if(bmi>=30 )
            status = "Béo phì";
        return status ;
    }

    public String getHeartRateStatus(){
        int age = inspectDate.getYear()- player.getBirthday().toLocalDate().getYear();
        int updatedHeartRate = 220-age;
        int fiftyPercentMaximumHeartRate = (int) (updatedHeartRate*0.5);
        int eightyFivePercentMaximumHeartRate = (int) (updatedHeartRate*0.85);
        String str =inspectDate.getYear()+"/"+player.getBirthday().toLocalDate().getYear();
        if(heartRate>eightyFivePercentMaximumHeartRate)
            return "Cao";
        else if(heartRate<fiftyPercentMaximumHeartRate)
            return "Thấp";
        else return "Bình thường";
    }

    public String getCholesterolStatus(){
        if(cholesterol<=170 && cholesterol>130)
            return "Bình thường";
        if(cholesterol<=130)
            return "Thấp";
        return "Cao";
    }

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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public LocalDate getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(LocalDate inspectDate) {
        this.inspectDate = inspectDate;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return "PlayerHealthReport [reportId=" + reportId + ", player=" + player + ", doctor=" + doctor + ", weight="
                + weight + ", height=" + height + ", cholesterol=" + cholesterol + ", heartRate=" + heartRate
                + ", inspectDate=" + inspectDate + "]";
    }
}