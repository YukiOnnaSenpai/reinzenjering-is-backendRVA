package rva.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.Kredit;

public interface KreditRepository extends JpaRepository<Kredit, Integer> {
	Collection<Kredit> findByNazivKreditaContainingIgnoreCase(String naziv);

}
