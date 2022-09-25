package com.filmes.meira.resources;

import com.filmes.meira.entity.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;

@Path("user")
public class UserResource {

    @GET
    public String status() {
        return "Server is up!";
    }

    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") int id) {
        return User.findById(id);
    }

    @POST
    @Transactional
    public void saveUser(User user) {
        user.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteUser(@PathParam("id") int id) {
        User.deleteById(id);
    }

}
