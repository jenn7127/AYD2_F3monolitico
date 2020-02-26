/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase.fas2.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jenni
 */
@Entity
@Table(name = "asignacionvehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacionvehiculo.findAll", query = "SELECT a FROM Asignacionvehiculo a")
    , @NamedQuery(name = "Asignacionvehiculo.findByPilotoCodPiloto", query = "SELECT a FROM Asignacionvehiculo a WHERE a.asignacionvehiculoPK.pilotoCodPiloto = :pilotoCodPiloto")
    , @NamedQuery(name = "Asignacionvehiculo.findByVehiculoPlaca", query = "SELECT a FROM Asignacionvehiculo a WHERE a.asignacionvehiculoPK.vehiculoPlaca = :vehiculoPlaca")
    , @NamedQuery(name = "Asignacionvehiculo.findByFechaasignacion", query = "SELECT a FROM Asignacionvehiculo a WHERE a.fechaasignacion = :fechaasignacion")})
public class Asignacionvehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionvehiculoPK asignacionvehiculoPK;
    @Basic(optional = false)
    @Column(name = "fechaasignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaasignacion;
    @JoinColumn(name = "piloto_cod_piloto", referencedColumnName = "cod_piloto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Piloto piloto;
    @JoinColumn(name = "vehiculo_placa", referencedColumnName = "placa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehiculo vehiculo;

    public Asignacionvehiculo() {
    }

    public Asignacionvehiculo(AsignacionvehiculoPK asignacionvehiculoPK) {
        this.asignacionvehiculoPK = asignacionvehiculoPK;
    }

    public Asignacionvehiculo(AsignacionvehiculoPK asignacionvehiculoPK, Date fechaasignacion) {
        this.asignacionvehiculoPK = asignacionvehiculoPK;
        this.fechaasignacion = fechaasignacion;
    }

    public Asignacionvehiculo(int pilotoCodPiloto, String vehiculoPlaca) {
        this.asignacionvehiculoPK = new AsignacionvehiculoPK(pilotoCodPiloto, vehiculoPlaca);
    }

    public AsignacionvehiculoPK getAsignacionvehiculoPK() {
        return asignacionvehiculoPK;
    }

    public void setAsignacionvehiculoPK(AsignacionvehiculoPK asignacionvehiculoPK) {
        this.asignacionvehiculoPK = asignacionvehiculoPK;
    }

    public Date getFechaasignacion() {
        return fechaasignacion;
    }

    public void setFechaasignacion(Date fechaasignacion) {
        this.fechaasignacion = fechaasignacion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionvehiculoPK != null ? asignacionvehiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacionvehiculo)) {
            return false;
        }
        Asignacionvehiculo other = (Asignacionvehiculo) object;
        if ((this.asignacionvehiculoPK == null && other.asignacionvehiculoPK != null) || (this.asignacionvehiculoPK != null && !this.asignacionvehiculoPK.equals(other.asignacionvehiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fase.fas2.modelo.Asignacionvehiculo[ asignacionvehiculoPK=" + asignacionvehiculoPK + " ]";
    }
    
}
