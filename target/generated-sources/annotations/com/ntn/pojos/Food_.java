package com.ntn.pojos;

import com.ntn.pojos.Comment;
import com.ntn.pojos.FoodOrderDetail;
import com.ntn.pojos.Menu;
import com.ntn.pojos.Restaurant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-19T23:05:42")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile SingularAttribute<Food, Long> unitPrice;
    public static volatile SingularAttribute<Food, String> image;
    public static volatile SetAttribute<Food, FoodOrderDetail> foodOrderDetailSet;
    public static volatile SingularAttribute<Food, String> decription;
    public static volatile SetAttribute<Food, Comment> commentSet;
    public static volatile SetAttribute<Food, Menu> menuSet;
    public static volatile SingularAttribute<Food, Restaurant> restaurant;
    public static volatile SingularAttribute<Food, String> name;
    public static volatile SingularAttribute<Food, Integer> id;
    public static volatile SingularAttribute<Food, Date> uploadTime;
    public static volatile SingularAttribute<Food, String> category;
    public static volatile SingularAttribute<Food, Short> status;

}