package rva.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import rva.dao.KlijentDao;
import rva.dao.mapper.KlijentMapper;
import rva.jpa.Klijent;
import rva.reps.KlijentRepository;
import rva.service.BaseService;

@Service
@AllArgsConstructor
public class KlijentService implements BaseService<KlijentDao> {

	private JdbcTemplate jdbcTemplate;
	private final KlijentMapper mapper;
	private final KlijentRepository repository;

	@Override
	public void delete(Integer id) {
		Klijent deletable = mapper.daoToEntity(getOneById(id));
		if (repository.existsById(deletable.getId())) {
			repository.deleteById(id);
			if (id == -100)
				jdbcTemplate.execute(
						"INSERT INTO \"klijent\"(\"id\", \"naziv\", \"oznaka\", \"opis\" )VALUES(-100, 'naziv test', 'oznaka test', 'opis test');");

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public List<KlijentDao> getAll() {
		return mapper.entityListToDaoList(repository.findAll());
	}

	@Override
	public KlijentDao getOneById(Integer id) {
		return mapper.entityToDao(
				repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
	}

	@Override
	public List<KlijentDao> getByName(String name) {
		return mapper.entityListToDaoList(new ArrayList<>(repository.findByImeContainingIgnoreCase(name)));

	}

	@Override
	public void insert(KlijentDao dao) {
		Klijent entity = mapper.daoToEntity(dao);
		repository.save(entity);

	}

	@Override
	public void update(KlijentDao dao) {
		Klijent entity = mapper.daoToEntity(dao);
		if (repository.existsById(entity.getId())) {
			repository.save(entity);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
