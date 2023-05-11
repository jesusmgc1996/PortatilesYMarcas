package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the continente database table.
 * 
 */
@Entity
@NamedQuery(name="Continente.findAll", query="SELECT c FROM Continente c")
public class Continente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Pai
	@OneToMany(mappedBy="continente")
	private List<Pais> pais;

	public Continente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pais> getPais() {
		return this.pais;
	}

	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}

	public Pais addPais(Pais pais) {
		getPais().add(pais);
		pais.setContinente(this);

		return pais;
	}

	public Pais removePais(Pais pais) {
		getPais().remove(pais);
		pais.setContinente(null);

		return pais;
	}

	@Override
	public String toString() {
		return descripcion;
	}

}