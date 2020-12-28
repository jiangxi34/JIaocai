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


@WebServlet(name = "XiugaiYhServelt", urlPatterns = "/XiugaiYhServelt")
public class XiugaiYhServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        Yhmodel yhmodel = new Yhmodel();
        yhmodel.setId(Integer.parseInt(request.getParameter("admin")));
        yhmodel.setName(request.getParameter("name"));
        yhmodel.setMm(request.getParameter("mm"));
        yhmodel.setSex(new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8"));
        yhmodel.setSh(new String(request.getParameter("sh").getBytes("iso-8859-1"), "utf-8"));
        yhmodel.setSjh(request.getParameter("sjh"));
        yhmodel.setZhye(Integer.parseInt(request.getParameter("zhye")));
        JiaoCai dao = new JiaoCaiImpl();
        dao.XiugaiYh(yhmodel);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

