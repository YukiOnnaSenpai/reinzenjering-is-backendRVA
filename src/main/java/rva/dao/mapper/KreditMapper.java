package rva.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import rva.dao.KreditDao;
import rva.jpa.Kredit;

@Component
@AllArgsConstructor
public class KreditMapper {

	public Kredit daoToEntity(KreditDao dao) {
		Kredit entity = new Kredit();
		entity.setId(dao.getId());
		entity.setNazivKredita(dao.getNaziv());
		entity.setOpisKredita(dao.getOpis());
		entity.setOznakaKredita(dao.getOznaka());
		return entity;
	}

	public KreditDao entityToDao(Kredit entity) {
		KreditDao dao = new KreditDao();
		dao.setId(entity.getId());
		dao.setNaziv(entity.getNazivKredita());
		dao.setOpis(entity.getOpisKredita());
		dao.setOznaka(entity.getOznakaKredita());
		return dao;
	}

	public List<Kredit> daoListToEntityList(List<KreditDao> daos) {
		List<Kredit> entities = new ArrayList<>();
		for (KreditDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}

	public List<KreditDao> entityListToDaoList(List<Kredit> entities) {
		List<KreditDao> daos = new ArrayList<>();
		for (Kredit entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}
}
