import commons.FlywayInitializer;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import server.DefaultServer;
import server.handlers.SecurityHandlerBuilder;
import server.servlets.MainServlet;

import java.net.URL;

public class Application {
    public static void main(String[] args) throws Exception {
        FlywayInitializer.initDB();
        final Server server = new DefaultServer().build();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        final URL resource = LoginService.class.getResource("/static/help.html");
        context.setBaseResource(Resource.newResource(resource.toExternalForm()));
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");
        context.addServlet(new ServletHolder("main", MainServlet.class),"/prod");

        final String hashConfig = Application.class.getResource("/hash_config").toExternalForm();
        final HashLoginService hashLoginService = new HashLoginService("login", hashConfig);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(hashLoginService);

        server.addBean(hashLoginService);
        securityHandler.setHandler(context);
        server.setHandler(securityHandler);
        server.start();
    }
}
