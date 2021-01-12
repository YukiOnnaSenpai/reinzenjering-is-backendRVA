package com.igligoric.jmbg;

import java.util.List;
import java.util.Optional;

public class RegionRepository {

    private List<PoliticalRegion> politicalRegions;
    private List<Region> regions;

    public RegionRepository() {
        PoliticalRegion straniRegion = new PoliticalRegion(0, "Stranac");
        PoliticalRegion bih = new PoliticalRegion(1, "Bosna i Hercegovina");
        PoliticalRegion crnaGora = new PoliticalRegion(2, "Crna Gora");
        PoliticalRegion hrvatska = new PoliticalRegion(3, "Hrvatska");
        PoliticalRegion makedonija = new PoliticalRegion(4, "Makedonija");
        PoliticalRegion slovenija = new PoliticalRegion(5, "Slovenija");
        PoliticalRegion centralnaSrbija = new PoliticalRegion(7, "Centralna Srbija");
        PoliticalRegion vojvodina = new PoliticalRegion(8, "Vojvodina");
        PoliticalRegion kosovo = new PoliticalRegion(9, "Kosovo");

        politicalRegions = List.of(straniRegion, bih, crnaGora, hrvatska, makedonija, slovenija, centralnaSrbija, vojvodina, kosovo);
        regions = List.of(new Region(1, "stranci u BiH", straniRegion),
                new Region(2, "stranci u Crnoj Gori", straniRegion),
                new Region(3, "stranci u Hrvatskoj", straniRegion),
                new Region(4, "stranci u Makedoniji", straniRegion),
                new Region(5, "stranci u Sloveniji", straniRegion),
                new Region(6, "stranci u Srbiji", straniRegion),
                new Region(7, "stranci u Vojvodini", straniRegion),
                new Region(8, "stranci na KiM", straniRegion),
                new Region(9, "stranci u BiH", straniRegion),
                new Region(0, "Banja Luka", bih),
                new Region(1, "Bihac", bih),
                new Region(2, "Doboj", bih),
                new Region(3, "Gorazde", bih),
                new Region(4, "Livno", bih),
                new Region(5, "Mostar", bih),
                new Region(6, "Prijedor", bih),
                new Region(7, "Sarajevo", bih),
                new Region(8, "Tuzla", bih),
                new Region(9, "Zenica", bih),
                new Region(0, "Slavonija", hrvatska),
                new Region(1, "Podravina", hrvatska),
                new Region(2, "Medjimurje", hrvatska),
                new Region(3, "Zagreb", hrvatska),
                new Region(4, "Karlovac", hrvatska),
                new Region(5, "Lika", hrvatska),
                new Region(6, "Primorje", hrvatska),
                new Region(7, "Banovina", hrvatska),
                new Region(8, "Dalmacija", hrvatska),
                new Region(9, "ostalo", hrvatska),
                new Region(1, "Bitola", makedonija),
                new Region(2, "Kumanovo", makedonija),
                new Region(3, "Ohrid", makedonija),
                new Region(4, "Prilep", makedonija),
                new Region(5, "Skopje", makedonija),
                new Region(6, "Strumica", makedonija),
                new Region(7, "Tetovo", makedonija),
                new Region(8, "Veles", makedonija),
                new Region(9, "Stip", makedonija),
                new Region(0, "Slovenija", slovenija),
                new Region(1, "Beograd", centralnaSrbija),
                new Region(2, "Sumadija", centralnaSrbija),
                new Region(3, "Nis", centralnaSrbija),
                new Region(4, "Juzna Morava", centralnaSrbija),
                new Region(5, "Zajecar", centralnaSrbija),
                new Region(6, "Podunavlje", centralnaSrbija),
                new Region(7, "Kolubara", centralnaSrbija),
                new Region(8, "Kraljevo", centralnaSrbija),
                new Region(9, "Uzice", centralnaSrbija),
                new Region(0, "Novi Sad", vojvodina),
                new Region(1, "Sombor", vojvodina),
                new Region(2, "Subotica", vojvodina),
                new Region(5, "Zrenjanin", vojvodina),
                new Region(6, "Pancevo", vojvodina),
                new Region(7, "Kikinda", vojvodina),
                new Region(8, "Ruma", vojvodina),
                new Region(9, "Sremska Mitrovica", vojvodina),
                new Region(1, "Pristina", kosovo),
                new Region(2, "Kosovska Mitrovica", kosovo),
                new Region(3, "Pec", kosovo),
                new Region(4, "Djakovica", kosovo),
                new Region(5, "Prizren", kosovo),
                new Region(6, "Kosovsko Pomoravski okrug", kosovo)
                );
    }

    Optional<Region> findByRegionIdentifier(String regionNumber) {
        int politicalRegionIdentifier = Character.getNumericValue(regionNumber.charAt(0));
        int regionIdentifier =  Character.getNumericValue(regionNumber.charAt(1));

        PoliticalRegion politicalRegion = politicalRegions.stream()
                .filter(pr -> politicalRegionIdentifier == pr.getIdentifier())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Region sa zadatim identifikatorom ne postoji"));

        return regions.stream().filter(region -> region.getPoliticalRegion().equals(politicalRegion))
                .filter(region -> region.getRegionNumber() == regionIdentifier).findFirst();
    }
}
