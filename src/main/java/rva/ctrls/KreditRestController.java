package rva.ctrls;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import rva.dao.KreditDao;
import rva.service.implementation.KreditService;

@RestController
@AllArgsConstructor
@Api(tags = { "Kredit CRUD operacije" })
public class KreditRestController {

	private final KreditService service;

	@GetMapping("kredit")
	@ApiOperation(value = "Vraća kolekciju svih kredita iz baze podataka")
	public Collection<KreditDao> getKrediti() {
		return service.getAll();
	}

	@GetMapping("kreditId/{id}")
	@ApiOperation(value = "Vraća kolekciju svih kredita iz baze podataka čija je id vrednost prosleđena kao path variabla")
	public KreditDao getKredit(@PathVariable("id") Integer id) {
		return service.getOneById(id);
	}

	@GetMapping("kreditNaziv/{naziv}")
	@ApiOperation(value = "Vraća kolekciju svih kredita iz baze podataka koji u imenu sadrže string prosleđen kao path varijabla")
	public Collection<KreditDao> getKreditByNaziv(@PathVariable("naziv") String naziv) {
		return service.getByName(naziv);
	}

	@DeleteMapping("kredit/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše kredit iz baze podataka čija je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<KreditDao> deleteKredit(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("kredit")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novi kredit u bazu podataka")
	public ResponseEntity<KreditDao> insertKredit(@RequestBody KreditDao kredit) {
		service.insert(kredit);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("kredit")
	@CrossOrigin
	@ApiOperation(value = "Menja postojeći kredit unet u bazi podataka")
	public ResponseEntity<KreditDao> updateKredit(@RequestBody KreditDao kredit) {
		service.update(kredit);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
