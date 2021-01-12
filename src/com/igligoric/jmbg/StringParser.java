package com.igligoric.jmbg;

class StringParser {

    static String multiline(UniqueMasterCitizenNumberDetails umcnDetails) {
        return new StringBuilder().append("<html>")
                .append("JMBG detalji: ")
                .append("<br/>")
                .append("Datum rodjenja : ")
                .append(umcnDetails.getDateOfBirth())
                .append("<br/>")
                .append("Region: ")
                .append(umcnDetails.getRegion().getRegionName())
                .append(", ")
                .append(umcnDetails.getRegion().getPoliticalRegion().getName())
                .append("<br/>")
                .append("Pol: ")
                .append(umcnDetails.getGender())
                .append("<br/>")
                .append("Kontrolni broj: ")
                .append(umcnDetails.getCheckSum())
                .append("</html>")
                .toString();
    }

}
