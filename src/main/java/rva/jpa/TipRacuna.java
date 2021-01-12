package rva.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * The persistent class for the tip_racuna database table.
 * 
 */
@Data
@Entity
@Table(name = "tip_racuna")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedQuery(name = "TipRacuna.findAll", query = "SELECT t FROM TipRacuna t")
public class TipRacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TIP_RACUNA_ID_GENERATOR", sequenceName = "TIP_RACUNA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIP_RACUNA_ID_GENERATOR")
	private Integer id;

	private String naziv;

	private String opis;

	private String oznaka;

	@OneToMany(mappedBy = "tipRacuna")
	@JsonIgnore
	private List<Racun> racuns;
}