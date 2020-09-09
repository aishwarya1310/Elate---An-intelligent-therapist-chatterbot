import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import service.PersonService;

public class PersonStubApp extends Application<PersonStubConfig> {

    public static void main(String[] args) throws Exception {
        new PersonStubApp().run(args);
    }

    @Override
    public void run(PersonStubConfig config, Environment env) {
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

//        env.healthChecks().register("template",
//                new PersonStubCheck(config.getVersion()));
    }
}