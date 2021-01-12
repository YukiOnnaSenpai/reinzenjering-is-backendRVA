package rva.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import rva.dao.RacunDao;
import rva.jpa.Racun;

@Component
@AllArgsConstructor
public class RacunMapper {

	private final TipRacunaMapper tipRacunaMapper;
	private final KlijentMapper klijentMapper;

	public Racun daoToEntity(RacunDao dao) {
		Racun entity = new Racun();
		entity.setId(dao.getId());
		entity.setNazivRacuna(dao.getNaziv());
		entity.setOpisRacuna(dao.getOpis());
		entity.setOznakaRacuna(dao.getOznaka());
		entity.setKlijent(klijentMapper.daoToEntity(dao.getKlijentDao()));
		entity.setTipRacuna(tipRacunaMapper.daoToEntity(dao.getTipRacunaDao()));
		return entity;
	}

	public RacunDao entityToDao(Racun entity) {
		RacunDao dao = new RacunDao();
		dao.setId(entity.getId());
		dao.setNaziv(entity.getNazivRacuna());
		dao.setOpis(entity.getOpisRacuna());
		dao.setOznaka(entity.getOznakaRacuna());
		dao.setKlijentDao(klijentMapper.entityToDao(entity.getKlijent()));
		dao.setTipRacunaDao(tipRacunaMapper.entityToDao(entity.getTipRacuna()));
		return dao;
	}

	public List<Racun> daoListToEntityList(List<RacunDao> daos) {
		List<Racun> entities = new ArrayList<>();
		for (RacunDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}

	public List<RacunDao> entityListToDaoList(List<Racun> entities) {
		List<RacunDao> daos = new ArrayList<>();
		for (Racun entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}
