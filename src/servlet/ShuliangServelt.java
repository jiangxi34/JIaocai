package servlet;

import dao.JiaoCai;
import dao.JiaoCaiImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShuliangServelt", urlPatterns = "/ShuliangServelt")
public class ShuliangServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        int shuliang = Integer.parseInt(request.getParameter("shuliang"));

        JiaoCai dao = new JiaoCaiImpl();
        dao.GaiShuliang(id,shuliang);

        request.getRequestDispatcher("goods_cart.jsp").forward(request, response); // 前面页面：登陆页面

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
