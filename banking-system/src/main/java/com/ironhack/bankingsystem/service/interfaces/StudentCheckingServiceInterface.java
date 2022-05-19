package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.models.StudentChecking;
import jakarta.validation.Valid;

public interface StudentCheckingServiceInterface {
    StudentChecking getStudentChecking(Long id);
    public StudentChecking saveStudentChecking(StudentChecking studentChecking);

    void updateStudentChecking(Long id, StudentChecking studentChecking);
    void deleteStudentChecking(Long id);
}
