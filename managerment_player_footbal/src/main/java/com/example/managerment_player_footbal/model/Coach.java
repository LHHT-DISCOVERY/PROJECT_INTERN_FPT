package com.example.managerment_player_footbal.model;


import com.example.managerment_player_footbal.model.account.Account;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private int coachId;

    @NotNull(message = "Giới tính không được để trống")
    private Boolean gender;

    @Column(name = "nameCoach")
    @Pattern(regexp = "^[^0-9]+$", message = "Tên không được chứa số")
    private String nameCoach;
    @NotBlank(message = "avatar không được để trống")
    private String avatar;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Ngày sinh không được để trống")
    private Date birthday;

    @Pattern(regexp = "^(0)+([3-9][0-9]{8})$", message = "Số điện thoại phải đúng định dạng")
    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;

    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email phải đúng định dạng.")
    @NotBlank(message = "Email không được để trống")
    private String email;
    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @OneToMany(mappedBy = "coach")
    @JsonManagedReference
    private Set<Classes> classes;

    @OneToMany(mappedBy = "coach")
    @JsonManagedReference
    private Set<PlayerRating> playerRatingSet;

    @OneToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_name", referencedColumnName = "account_name")
    private Account account;

    public Coach(Boolean gender, String nameCoach, String avatar, Date birthday, String phone, String email, String address, Account account) {
        this.gender = gender;
        this.nameCoach = nameCoach;
        this.avatar = avatar;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
    }

    public Coach() {
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getNameCoach() {
        return nameCoach;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }

    public Set<PlayerRating> getPlayerRatingSet() {
        return playerRatingSet;
    }

    public void setPlayerRatingSet(Set<PlayerRating> playerRatingSet) {
        this.playerRatingSet = playerRatingSet;
    }
}
