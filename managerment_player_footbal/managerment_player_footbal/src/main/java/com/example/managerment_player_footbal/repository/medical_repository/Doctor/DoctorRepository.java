package com.example.managerment_player_footbal.repository.medical_repository.Doctor;

import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.model.medical.Doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query("SELECT d FROM Doctor d")
    List<Doctor> findDoctors();


    Doctor findDoctorByUser(Account account );




    @Query(nativeQuery = true, value = "select * from Doctor where doctor_id = ?")
    Optional<Doctor> findById(int id);
}