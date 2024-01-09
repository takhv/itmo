import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем координаты точек и радиус из параметров запроса
        double x = Double.parseDouble(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double r = Double.parseDouble(request.getParameter("r"));

        // Проверяем попадание точки в область и передаем результат в атрибуты запроса
        boolean isInArea = checkArea(x, y, r);
        request.setAttribute("isInArea", isInArea);
        request.setAttribute("x", x);
        request.setAttribute("y", y);
        request.setAttribute("r", r);

        // Перенаправляем на JSP-страницу для отображения результатов
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private boolean checkArea(double x, double y, double r) {
        // Ваша логика проверки попадания точки в область
        // Верните true, если точка в области, и false в противном случае.
        // Например, проверка попадания в круг с радиусом r
        return x * x + y * y <= r * r;
    }
}
