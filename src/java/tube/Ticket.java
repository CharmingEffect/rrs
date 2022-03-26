/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tube;

import tube.train.Train;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arek
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTicketNo", query = "SELECT t FROM Ticket t WHERE t.ticketNo = :ticketNo"),
    @NamedQuery(name = "Ticket.findBySource", query = "SELECT t FROM Ticket t WHERE t.source = :source"),
    @NamedQuery(name = "Ticket.findByDestination", query = "SELECT t FROM Ticket t WHERE t.destination = :destination"),
    @NamedQuery(name = "Ticket.findByDate", query = "SELECT t FROM Ticket t WHERE t.date = :date")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_no")
    private Integer ticketNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "source")
    private String source;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "p_no", referencedColumnName = "p_no")
    @ManyToOne(optional = false)
    private Passenger pNo;
    @JoinColumn(name = "train_no", referencedColumnName = "train_no")
    @ManyToOne(optional = false)
    private Train trainNo;

    public Ticket() {
    }

    public Ticket(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Ticket(Integer ticketNo, String source, String destination, Date date) {
        this.ticketNo = ticketNo;
        this.source = source;
        this.destination = destination;
        this.date = date;
    }

    public Integer getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Passenger getPNo() {
        return pNo;
    }

    public void setPNo(Passenger pNo) {
        this.pNo = pNo;
    }

    public Train getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Train trainNo) {
        this.trainNo = trainNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketNo != null ? ticketNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketNo == null && other.ticketNo != null) || (this.ticketNo != null && !this.ticketNo.equals(other.ticketNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tube.Ticket[ ticketNo=" + ticketNo + " ]";
    }
    
}
