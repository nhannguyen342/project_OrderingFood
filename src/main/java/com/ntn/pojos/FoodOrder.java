/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
 * @author ACER
 */
@Entity
@Table(name = "food_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodOrder.findAll", query = "SELECT f FROM FoodOrder f"),
    @NamedQuery(name = "FoodOrder.findById", query = "SELECT f FROM FoodOrder f WHERE f.id = :id"),
    @NamedQuery(name = "FoodOrder.findByAmount", query = "SELECT f FROM FoodOrder f WHERE f.amount = :amount"),
    @NamedQuery(name = "FoodOrder.findByCreatedDate", query = "SELECT f FROM FoodOrder f WHERE f.createdDate = :createdDate"),
    @NamedQuery(name = "FoodOrder.findByPayment", query = "SELECT f FROM FoodOrder f WHERE f.payment = :payment"),
    @NamedQuery(name = "FoodOrder.findByIsDelete", query = "SELECT f FROM FoodOrder f WHERE f.isDelete = :isDelete")})
public class FoodOrder implements Serializable {

   


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private long amount;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "payment")
    private String payment;
    @Column(name = "is_delete")
    private Boolean isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodOrder")
    private Set<FoodOrderDetail> foodOrderDetailSet;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public FoodOrder() {
    }

    public FoodOrder(Integer id) {
        this.id = id;
    }

    public FoodOrder(Integer id, long amount, String payment) {
        this.id = id;
        this.amount = amount;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public Set<FoodOrderDetail> getFoodOrderDetailSet() {
        return foodOrderDetailSet;
    }

    public void setFoodOrderDetailSet(Set<FoodOrderDetail> foodOrderDetailSet) {
        this.foodOrderDetailSet = foodOrderDetailSet;
    }

   


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodOrder)) {
            return false;
        }
        FoodOrder other = (FoodOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntn.pojos.FoodOrder[ id=" + id + " ]";
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }



    
}
