package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.NewThirdPartyDTO;
import com.ironhack.bankingsystem.controllers.impl.ThirdPartyController;
import com.ironhack.bankingsystem.users.ThirdParty;

public interface ThirdPartyServiceInterface {

    ThirdParty getThirdParty(Long id);
    public ThirdParty saveThirdParty(NewThirdPartyDTO newThirdPartyDTO);

    void updateThirdParty(Long id, ThirdParty thirdParty);
    void deleteThirdParty(Long id);
}
