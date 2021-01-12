package rva.dao;

import lombok.Data;

@Data
public class KlijentDao {

	private Integer id;

	private Integer brojLk;

	private String ime;

	private String prezime;

	private KreditDao kreditDao;

}
