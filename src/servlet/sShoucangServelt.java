package servlet;


import dao.JiaoCai;
import dao.JiaoCaiImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sShoucangServelt", urlPatterns = "/sShoucangServelt")
public class sShoucangServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数

        int id = Integer.parseInt(request.getParameter("admin"));
        int j_id = Integer.parseInt(request.getParameter("j_id"));
        JiaoCai dao = new JiaoCaiImpl();
        dao.sShoucang(id,j_id);
        request.getRequestDispatcher("shu.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}