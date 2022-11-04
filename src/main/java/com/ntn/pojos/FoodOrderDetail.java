/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntn.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "food_order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodOrderDetail.findAll", query = "SELECT f FROM FoodOrderDetail f"),
    @NamedQuery(name = "FoodOrderDetail.findById", query = "SELECT f FROM FoodOrderDetail f WHERE f.id = :id"),
    @NamedQuery(name = "FoodOrderDetail.findByTotalPrice", query = "SELECT f FROM FoodOrderDetail f WHERE f.totalPrice = :totalPrice"),
    @NamedQuery(name = "FoodOrderDetail.findByShipPrice", query = "SELECT f FROM FoodOrderDetail f WHERE f.shipPrice = :shipPrice"),
    @NamedQuery(name = "FoodOrderDetail.findByCreatedDate", query = "SELECT f FROM FoodOrderDetail f WHERE f.createdDate = :createdDate"),
    @NamedQuery(name = "FoodOrderDetail.findBySellTime", query = "SELECT f FROM FoodOrderDetail f WHERE f.sellTime = :sellTime"),
    @NamedQuery(name = "FoodOrderDetail.findByFoodQuantity", query = "SELECT f FROM FoodOrderDetail f WHERE f.foodQuantity = :foodQuantity")})
public class FoodOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_price")
    private long totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ship_price")
    private long shipPrice;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "sell_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sellTime;
    @Column(name = "food_quantity")
    private Integer foodQuantity;
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Food foodId;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FoodOrder foodOrder;

    public FoodOrderDetail() {
    }

    public FoodOrderDetail(Integer id) {
        this.id = id;
    }

    public FoodOrderDetail(Integer id, long totalPrice, long shipPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.shipPrice = shipPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(long shipPrice) {
        this.shipPrice = shipPrice;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public Integer getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Integer foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }

    public FoodOrder getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(FoodOrder foodOrder) {
        this.foodOrder = foodOrder;
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
        if (!(object instanceof FoodOrderDetail)) {
            return false;
        }
        FoodOrderDetail other = (FoodOrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntn.pojos.FoodOrderDetail[ id=" + id + " ]";
    }
    
}
