package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;



public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void register(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        User user = new User(firstName,lastName,email,password,token);
        ctx.cookie("token",token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }
    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        String tokenFromCookie = ctx.cookie("token");
        try {
            var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("Пользователь не найден"));
            if(user.getToken().equals(tokenFromCookie)) {
                UserPage page = new UserPage(user);
                ctx.render("users/show.jte", model("page", page));
            } else{
                ctx.redirect(NamedRoutes.buildUserPath());
            }
        } catch (NotFoundResponse e) {
            ctx.redirect(NamedRoutes.buildUserPath());
        }

    }
    // END
}
