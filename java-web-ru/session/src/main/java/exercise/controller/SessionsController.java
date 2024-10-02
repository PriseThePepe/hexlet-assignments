package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("user"));
        ctx.render("index.jte", model("page", page));
    }
    public static void build(Context ctx) {
        var page = new LoginPage(null,null);
        ctx.render("build.jte",model("page",page));
    }

    public static void login(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var optUser = UsersRepository.findByName(name);
        if (optUser.isPresent()){
            var user = optUser.get();
            if(user.getName().equals(name) && user.getPassword().hashCode() == encrypt(password).hashCode()) {
                ctx.sessionAttribute("user",name);
                ctx.redirect(NamedRoutes.rootPath());
            } else {
                var page = new LoginPage(name, "Wrong username or password");
                ctx.render("build.jte", model("page", page));
            }
        } else {
            var page = new LoginPage(name,"Wrong username or password");
          ctx.render("build.jte",model("page",page));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("user",null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
