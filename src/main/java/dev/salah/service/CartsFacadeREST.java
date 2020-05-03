/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.salah.service;

import dev.salah.Carts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Salah Eddine Lachkar
 */
@Stateless
@Path("dev.salah.carts")
public class CartsFacadeREST extends AbstractFacade<Carts> {

    @PersistenceContext(unitName = "dev.salah_bookstore-restful-ws_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public CartsFacadeREST() {
        super(Carts.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Carts entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Integer id, Carts entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @DELETE
    @Path("cart/{userId}")
    public void removeByUserID(@PathParam("userId") Integer userId) {
        Query query = em.createNamedQuery("Carts.removeByUserID")
                .setParameter("userId", userId);
        query.executeUpdate();
    }

    @DELETE
    @Path("cart/{userId}/{bookId}")
    public void removeByCart(@PathParam("userId") Integer userId, @PathParam("bookId") Integer bookId) {
        Query query = em.createNamedQuery("Carts.removeByCart")
                .setParameter("userId", userId)
                .setParameter("bookId", bookId);
        query.executeUpdate();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carts find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carts> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carts> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("userId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carts> findByUserId(@PathParam("userId") Integer userId) {
        Query query = em.createNamedQuery("Carts.findByUserId").setParameter("userId", userId);
        return (List<Carts>) query.getResultList();
    }

    @GET
    @Path("cart/{userId}/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carts findByCart(@PathParam("userId") Integer userId, @PathParam("bookId") Integer bookId) {
        try {
            Query query = em.createNamedQuery("Carts.findByCart")
                    .setParameter("userId", userId)
                    .setParameter("bookId", bookId);
            return (Carts) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
