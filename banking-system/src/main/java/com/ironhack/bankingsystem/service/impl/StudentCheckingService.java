package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.CheckingAccounts;
import com.ironhack.bankingsystem.models.StudentChecking;
import com.ironhack.bankingsystem.repositories.CheckingAccountsRepository;
import com.ironhack.bankingsystem.repositories.StudentCheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.StudentCheckingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentCheckingService implements StudentCheckingServiceInterface {
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public StudentChecking getStudentChecking(Long id){
        return studentCheckingRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "StudentChecking account not found"));
    }
    public StudentChecking saveStudentChecking(StudentChecking studentChecking) {
        try {
            return studentCheckingRepository.save(new StudentChecking(
                    studentChecking.getBalance(),
                    studentChecking.getPrimaryOwner(),
                    studentChecking.getSecondaryOwner(),
                    studentChecking.getPenaltyFee(),
                    studentChecking.getCreationDate(),
                    studentChecking.getStatus(),
                    studentChecking.getSecretKey(),
                    studentChecking.getInterestRate()

            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No student account found");

        }
    }
    public void updateStudentChecking(Long id, StudentChecking studentChecking){
        StudentChecking studentCheckingFromDb = studentCheckingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The student checking account is not found"));
        studentChecking.setId(studentCheckingFromDb.getId());
        studentCheckingRepository.save(studentChecking);
    }
    public void deleteStudentChecking(Long id){
        studentCheckingRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student account not found"));
        studentCheckingRepository.deleteById(id);

    }
}
