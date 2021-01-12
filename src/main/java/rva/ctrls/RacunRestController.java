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
import rva.dao.RacunDao;
import rva.service.implementation.RacunService;

@RestController
@AllArgsConstructor
@Api(tags = { "Račun CRUD operacije" })
public class RacunRestController {

	private final RacunService service;

	@GetMapping("racun")
	@ApiOperation(value = "Vraća kolekciju svih računa iz baze podataka")
	public Collection<RacunDao> getRacuni() {
		return service.getAll();
	}

	@GetMapping(value = "racunId/{id}")
	@ApiOperation(value = "Vraća kolekciju svih računa iz baze podataka čija je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<RacunDao> getRacun(@PathVariable("id") Integer id) {
		RacunDao racun = service.getOneById(id);
		return new ResponseEntity<>(racun, HttpStatus.OK);
	}

	@GetMapping(value = "racunZaId/{id}")
	public Collection<RacunDao> racunId(@PathVariable("id") Integer id) {
		return service.findByRecepitType(id);
	}

	@GetMapping("racunNaziv/{naziv}")
	@ApiOperation(value = "Vraća kolekciju svih računa iz baze podataka čiji je naziv prosleđen kao path varijabla")
	public Collection<RacunDao> getRacunByNaziv(@PathVariable("naziv") String naziv) {
		return service.getByName(naziv);
	}

	@DeleteMapping("racun/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše račun iz baze podataka čija je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<RacunDao> deleteRacun(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("racun")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novi kredit u bazu podataka")
	public ResponseEntity<RacunDao> insertRacun(@RequestBody RacunDao racun) {
		service.insert(racun);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("racun")
	@CrossOrigin
	@ApiOperation(value = "Menja postojeći račun unet u bazi podataka")
	public ResponseEntity<RacunDao> updateRacun(@RequestBody RacunDao racun) {
		service.update(racun);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
