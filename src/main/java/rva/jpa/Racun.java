package rva.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * The persistent class for the racun database table.
 * 
 */
@Data
@Entity
@NamedQuery(name = "Racun.findAll", query = "SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RACUN_ID_GENERATOR", sequenceName = "RACUN_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RACUN_ID_GENERATOR")
	private Integer id;

	private String nazivRacuna;

	private String opisRacuna;

	private String oznakaRacuna;

	@ManyToOne
	@JoinColumn(name = "tip_racuna")
	private TipRacuna tipRacuna;

	@ManyToOne
	@JoinColumn(name = "klijent")
	private Klijent klijent;

}