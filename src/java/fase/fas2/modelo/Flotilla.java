/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase.fas2.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jenni
 */
@Entity
@Table(name = "flotilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flotilla.findAll", query = "SELECT f FROM Flotilla f")
    , @NamedQuery(name = "Flotilla.findByCodflotilla", query = "SELECT f FROM Flotilla f WHERE f.codflotilla = :codflotilla")
    , @NamedQuery(name = "Flotilla.findByNombre", query = "SELECT f FROM Flotilla f WHERE f.nombre = :nombre")})
public class Flotilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codflotilla")
    private Integer codflotilla;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flotillaCodflotilla")
    private Collection<Vehiculo> vehiculoCollection;

    public Flotilla() {
    }

    public Flotilla(Integer codflotilla) {
        this.codflotilla = codflotilla;
    }

    public Flotilla(Integer codflotilla, String nombre) {
        this.codflotilla = codflotilla;
        this.nombre = nombre;
    }

    public Integer getCodflotilla() {
        return codflotilla;
    }

    public void setCodflotilla(Integer codflotilla) {
        this.codflotilla = codflotilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codflotilla != null ? codflotilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flotilla)) {
            return false;
        }
        Flotilla other = (Flotilla) object;
        if ((this.codflotilla == null && other.codflotilla != null) || (this.codflotilla != null && !this.codflotilla.equals(other.codflotilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fase.fas2.modelo.Flotilla[ codflotilla=" + codflotilla + " ]";
    }
    
}
