package server.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import server.RequestsWithDataBase;

import java.io.IOException;

public class MainServlet extends HttpServlet {
    private final RequestsWithDataBase requestsWithDataBase = new RequestsWithDataBase();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().println(RequestsWithDataBase.getRequest());
    }

    @Override
    public void doPost(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) {
        String postInfo = req.getParameter("product");
        if (RequestsWithDataBase.postFlag) {
            RequestsWithDataBase.postRequest(postInfo);
            System.out.println("product has been added");
            resp.setStatus(HttpServletResponse.SC_OK);
            RequestsWithDataBase.postFlag=false;
        }
        else{
            System.out.println("product can't be added");
            resp.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        }
    }

}
