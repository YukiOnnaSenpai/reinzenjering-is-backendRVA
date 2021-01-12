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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * The persistent class for the kredit database table.
 * 
 */
@Data
@Entity
@NamedQuery(name = "Kredit.findAll", query = "SELECT k FROM Kredit k")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Kredit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "KREDIT_ID_GENERATOR", sequenceName = "KREDIT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KREDIT_ID_GENERATOR")
	private Integer id;

	private String nazivKredita;

	private String opisKredita;

	private String oznakaKredita;

	@OneToMany(mappedBy = "kredit")
	@JsonIgnore
	private List<Klijent> klijents;

}