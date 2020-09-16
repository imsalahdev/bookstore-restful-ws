package dev.salah;

import dev.salah.Categories;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-16T18:09:48")
@StaticMetamodel(Books.class)
public class Books_ { 

    public static volatile SingularAttribute<Books, byte[]> thumbnail;
    public static volatile SingularAttribute<Books, String> author;
    public static volatile SingularAttribute<Books, Double> price;
    public static volatile SingularAttribute<Books, Integer> count;
    public static volatile SingularAttribute<Books, String> information;
    public static volatile SingularAttribute<Books, Integer> id;
    public static volatile SingularAttribute<Books, String> title;
    public static volatile SingularAttribute<Books, Categories> categoryID;

}