/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase.fas2.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jenni
 */
@Entity
@Table(name = "piloto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piloto.findAll", query = "SELECT p FROM Piloto p")
    , @NamedQuery(name = "Piloto.findByCodPiloto", query = "SELECT p FROM Piloto p WHERE p.codPiloto = :codPiloto")
    , @NamedQuery(name = "Piloto.findByNombre", query = "SELECT p FROM Piloto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Piloto.findByApellido", query = "SELECT p FROM Piloto p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Piloto.findByFechanacimiento", query = "SELECT p FROM Piloto p WHERE p.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Piloto.findByLicencia", query = "SELECT p FROM Piloto p WHERE p.licencia = :licencia")})
public class Piloto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_piloto")
    private Integer codPiloto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Basic(optional = false)
    @Column(name = "licencia")
    private float licencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "piloto")
    private Collection<Asignacionvehiculo> asignacionvehiculoCollection;

    public Piloto() {
    }

    public Piloto(Integer codPiloto) {
        this.codPiloto = codPiloto;
    }

    public Piloto(Integer codPiloto, String nombre, String apellido, Date fechanacimiento, float licencia) {
        this.codPiloto = codPiloto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.licencia = licencia;
    }

    public Integer getCodPiloto() {
        return codPiloto;
    }

    public void setCodPiloto(Integer codPiloto) {
        this.codPiloto = codPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public float getLicencia() {
        return licencia;
    }

    public void setLicencia(float licencia) {
        this.licencia = licencia;
    }

    @XmlTransient
    public Collection<Asignacionvehiculo> getAsignacionvehiculoCollection() {
        return asignacionvehiculoCollection;
    }

    public void setAsignacionvehiculoCollection(Collection<Asignacionvehiculo> asignacionvehiculoCollection) {
        this.asignacionvehiculoCollection = asignacionvehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPiloto != null ? codPiloto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piloto)) {
            return false;
        }
        Piloto other = (Piloto) object;
        if ((this.codPiloto == null && other.codPiloto != null) || (this.codPiloto != null && !this.codPiloto.equals(other.codPiloto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fase.fas2.modelo.Piloto[ codPiloto=" + codPiloto + " ]";
    }
    
}
