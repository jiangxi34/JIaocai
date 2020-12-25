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

@WebServlet(name = "DengServlet", urlPatterns = "/DengServlet")
public class DengServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String account = request.getParameter("name");
        String password = request.getParameter("password");
        // 验证
        JiaoCai dao = new JiaoCaiImpl();
        int id = dao.getAdmin(account, password);
        if (id!=0) {  //成功
            HttpSession session = request.getSession();  //通过request获取session
            session.setAttribute("id", id); // 将管理员信息保存在Session中（向其它页面共享数据）
            response.sendRedirect("index.jsp"); // 重置页面（前转）：首面
        } else { //失败
            request.setAttribute("error", "账户或密码错误！");
            request.getRequestDispatcher("index.jsp").forward(request, response); // 前面页面：登陆页面
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}