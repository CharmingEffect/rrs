/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tube.train;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import tube.Ticket;

/**
 *
 * @author Arek
 */
@Entity
@Table(name = "train")
@XmlRootElement
@Named
@SessionScoped
@NamedQueries({
    @NamedQuery(name = "Train.findAll", query = "SELECT t FROM Train t"),
    @NamedQuery(name = "Train.findByTrainNo", query = "SELECT t FROM Train t WHERE t.trainNo = :trainNo"),
    @NamedQuery(name = "Train.findByTrainName", query = "SELECT t FROM Train t WHERE t.trainName = :trainName"),
    @NamedQuery(name = "Train.findByDistance", query = "SELECT t FROM Train t WHERE t.distance = :distance"),
    @NamedQuery(name = "Train.findByStartTime", query = "SELECT t FROM Train t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Train.findByEndTime", query = "SELECT t FROM Train t WHERE t.endTime = :endTime"),
    @NamedQuery(name = "Train.findByLeaveFromStn", query = "SELECT t FROM Train t WHERE t.leaveFromStn = :leaveFromStn"),
    @NamedQuery(name = "Train.findByArriveAtStn", query = "SELECT t FROM Train t WHERE t.arriveAtStn = :arriveAtStn")})
public class Train implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "train_no")
    private Integer trainNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "train_name")
    private String trainName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distance")
    private int distance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "leave_from_stn")
    private String leaveFromStn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "arrive_at_stn")
    private String arriveAtStn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainNo")
    private Collection<Ticket> ticketCollection;

    public Train() {
    }

    public Train(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public Train(Integer trainNo, String trainName, int distance, Date startTime, Date endTime, String leaveFromStn, String arriveAtStn) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.leaveFromStn = leaveFromStn;
        this.arriveAtStn = arriveAtStn;
    }

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLeaveFromStn() {
        return leaveFromStn;
    }

    public void setLeaveFromStn(String leaveFromStn) {
        this.leaveFromStn = leaveFromStn;
    }

    public String getArriveAtStn() {
        return arriveAtStn;
    }

    public void setArriveAtStn(String arriveAtStn) {
        this.arriveAtStn = arriveAtStn;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainNo != null ? trainNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Train)) {
            return false;
        }
        Train other = (Train) object;
        if ((this.trainNo == null && other.trainNo != null) || (this.trainNo != null && !this.trainNo.equals(other.trainNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tube.Train[ trainNo=" + trainNo + " ]";
    }
    
}
