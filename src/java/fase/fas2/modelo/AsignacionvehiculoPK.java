/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fase.fas2.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jenni
 */
@Embeddable
public class AsignacionvehiculoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "piloto_cod_piloto")
    private int pilotoCodPiloto;
    @Basic(optional = false)
    @Column(name = "vehiculo_placa")
    private String vehiculoPlaca;

    public AsignacionvehiculoPK() {
    }

    public AsignacionvehiculoPK(int pilotoCodPiloto, String vehiculoPlaca) {
        this.pilotoCodPiloto = pilotoCodPiloto;
        this.vehiculoPlaca = vehiculoPlaca;
    }

    public int getPilotoCodPiloto() {
        return pilotoCodPiloto;
    }

    public void setPilotoCodPiloto(int pilotoCodPiloto) {
        this.pilotoCodPiloto = pilotoCodPiloto;
    }

    public String getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(String vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pilotoCodPiloto;
        hash += (vehiculoPlaca != null ? vehiculoPlaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionvehiculoPK)) {
            return false;
        }
        AsignacionvehiculoPK other = (AsignacionvehiculoPK) object;
        if (this.pilotoCodPiloto != other.pilotoCodPiloto) {
            return false;
        }
        if ((this.vehiculoPlaca == null && other.vehiculoPlaca != null) || (this.vehiculoPlaca != null && !this.vehiculoPlaca.equals(other.vehiculoPlaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fase.fas2.modelo.AsignacionvehiculoPK[ pilotoCodPiloto=" + pilotoCodPiloto + ", vehiculoPlaca=" + vehiculoPlaca + " ]";
    }
    
}
