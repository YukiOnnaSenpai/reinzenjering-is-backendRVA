package rva.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import rva.dao.TipRacunaDao;
import rva.dao.mapper.TipRacunaMapper;
import rva.jpa.TipRacuna;
import rva.reps.TipRacunaRepository;
import rva.service.BaseService;

@Service
@AllArgsConstructor
public class TipRacunaService implements BaseService<TipRacunaDao> {

	private final TipRacunaMapper mapper;
	private JdbcTemplate jdbcTemplate;
	private final TipRacunaRepository repository;

	@Override
	public void delete(Integer id) {
		TipRacuna deletable = mapper.daoToEntity(getOneById(id));
		if (repository.existsById(deletable.getId())) {
			repository.deleteById(id);
			if (id == -100)
				jdbcTemplate.execute(
						"INSERT INTO \"tipRacuna\"(\"id\", \"naziv\", \"oznaka\", \"opis\" )VALUES(-100, 'naziv test', 'oznaka test', 'opis test');");
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public List<TipRacunaDao> getAll() {
		return mapper.entityListToDaoList(repository.findAll());
	}

	@Override
	public TipRacunaDao getOneById(Integer id) {
		return mapper.entityToDao(
				repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
	}

	@Override
	public List<TipRacunaDao> getByName(String name) {
		return mapper.entityListToDaoList(new ArrayList<>(repository.findByNazivContainingIgnoreCase(name)));

	}

	@Override
	public void insert(TipRacunaDao dao) {
		TipRacuna entity = mapper.daoToEntity(dao);
		repository.save(entity);

	}

	@Override
	public void update(TipRacunaDao dao) {
		TipRacuna entity = mapper.daoToEntity(dao);
		if (repository.existsById(entity.getId())) {
			repository.save(entity);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
