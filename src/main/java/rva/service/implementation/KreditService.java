package rva.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import rva.dao.KreditDao;
import rva.dao.mapper.KreditMapper;
import rva.jpa.Kredit;
import rva.reps.KreditRepository;
import rva.service.BaseService;

@Service
@AllArgsConstructor
public class KreditService implements BaseService<KreditDao> {

	private final KreditMapper mapper;
	private JdbcTemplate jdbcTemplate;
	private final KreditRepository repository;

	@Override
	public void delete(Integer id) {
		Kredit deletable = mapper.daoToEntity(getOneById(id));
		if (repository.existsById(deletable.getId())) {
			repository.deleteById(id);
			if (id == -100)
				jdbcTemplate.execute(
						"INSERT INTO \"kredit\"(\"id\", \"naziv\", \"oznaka\", \"opis\" )VALUES(-100, 'naziv test', 'oznaka test', 'opis test');");
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public List<KreditDao> getAll() {
		return mapper.entityListToDaoList(repository.findAll());
	}

	@Override
	public KreditDao getOneById(Integer id) {
		return mapper.entityToDao(
				repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT)));
	}

	@Override
	public List<KreditDao> getByName(String name) {
		return mapper.entityListToDaoList(new ArrayList<>(repository.findByNazivKreditaContainingIgnoreCase(name)));

	}

	@Override
	public void insert(KreditDao dao) {
		Kredit entity = mapper.daoToEntity(dao);
		repository.save(entity);

	}

	@Override
	public void update(KreditDao dao) {
		Kredit entity = mapper.daoToEntity(dao);
		if (repository.existsById(entity.getId())) {
			repository.save(entity);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
