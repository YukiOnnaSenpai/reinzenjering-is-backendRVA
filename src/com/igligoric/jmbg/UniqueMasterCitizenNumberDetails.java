package com.igligoric.jmbg;

import java.time.LocalDate;

class UniqueMasterCitizenNumberDetails {

    private LocalDate dateOfBirth;
    private Region region;
    private String gender;
    private String checkSum;

    private UniqueMasterCitizenNumberDetails(LocalDate dateOfBirth, Region region, String gender, String checkSum) {
        this.dateOfBirth = dateOfBirth;
        this.region = region;
        this.gender = gender;
        this.checkSum = checkSum;
    }

    static class UniqueMasterCitizenNumberDetailsBuilder {
        private LocalDate dateOfBirth;
        private Region region;
        private String gender;
        private String checkSum;


        UniqueMasterCitizenNumberDetailsBuilder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        UniqueMasterCitizenNumberDetailsBuilder withRegion(Region region) {
            this.region = region;
            return this;
        }

        UniqueMasterCitizenNumberDetailsBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        UniqueMasterCitizenNumberDetailsBuilder withCheckSum(String checkSum) {
            this.checkSum = checkSum;
            return this;
        }

        UniqueMasterCitizenNumberDetails build() {
            return new UniqueMasterCitizenNumberDetails(dateOfBirth, region, gender, checkSum);
        }
    }

    LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    Region getRegion() {
        return region;
    }

    String getGender() {
        return gender;
    }

    String getCheckSum() {
        return checkSum;
    }
}
