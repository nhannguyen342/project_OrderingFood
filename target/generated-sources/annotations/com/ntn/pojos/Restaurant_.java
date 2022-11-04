package com.ntn.pojos;

import com.ntn.pojos.Food;
import com.ntn.pojos.Menu;
import com.ntn.pojos.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-19T23:05:42")
@StaticMetamodel(Restaurant.class)
public class Restaurant_ { 

    public static volatile SingularAttribute<Restaurant, String> image;
    public static volatile SingularAttribute<Restaurant, Date> createdDate;
    public static volatile SetAttribute<Restaurant, Menu> menuSet;
    public static volatile SingularAttribute<Restaurant, String> name;
    public static volatile SingularAttribute<Restaurant, String> description;
    public static volatile SingularAttribute<Restaurant, Integer> id;
    public static volatile SingularAttribute<Restaurant, User> userId;
    public static volatile CollectionAttribute<Restaurant, Food> foodCollection;

}