package rs.fonis.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.fonis.domain.User;
import rs.fonis.exceptions.AppException;
import rs.fonis.services.UserService;
import rs.fonis.services.impl.UserServiceImpl;

@Path("/users")
public class UserRestService {

	protected UserService userService;
	protected Gson gson;

	public UserRestService() {
		userService = new UserServiceImpl();
		gson = new GsonBuilder().create();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public Response getUser(@PathParam("id") int id) {

		User u = userService.getUser(id);

		if (u == null) {
			throw new AppException(Status.NOT_FOUND, "There is no user with the id: " + id);
		}
		String json = gson.toJson(u);

		return Response.status(Status.OK).entity(json).build();
	}

}
