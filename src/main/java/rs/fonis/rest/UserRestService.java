package rs.fonis.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import rs.fonis.domain.User;
import rs.fonis.rest.exceptions.AppException;
import rs.fonis.services.UserService;
import rs.fonis.services.impl.UserServiceImpl;

@Path("/users")
public class UserRestService {

	private UserService userService;
	private Gson gson;

	public UserRestService() {
		userService = new UserServiceImpl();
		gson = new GsonBuilder().create();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@QueryParam("limit") Integer l, @QueryParam("page") Integer p) {

		Integer limit;
		Integer page;

		if (l == null || l < 1) {
			limit = 10;
		} else {
			limit = l;
		}

		if (p == null || p < 1) {
			page = 1;
		} else {
			page = p;
		}

		List<User> users = userService.getUsers(limit, page);

		if (users.isEmpty()) {
			throw new AppException(Status.NO_CONTENT, "There is no users on selected page.");
		}

		String jsonUsers = gson.toJson(users);

		return Response.status(Status.OK).entity(jsonUsers).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") int id) {

		User u = userService.getUser(id);

		if (u == null) {
			throw new AppException(Status.NOT_FOUND, "There is no user with the id: " + id);
		}
		String json = gson.toJson(u);

		return Response.status(Status.OK).entity(json).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) {

		boolean deleted = userService.deleteUser(id);

		JsonObject odgovor = new JsonObject();

		if (deleted) {
			odgovor.addProperty("status", Status.OK + "");
			odgovor.addProperty("message", "User je izbrisan");
			return Response.status(Status.OK).entity(odgovor.toString()).build();
		} else {
			throw new AppException(Status.BAD_REQUEST, "Error in deleting user.");
		}

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {

		User u = userService.insertUser(user);

		if (u == null) {
			throw new AppException(Status.BAD_REQUEST, "Error in creating user!");
		}
		String json = gson.toJson(u);

		return Response.status(Status.OK).entity(json).build();
	}

}
