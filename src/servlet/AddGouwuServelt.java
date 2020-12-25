package servlet;
import dao.JiaoCai;
import dao.JiaoCaiImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddGouwuServelt", urlPatterns = "/AddGouwuServelt")
public class AddGouwuServelt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        int id = Integer.parseInt(request.getParameter("admin"));
        int j_id = Integer.parseInt(request.getParameter("j_id"));
        JiaoCai dao = new JiaoCaiImpl();
        int d_id = dao.byDd(id);
        dao.AddgGouwu(id,j_id,d_id);
        request.getRequestDispatcher("goods_cart.jsp").forward(request, response); // 前面页面：登陆页面
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
