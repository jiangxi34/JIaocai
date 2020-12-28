package servlet;

import dao.JiaoCai;
import dao.JiaoCaiImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "S_goodsServlet", urlPatterns = "/S_goodsServlet")
public class S_goodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        System.out.println(request.getParameter("id"));
        if (request.getParameter("id")!=null)
        {
            int id = Integer.parseInt(request.getParameter("id"));
            JiaoCai dao = new JiaoCaiImpl();
            dao.deGoods(id);
            request.getRequestDispatcher("goods_cart.jsp").forward(request, response);
        }
        request.getRequestDispatcher("goods_cart.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
