package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.controllers.impl.ThirdPartyController;
import com.ironhack.bankingsystem.users.ThirdParty;

public interface ThirdPartyControllerInterface {

    ThirdParty getThirdParty(Long id);
    public ThirdParty createThirdParty(ThirdParty thirdParty);
    void updateThirdParty(Long id, ThirdParty thirdParty);
    void deleteThirdParty(Long id);
}
