package rva.dao;

import lombok.Data;

@Data
public class RacunDao {

	private Integer id;

	private String naziv;

	private String opis;

	private String oznaka;

	private TipRacunaDao tipRacunaDao;

	private KlijentDao klijentDao;

}
