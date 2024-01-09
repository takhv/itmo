import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.*;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем параметры из запроса
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String radiusParam = request.getParameter("radius");

        String regexX = "^-?([0-3](\\.[0-9]+)?|4(\\.0)?)$";
        boolean Xmatches = Pattern.matches(regexX, xParam);

        String regexY = "^-?([0-4](\\.[0-9]+)?|5(\\.0)?)$";
        boolean Ymatches = Pattern.matches(regexY, yParam);

        String regexR = "^[2-4](\\.[0-9]+)?$";
        boolean Rmatches = Pattern.matches(regexR, radiusParam);

        // Если есть параметры координат и радиуса, передаем на обработку AreaCheckServlet
        if (Xmatches && Ymatches && Rmatches) {
            request.getRequestDispatcher("/areaCheck").forward(request, response);
        } else {
            // Иначе, делегируем обработку JSP-страницы
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
}
