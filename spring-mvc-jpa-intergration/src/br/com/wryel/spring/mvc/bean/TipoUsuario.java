package br.com.wryel.spring.mvc.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author pirate
CREATE TABLE tipo_usuario (
  id_tipo_usuario INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL
);
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_tipo_usuario")
	private Long id;
	
	private String descricao;
	
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> usuarios;

	public TipoUsuario() {
		
	}
	
	public TipoUsuario(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoUsuario other = (TipoUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public TipoUsuario clone() throws CloneNotSupportedException {
		return (TipoUsuario) super.clone();
	}
}
