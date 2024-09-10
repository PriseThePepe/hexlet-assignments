package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.bundledPlugins.enableDevLogging();
        });
        
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        app.get("/phones", ctx->ctx.json(phones));
        app.get("/domains", ctx->ctx.json(domains));
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
