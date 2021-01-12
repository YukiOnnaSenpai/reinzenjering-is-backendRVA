package com.igligoric;

import com.igligoric.jmbg.UniqueMasterCitizenNumberService;
import com.igligoric.jmbg.UniqueMasterCitizenNumberValidator;
import com.igligoric.jmbg.RegionRepository;
import com.igligoric.jmbg.Window;

public class Main {

    public static void main(String[] args) {
        var validator = new UniqueMasterCitizenNumberValidator(new RegionRepository());
        var uniqueMasterCitizenNumberService = new UniqueMasterCitizenNumberService(validator);
        var window = new Window();
        window.addFunction(uniqueMasterCitizenNumberService::returnUMCNDetails);
        window.show();
    }
}
