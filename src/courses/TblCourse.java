/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_course", catalog = "course", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblCourse.findAll", query = "SELECT t FROM TblCourse t"),
    @NamedQuery(name = "TblCourse.findByCrsId", query = "SELECT t FROM TblCourse t WHERE t.crsId = :crsId"),
    @NamedQuery(name = "TblCourse.findByCrsCode", query = "SELECT t FROM TblCourse t WHERE t.crsCode = :crsCode"),
    @NamedQuery(name = "TblCourse.findByCrsName", query = "SELECT t FROM TblCourse t WHERE t.crsName = :crsName"),
    @NamedQuery(name = "TblCourse.findByCrsDescriptiom", query = "SELECT t FROM TblCourse t WHERE t.crsDescriptiom = :crsDescriptiom"),
    @NamedQuery(name = "TblCourse.findByCrsType", query = "SELECT t FROM TblCourse t WHERE t.crsType = :crsType"),
    @NamedQuery(name = "TblCourse.findByCrsnumberOfCredits", query = "SELECT t FROM TblCourse t WHERE t.crsnumberOfCredits = :crsnumberOfCredits"),
    @NamedQuery(name = "TblCourse.findByCrsLab", query = "SELECT t FROM TblCourse t WHERE t.crsLab = :crsLab")})
public class TblCourse implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "crs_id")
    private Integer crsId;
    @Basic(optional = false)
    @Column(name = "crs_code")
    private String crsCode;
    @Basic(optional = false)
    @Column(name = "crs_name")
    private String crsName;
    @Column(name = "crs_descriptiom")
    private String crsDescriptiom;
    @Basic(optional = false)
    @Column(name = "crs_type")
    private String crsType;
    @Basic(optional = false)
    @Column(name = "crs_numberOfCredits")
    private int crsnumberOfCredits;
    @Basic(optional = false)
    @Column(name = "crs_lab")
    private String crsLab;

    public TblCourse() {
    }

    public TblCourse(Integer crsId) {
        this.crsId = crsId;
    }

    public TblCourse(Integer crsId, String crsCode, String crsName, String crsType, int crsnumberOfCredits, String crsLab) {
        this.crsId = crsId;
        this.crsCode = crsCode;
        this.crsName = crsName;
        this.crsType = crsType;
        this.crsnumberOfCredits = crsnumberOfCredits;
        this.crsLab = crsLab;
    }

    public Integer getCrsId() {
        return crsId;
    }

    public void setCrsId(Integer crsId) {
        Integer oldCrsId = this.crsId;
        this.crsId = crsId;
        changeSupport.firePropertyChange("crsId", oldCrsId, crsId);
    }

    public String getCrsCode() {
        return crsCode;
    }

    public void setCrsCode(String crsCode) {
        String oldCrsCode = this.crsCode;
        this.crsCode = crsCode;
        changeSupport.firePropertyChange("crsCode", oldCrsCode, crsCode);
    }

    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        String oldCrsName = this.crsName;
        this.crsName = crsName;
        changeSupport.firePropertyChange("crsName", oldCrsName, crsName);
    }

    public String getCrsDescriptiom() {
        return crsDescriptiom;
    }

    public void setCrsDescriptiom(String crsDescriptiom) {
        String oldCrsDescriptiom = this.crsDescriptiom;
        this.crsDescriptiom = crsDescriptiom;
        changeSupport.firePropertyChange("crsDescriptiom", oldCrsDescriptiom, crsDescriptiom);
    }

    public String getCrsType() {
        return crsType;
    }

    public void setCrsType(String crsType) {
        String oldCrsType = this.crsType;
        this.crsType = crsType;
        changeSupport.firePropertyChange("crsType", oldCrsType, crsType);
    }

    public int getCrsnumberOfCredits() {
        return crsnumberOfCredits;
    }

    public void setCrsnumberOfCredits(int crsnumberOfCredits) {
        int oldCrsnumberOfCredits = this.crsnumberOfCredits;
        this.crsnumberOfCredits = crsnumberOfCredits;
        changeSupport.firePropertyChange("crsnumberOfCredits", oldCrsnumberOfCredits, crsnumberOfCredits);
    }

    public String getCrsLab() {
        return crsLab;
    }

    public void setCrsLab(String crsLab) {
        String oldCrsLab = this.crsLab;
        this.crsLab = crsLab;
        changeSupport.firePropertyChange("crsLab", oldCrsLab, crsLab);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crsId != null ? crsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCourse)) {
            return false;
        }
        TblCourse other = (TblCourse) object;
        if ((this.crsId == null && other.crsId != null) || (this.crsId != null && !this.crsId.equals(other.crsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "courses.TblCourse[ crsId=" + crsId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
