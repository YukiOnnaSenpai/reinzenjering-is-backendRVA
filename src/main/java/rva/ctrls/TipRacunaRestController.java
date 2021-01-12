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
import rva.dao.TipRacunaDao;
import rva.service.implementation.TipRacunaService;

@RestController
@AllArgsConstructor
@Api(tags = { "Tip računa CRUD operacije" })
public class TipRacunaRestController {

	private final TipRacunaService service;

	@GetMapping("tipRacuna")
	@ApiOperation(value = "Vraća kolekciju svih tipova računa iz baze podataka")
	public Collection<TipRacunaDao> getTipoviRacuna() {
		return service.getAll();
	}

	@GetMapping("tipRacunaId/{id}")
	@ApiOperation(value = "Vraća kolekciju svih tipova računa iz baze podataka koji imaju isti id prosleđen kao path varijabla")
	public TipRacunaDao getTipRacuna(@PathVariable("id") Integer id) {
		return service.getOneById(id);
	}

	@GetMapping("tipRacunaNaziv/{naziv}")
	@ApiOperation(value = "Vraća kolekciju svih tipova računa iz baze podataka koji u nazivu sadrže string prosleđen kao path varijabla")
	public Collection<TipRacunaDao> geTtipRacunaByNaziv(@PathVariable("naziv") String naziv) {
		return service.getByName(naziv);
	}

	@DeleteMapping("tipRacuna/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše tip računa iz baze podataka čija je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<TipRacunaDao> deleteTipRacuna(@PathVariable("id") Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("tipRacuna")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novi tip računa u bazu podataka")
	public ResponseEntity<TipRacunaDao> insertTipRacuna(@RequestBody TipRacunaDao tipRacuna) {
		service.insert(tipRacuna);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("tipRacuna")
	@CrossOrigin
	@ApiOperation(value = "Menja postojeći tip računa unet u bazi podataka")
	public ResponseEntity<TipRacunaDao> updateTipRacuna(@RequestBody TipRacunaDao tipRacuna) {
		service.update(tipRacuna);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
