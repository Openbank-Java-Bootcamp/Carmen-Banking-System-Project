package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.repositories.ThirdPartyRepository;
import com.ironhack.bankingsystem.service.interfaces.ThirdPartyServiceInterface;
import com.ironhack.bankingsystem.users.ThirdParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ThirdPartyService implements ThirdPartyServiceInterface {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public ThirdParty getThirdParty(Long id){
        return thirdPartyRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Third party not found"));
    }
    public ThirdParty saveThirdParty(ThirdParty thirdParty) {
        /*try {
            return thirdPartyRepository.save(new ThirdParty(
                    thirdParty.getName()
                    *//*thirdParty.getHashedKey()*//*
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No third party found");

        }*/
        return null;
    }

    public void updateThirdParty(Long id, ThirdParty thirdParty){
        ThirdParty thirdPartyFromDb = thirdPartyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The third party is not found in the database"));
        thirdParty.setId((thirdPartyFromDb.getId()));
        thirdPartyRepository.save(thirdParty);
    }
    public void deleteThirdParty(Long id){
        thirdPartyRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Third party not found"));
        thirdPartyRepository.deleteById(id);

    }
}
