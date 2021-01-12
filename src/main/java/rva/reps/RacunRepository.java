package rva.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rva.jpa.Racun;
import rva.jpa.TipRacuna;

public interface RacunRepository extends JpaRepository<Racun, Integer> {
	Collection<Racun> findByNazivRacunaContainingIgnoreCase(String naziv);

	Collection<Racun> findByTipRacuna(TipRacuna tr);

	@Query(value = "select coalesce(max(redni_broj)+1, 1) from racun where tipRacuna = ?1", nativeQuery = true)
	Integer nextRBr(Integer tipRacunaId);
}
