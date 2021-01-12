package rva.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import rva.dao.TipRacunaDao;
import rva.jpa.TipRacuna;

@Component
@AllArgsConstructor
public class TipRacunaMapper {

	public TipRacuna daoToEntity(TipRacunaDao dao) {
		TipRacuna entity = new TipRacuna();
		entity.setId(dao.getId());
		entity.setNaziv(dao.getNaziv());
		entity.setOpis(dao.getOpis());
		entity.setOznaka(dao.getOznaka());
		return entity;
	}

	public TipRacunaDao entityToDao(TipRacuna entity) {
		TipRacunaDao dao = new TipRacunaDao();
		dao.setId(entity.getId());
		dao.setNaziv(entity.getNaziv());
		dao.setOpis(entity.getOpis());
		dao.setOznaka(entity.getOznaka());
		return dao;
	}

	public List<TipRacuna> daoListToEntityList(List<TipRacunaDao> daos) {
		List<TipRacuna> entities = new ArrayList<>();
		for (TipRacunaDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}

	public List<TipRacunaDao> entityListToDaoList(List<TipRacuna> entities) {
		List<TipRacunaDao> daos = new ArrayList<>();
		for (TipRacuna entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}
