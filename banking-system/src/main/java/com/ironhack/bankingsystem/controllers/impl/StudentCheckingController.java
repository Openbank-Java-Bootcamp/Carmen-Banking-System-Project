package com.ironhack.bankingsystem.controllers.impl;

import com.ironhack.bankingsystem.controllers.interfaces.AccountHoldersControllerInterface;
import com.ironhack.bankingsystem.controllers.interfaces.StudentCheckingControllerInterface;
import com.ironhack.bankingsystem.models.CheckingAccounts;
import com.ironhack.bankingsystem.models.StudentChecking;
import com.ironhack.bankingsystem.service.interfaces.CheckingAccountsServiceInterface;
import com.ironhack.bankingsystem.service.interfaces.StudentCheckingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/studentchecking")
public class StudentCheckingController implements StudentCheckingControllerInterface {
    @Autowired
    StudentCheckingServiceInterface studentCheckingServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentChecking getStudentChecking(@PathVariable Long id){
        return studentCheckingServiceInterface.getStudentChecking(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentChecking createStudentChecking(@RequestBody @Valid StudentChecking studentChecking){
        return studentCheckingServiceInterface.saveStudentChecking(studentChecking);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentChecking(@PathVariable Long id, @RequestBody StudentChecking studentChecking){
        studentCheckingServiceInterface.updateStudentChecking(id, studentChecking);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentChecking(Long id) {
        studentCheckingServiceInterface.deleteStudentChecking(id);
    }

}
