package rva.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import rva.dao.KlijentDao;
import rva.jpa.Klijent;

@Component
@AllArgsConstructor
public class KlijentMapper {

	private final KreditMapper kreditMapper = new KreditMapper();

	public Klijent daoToEntity(KlijentDao dao) {
		Klijent entity = new Klijent();
		entity.setId(dao.getId());
		entity.setBrojLk(dao.getBrojLk());
		entity.setIme(dao.getIme());
		entity.setPrezime(dao.getPrezime());
		entity.setKredit(kreditMapper.daoToEntity(dao.getKreditDao()));
		return entity;
	}

	public KlijentDao entityToDao(Klijent entity) {
		KlijentDao dao = new KlijentDao();
		dao.setId(entity.getId());
		dao.setBrojLk(entity.getBrojLk());
		dao.setIme(entity.getIme());
		dao.setPrezime(null);
		dao.setKreditDao(kreditMapper.entityToDao(entity.getKredit()));
		return dao;
	}

	public List<Klijent> daoListToEntityList(List<KlijentDao> daos) {
		List<Klijent> entities = new ArrayList<>();
		for (KlijentDao dao : daos) {
			entities.add(daoToEntity(dao));
		}
		return entities;
	}

	public List<KlijentDao> entityListToDaoList(List<Klijent> entities) {
		List<KlijentDao> daos = new ArrayList<>();
		for (Klijent entity : entities) {
			daos.add(entityToDao(entity));
		}
		return daos;
	}

}
