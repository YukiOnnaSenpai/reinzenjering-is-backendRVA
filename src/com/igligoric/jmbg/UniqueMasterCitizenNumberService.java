package com.igligoric.jmbg;

import static com.igligoric.jmbg.StringParser.multiline;

public class UniqueMasterCitizenNumberService {

    private final UniqueMasterCitizenNumberValidator uniqueMasterCitizenNumberValidator;

    public UniqueMasterCitizenNumberService(UniqueMasterCitizenNumberValidator uniqueMasterCitizenNumberValidator) {
        this.uniqueMasterCitizenNumberValidator = uniqueMasterCitizenNumberValidator;
    }

    public String returnUMCNDetails(String jmbg) {
        try {
            return multiline(uniqueMasterCitizenNumberValidator.validate(jmbg));
        }
        catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}
