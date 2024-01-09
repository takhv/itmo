import listOfDots.Dots;
import listOfDots.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    public Dots dots = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем параметры из запроса
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String radiusParam = request.getParameter("radius");
        double x = Double.parseDouble(xParam);
        double y = Double.parseDouble(yParam);
        double r = Double.parseDouble(radiusParam);

        HttpSession session = request.getSession();
        if(session.getAttribute("dots") == null) {
            dots = new Dots();
        } else {
            dots = (Dots)session.getAttribute("dots");
        }

        // Ваш код для проверки попадания точки в область
        if((x <= 0 && y >= 0 && 2*x + y <= r) ||
            (x <= 0 && y <= 0 && y <= (-1)*r && x <= (-1)*r/2) ||
            (x >= 0 && y <= 0 && (x*x + y*y) <= (r*r)/4)) {
            dots.setPoint(new Result(x,y,r,"Есть пробитие!"));
        } else {
            dots.setPoint(new Result(x,y,r,"Рикошет"));
        }

        // Передаем управление JSP-странице для формирования HTML-страницы с результатами
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
