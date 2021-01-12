package rva.ctrls;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import rva.dao.KlijentDao;
import rva.service.implementation.KlijentService;

@RestController
@AllArgsConstructor
@Api(tags = { "Klijent CRUD operacije" })
public class KlijentRestController {

	private final KlijentService service;

	@GetMapping("klijent")
	@ApiOperation(value = "Vraća kolekciju svih klijenata iz baze podataka")
	public Collection<KlijentDao> getKlijenti() {
		return service.getAll();
	}

	@GetMapping("klijentId/{id}")
	@ApiOperation(value = "Vraća kolekciju svih klijenata iz baze podataka koji imaju isti id prosleđen kao path varijabla")
	public KlijentDao getKlijent(@PathVariable("id") Integer id) {
		return service.getOneById(id);
	}

	@GetMapping("klijentIme/{ime}")
	@ApiOperation(value = "Vraća kolekciju svih klijenata iz baze podataka koji u imenu sadrže string prosleđen kao path varijabla")
	public Collection<KlijentDao> getKlijentByNaziv(@PathVariable("ime") String ime) {
		return service.getByName(ime);
	}

	@DeleteMapping("klijent/{id}")
	@CrossOrigin
	@Transactional
	@ApiOperation(value = "Briše klijenta iz baze podataka čija je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<KlijentDao> deleteKlijent(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("klijent")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novog klijenta u bazu podataka")
	public ResponseEntity<KlijentDao> insertKlijent(@RequestBody KlijentDao klijent) {
		service.insert(klijent);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("klijent")
	@CrossOrigin
	@ApiOperation(value = "Menja postojećeg klijenta unetog u bazi podataka")
	public ResponseEntity<KlijentDao> updateKlijent(@RequestBody KlijentDao klijent) {
		service.update(klijent);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
