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
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "DingDanServlet", urlPatterns = "/DingDanServlet")
public class DingDanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        if (request.getParameter("je")!=null && request.getParameter("admin")!=null&&request.getParameter("dd")!=null)
        {
            int zje = Integer.parseInt(request.getParameter("je"));
            int dd = Integer.parseInt(request.getParameter("dd"));

            Date date = new Date();
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
            String LgTime = sdformat.format(date);

            /*SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar= Calendar.getInstance();
            String date = sdFormat.format(calendar.getTime());*/

            int admin = Integer.parseInt(request.getParameter("admin"));
            JiaoCai dao = new JiaoCaiImpl();
            Yhmodel yhmodel=dao.getYh(admin);
            yhmodel.setZhye(yhmodel.getZhye()-zje);
            dao.XiugaiYh(yhmodel);
            dao.dd(zje,LgTime,admin,dd);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
