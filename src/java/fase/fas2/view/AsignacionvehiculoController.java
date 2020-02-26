package fase.fas2.view;

import fase.fas2.modelo.Asignacionvehiculo;
import fase.fas2.view.util.JsfUtil;
import fase.fas2.view.util.JsfUtil.PersistAction;
import fase.fas2.jpa.AsignacionvehiculoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("asignacionvehiculoController")
@SessionScoped
public class AsignacionvehiculoController implements Serializable {

    @EJB
    private fase.fas2.jpa.AsignacionvehiculoFacade ejbFacade;
    private List<Asignacionvehiculo> items = null;
    private Asignacionvehiculo selected;

    public AsignacionvehiculoController() {
    }

    public Asignacionvehiculo getSelected() {
        return selected;
    }

    public void setSelected(Asignacionvehiculo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getAsignacionvehiculoPK().setVehiculoPlaca(selected.getVehiculo().getPlaca());
        selected.getAsignacionvehiculoPK().setPilotoCodPiloto(selected.getPiloto().getCodPiloto());
    }

    protected void initializeEmbeddableKey() {
        selected.setAsignacionvehiculoPK(new fase.fas2.modelo.AsignacionvehiculoPK());
    }

    private AsignacionvehiculoFacade getFacade() {
        return ejbFacade;
    }

    public Asignacionvehiculo prepareCreate() {
        selected = new Asignacionvehiculo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AsignacionvehiculoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AsignacionvehiculoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AsignacionvehiculoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Asignacionvehiculo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Asignacionvehiculo getAsignacionvehiculo(fase.fas2.modelo.AsignacionvehiculoPK id) {
        return getFacade().find(id);
    }

    public List<Asignacionvehiculo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Asignacionvehiculo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Asignacionvehiculo.class)
    public static class AsignacionvehiculoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AsignacionvehiculoController controller = (AsignacionvehiculoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "asignacionvehiculoController");
            return controller.getAsignacionvehiculo(getKey(value));
        }

        fase.fas2.modelo.AsignacionvehiculoPK getKey(String value) {
            fase.fas2.modelo.AsignacionvehiculoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new fase.fas2.modelo.AsignacionvehiculoPK();
            key.setPilotoCodPiloto(Integer.parseInt(values[0]));
            key.setVehiculoPlaca(values[1]);
            return key;
        }

        String getStringKey(fase.fas2.modelo.AsignacionvehiculoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getPilotoCodPiloto());
            sb.append(SEPARATOR);
            sb.append(value.getVehiculoPlaca());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Asignacionvehiculo) {
                Asignacionvehiculo o = (Asignacionvehiculo) object;
                return getStringKey(o.getAsignacionvehiculoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Asignacionvehiculo.class.getName()});
                return null;
            }
        }

    }

}
