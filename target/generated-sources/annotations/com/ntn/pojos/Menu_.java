package com.ntn.pojos;

import com.ntn.pojos.Food;
import com.ntn.pojos.Restaurant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-19T23:05:42")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Food> foodId;
    public static volatile SingularAttribute<Menu, String> name;
    public static volatile SingularAttribute<Menu, Integer> id;
    public static volatile SingularAttribute<Menu, Restaurant> restaurantId;

}