package com.ntn.pojos;

import com.ntn.pojos.FoodOrderDetail;
import com.ntn.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-19T23:05:42")
@StaticMetamodel(FoodOrder.class)
public class FoodOrder_ { 

    public static volatile SetAttribute<FoodOrder, FoodOrderDetail> foodOrderDetailSet;
    public static volatile SingularAttribute<FoodOrder, Long> amount;
    public static volatile SingularAttribute<FoodOrder, Date> createdDate;
    public static volatile SingularAttribute<FoodOrder, Boolean> isDelete;
    public static volatile SingularAttribute<FoodOrder, String> payment;
    public static volatile SingularAttribute<FoodOrder, Integer> id;
    public static volatile SingularAttribute<FoodOrder, User> userId;

}