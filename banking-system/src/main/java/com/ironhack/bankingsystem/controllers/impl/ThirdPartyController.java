package com.ironhack.bankingsystem.controllers.impl;
import com.ironhack.bankingsystem.controllers.interfaces.ThirdPartyControllerInterface;
import com.ironhack.bankingsystem.service.interfaces.ThirdPartyServiceInterface;
import com.ironhack.bankingsystem.users.ThirdParty;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/third_party")
public class ThirdPartyController implements ThirdPartyControllerInterface {


    @Autowired
    ThirdPartyServiceInterface thirdPartyServiceInterface;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ThirdParty getThirdParty(@PathVariable Long id){
        return thirdPartyServiceInterface.getThirdParty(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody @Valid ThirdParty thirdParty){
        return thirdPartyServiceInterface.saveThirdParty(thirdParty);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateThirdParty(@PathVariable Long id, @RequestBody ThirdParty thirdParty){
        thirdPartyServiceInterface.updateThirdParty(id, thirdParty);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteThirdParty(Long id) {
        thirdPartyServiceInterface.deleteThirdParty(id);
    }
}
