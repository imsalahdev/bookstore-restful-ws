package dev.salah;

import dev.salah.Books;
import dev.salah.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-16T18:09:48")
@StaticMetamodel(Carts.class)
public class Carts_ { 

    public static volatile SingularAttribute<Carts, Integer> id;
    public static volatile SingularAttribute<Carts, Users> userId;
    public static volatile SingularAttribute<Carts, Books> bookId;

}