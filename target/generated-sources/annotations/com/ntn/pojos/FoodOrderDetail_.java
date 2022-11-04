package com.ntn.pojos;

import com.ntn.pojos.Food;
import com.ntn.pojos.FoodOrder;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-19T23:05:42")
@StaticMetamodel(FoodOrderDetail.class)
public class FoodOrderDetail_ { 

    public static volatile SingularAttribute<FoodOrderDetail, Date> createdDate;
    public static volatile SingularAttribute<FoodOrderDetail, Long> totalPrice;
    public static volatile SingularAttribute<FoodOrderDetail, Food> foodId;
    public static volatile SingularAttribute<FoodOrderDetail, Integer> id;
    public static volatile SingularAttribute<FoodOrderDetail, Long> shipPrice;
    public static volatile SingularAttribute<FoodOrderDetail, FoodOrder> foodOrder;
    public static volatile SingularAttribute<FoodOrderDetail, Date> sellTime;
    public static volatile SingularAttribute<FoodOrderDetail, Integer> foodQuantity;

}