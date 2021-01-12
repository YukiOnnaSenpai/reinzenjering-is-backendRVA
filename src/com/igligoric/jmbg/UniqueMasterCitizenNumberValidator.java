package com.igligoric.jmbg;

import java.math.BigInteger;
import java.time.LocalDate;

import static java.lang.String.format;

public class UniqueMasterCitizenNumberValidator {

    private final RegionRepository regionRepository;

    public UniqueMasterCitizenNumberValidator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    UniqueMasterCitizenNumberDetails validate(String uniqueMasterCitizenNumber) {
        validateNumeral(uniqueMasterCitizenNumber);
        validateLength(uniqueMasterCitizenNumber);
        LocalDate dateOfBirth = getDate(uniqueMasterCitizenNumber.substring(0, 7));
        Region region = getRegion(uniqueMasterCitizenNumber.substring(7, 9));
        String gender = getGender(uniqueMasterCitizenNumber.substring(9,12));
        String checkSum = getCheckSum(uniqueMasterCitizenNumber);

        return new UniqueMasterCitizenNumberDetails.UniqueMasterCitizenNumberDetailsBuilder()
                .withDateOfBirth(dateOfBirth)
                .withRegion(region)
                .withGender(gender)
                .withCheckSum(checkSum)
                .build();
    }

    private BigInteger validateNumeral(String uniqueMasterCitizenNumber) {
        try {
            return new BigInteger(uniqueMasterCitizenNumber);
        }
        catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Uneti maticni broj mora sadrzati samo cifre");
        }
    }

    private void validateLength(String uniqueMasterCitizenNumber) throws IllegalArgumentException {
        if (uniqueMasterCitizenNumber.length() != 13) {
            throw new IllegalArgumentException("Maticni broj mora da sadrzi 13 cifara");
        }
    }

    private LocalDate getDate(String uniqueMasterCitizenNumberDate) throws IllegalArgumentException {
        int day = Integer.parseInt(uniqueMasterCitizenNumberDate.substring(0, 2));
        int month = Integer.parseInt(uniqueMasterCitizenNumberDate.substring(2, 4));
        int year = uniqueMasterCitizenNumberDate.charAt(4) != '9'? Integer.parseInt("2" + uniqueMasterCitizenNumberDate.substring(4, 7)) : Integer.parseInt("1" + uniqueMasterCitizenNumberDate.substring(4, 7));
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(format("Datum nije validan: %tD", dateOfBirth));
        }
        return dateOfBirth;
    }

    private String getGender(String uniqueNumber) {
        if (Integer.parseInt(uniqueNumber) < 500) {
            return "MUSKI";
        }
        return "ZENSKI";
    }

    private Region getRegion(String regionNumber) {
        return regionRepository.findByRegionIdentifier(regionNumber)
                .orElseThrow(() -> new IllegalArgumentException(format("Region sa datom oznakom ne postoji: %s", regionNumber)));
    }

    private String getCheckSum(String uniqueMasterCitizenNumber) {
        String withoutCheckSum = uniqueMasterCitizenNumber.substring(0, uniqueMasterCitizenNumber.length() -1);
        int index = 6;
        double value = 0;
        for (int i = 0; i < index; i++) {
            value += (index + 1 - i) * (Character.getNumericValue(withoutCheckSum.charAt(i))  + Character.getNumericValue(withoutCheckSum.charAt(i + index)));
        }
        return String.valueOf((int)(11 - value % 11));
    }
}
