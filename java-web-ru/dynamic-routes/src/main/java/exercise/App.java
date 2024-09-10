package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx-> {
            int companyId = ctx.pathParamAsClass("id", Integer.class).get();
            if(companyId < 0 || companyId > COMPANIES.size()) {
                throw new NotFoundResponse("Company not found");
            }
            Optional<Map<String,String>> foundCompany = COMPANIES.stream()
                    .filter(company -> company.get("id")
                            .equals(String.valueOf(companyId)))
                    .findFirst();

            ctx.json(foundCompany.get());
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
