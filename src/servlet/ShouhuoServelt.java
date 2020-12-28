package servlet;


import dao.JiaoCai;
import dao.JiaoCaiImpl;
import model.Yhmodel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ShouhuoServelt", urlPatterns = "/ShouhuoServelt")
public class ShouhuoServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
       int zhuang;
        System.out.println(request.getParameter("fa"));
        System.out.println(request.getParameter("fa"));
        System.out.println(request.getParameter("fa"));
        System.out.println(request.getParameter("fa"));
        System.out.println(request.getParameter("fa"));
        System.out.println(request.getParameter("fa"));
        System.out.println(request.getParameter("y_id"));
        System.out.println(request.getParameter("d_id"));
        if (request.getParameter("y_id")!=null && request.getParameter("d_id")!=null)
        {
            int y_id = Integer.parseInt(request.getParameter("y_id"));
            int d_id = Integer.parseInt(request.getParameter("d_id"));
            JiaoCai dao = new JiaoCaiImpl();
            if (request.getParameter("fa")!=null){
                zhuang = 2;
                dao.Shouhuo(y_id,d_id,zhuang);
                request.getRequestDispatcher("order_list_admin.jsp").forward(request, response);
            }else {
                 zhuang = 3;
                 dao.Shouhuo(y_id,d_id,zhuang);
                 request.getRequestDispatcher("order_list.jsp").forward(request, response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}