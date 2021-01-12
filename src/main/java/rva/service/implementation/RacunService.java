package rva.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import rva.dao.RacunDao;
import rva.dao.mapper.RacunMapper;
import rva.jpa.Racun;
import rva.jpa.TipRacuna;
import rva.reps.RacunRepository;
import rva.reps.TipRacunaRepository;
import rva.service.BaseService;

@Service
@AllArgsConstructor
public class RacunService implements BaseService<RacunDao> {

	private final RacunMapper mapper;
	private JdbcTemplate jdbcTemplate;
	private final RacunRepository repository;
	private final TipRacunaRepository tipRacunaRepository;

	@Override
	public void delete(Integer id) {
		Racun deletable = mapper.daoToEntity(getOneById(id));
		if (repository.existsById(deletable.getId())) {
			repository.deleteById(id);
			if (id == -100)
				jdbcTemplate.execute(
						"INSERT INTO \"racun\"(\"id\", \"naziv\", \"oznaka\", \"opis\" )VALUES(-100, 'naziv test', 'oznaka test', 'opis test');");
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<RacunDao> getAll() {
		return mapper.entityListToDaoList(repository.findAll());
	}

	@Override
	public RacunDao getOneById(Integer id) {
		return mapper.entityToDao(
				repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
	}

	@Override
	public List<RacunDao> getByName(String name) {
		return mapper.entityListToDaoList(new ArrayList<>(repository.findByNazivRacunaContainingIgnoreCase(name)));
	}

	public List<RacunDao> findByRecepitType(Integer id) {
		TipRacuna entity = tipRacunaRepository.getOne(id);
		return mapper.entityListToDaoList(new ArrayList<>(repository.findByTipRacuna(entity)));

	}

	@Override
	public void insert(RacunDao dao) {
		Racun entity = mapper.daoToEntity(dao);
		repository.save(entity);

	}

	@Override
	public void update(RacunDao dao) {
		Racun entity = mapper.daoToEntity(dao);
		if (repository.existsById(entity.getId())) {
			repository.save(entity);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
