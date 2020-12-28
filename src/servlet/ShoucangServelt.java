package servlet;


import dao.JiaoCai;
import dao.JiaoCaiImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShoucangServelt", urlPatterns = "/ShoucangServelt")
public class ShoucangServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数


        int id = Integer.parseInt(request.getParameter("admin"));
        int j_id = Integer.parseInt(request.getParameter("j_id"));
        JiaoCai dao = new JiaoCaiImpl();
        if (dao.byShouchang(id,j_id)==0)
        {
            dao.Shoucang(id,j_id);
        }
        request.setAttribute("id", j_id);
        request.getRequestDispatcher("goods_detail.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}