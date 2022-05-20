package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.models.StudentChecking;

public interface StudentCheckingControllerInterface {
    StudentChecking getStudentChecking(Long id);
    public StudentChecking createStudentChecking(StudentChecking studentChecking);
    void updateStudentChecking(Long id, StudentChecking studentChecking);
    void deleteStudentChecking(Long id);
}
