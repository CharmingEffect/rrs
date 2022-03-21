/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tube;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arek
 */
@Entity
@Table(name = "passenger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passenger.findAll", query = "SELECT p FROM Passenger p"),
    @NamedQuery(name = "Passenger.findByPNo", query = "SELECT p FROM Passenger p WHERE p.pNo = :pNo"),
    @NamedQuery(name = "Passenger.findByPFirstName", query = "SELECT p FROM Passenger p WHERE p.pFirstName = :pFirstName"),
    @NamedQuery(name = "Passenger.findByPLastName", query = "SELECT p FROM Passenger p WHERE p.pLastName = :pLastName"),
    @NamedQuery(name = "Passenger.findByPDob", query = "SELECT p FROM Passenger p WHERE p.pDob = :pDob"),
    @NamedQuery(name = "Passenger.findByPPhone", query = "SELECT p FROM Passenger p WHERE p.pPhone = :pPhone"),
    @NamedQuery(name = "Passenger.findByPGender", query = "SELECT p FROM Passenger p WHERE p.pGender = :pGender")})
public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_no")
    private Integer pNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "p_first_name")
    private String pFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "p_last_name")
    private String pLastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_dob")
    @Temporal(TemporalType.DATE)
    private Date pDob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "p_phone")
    private long pPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "p_gender")
    private String pGender;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pNo")
    private Collection<Ticket> ticketCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Passenger() {
    }

    public Passenger(Integer pNo) {
        this.pNo = pNo;
    }

    public Passenger(Integer pNo, String pFirstName, String pLastName, Date pDob, long pPhone, String pGender) {
        this.pNo = pNo;
        this.pFirstName = pFirstName;
        this.pLastName = pLastName;
        this.pDob = pDob;
        this.pPhone = pPhone;
        this.pGender = pGender;
    }

    public Integer getPNo() {
        return pNo;
    }

    public void setPNo(Integer pNo) {
        this.pNo = pNo;
    }

    public String getPFirstName() {
        return pFirstName;
    }

    public void setPFirstName(String pFirstName) {
        this.pFirstName = pFirstName;
    }

    public String getPLastName() {
        return pLastName;
    }

    public void setPLastName(String pLastName) {
        this.pLastName = pLastName;
    }

    public Date getPDob() {
        return pDob;
    }

    public void setPDob(Date pDob) {
        this.pDob = pDob;
    }

    public long getPPhone() {
        return pPhone;
    }

    public void setPPhone(long pPhone) {
        this.pPhone = pPhone;
    }

    public String getPGender() {
        return pGender;
    }

    public void setPGender(String pGender) {
        this.pGender = pGender;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pNo != null ? pNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passenger)) {
            return false;
        }
        Passenger other = (Passenger) object;
        if ((this.pNo == null && other.pNo != null) || (this.pNo != null && !this.pNo.equals(other.pNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tube.Passenger[ pNo=" + pNo + " ]";
    }
    
}
