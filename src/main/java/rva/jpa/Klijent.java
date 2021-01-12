package rva.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * The persistent class for the klijent database table.
 * 
 */
@Data
@Entity
@NamedQuery(name = "Klijent.findAll", query = "SELECT k FROM Klijent k")
public class Klijent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "KLIJENT_ID_GENERATOR", sequenceName = "KLIJENT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "KLIJENT_ID_GENERATOR")
	private Integer id;

	@Column(name = "broj_lk")
	private Integer brojLk;

	private String ime;

	private String prezime;

	@ManyToOne
	@JoinColumn(name = "kredit")
	private Kredit kredit;

	@JsonIgnore
	@OneToMany(mappedBy = "klijent")
	private List<Racun> racuns;

}