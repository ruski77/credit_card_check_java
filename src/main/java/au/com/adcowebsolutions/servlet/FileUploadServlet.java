package au.com.adcowebsolutions.servlet;

import com.adcowebsolutions.CardType;
import com.adcowebsolutions.CardValidator;
import com.adcowebsolutions.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: russell
 * Date: 27/11/2013
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/fileUpload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    public FileUploadServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html><html><head><title>Credit Cards</title></head>");
        out.write("<body>");
        out.write("<h2>Credit Card Output</h2>");
        out.write("<table id='cards'>");

        for (Part part : request.getParts()) {
            InputStream is = request.getPart(part.getName()).getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ( (line = br.readLine()) != null) {
                out.write("<tr><td>" + CardType.determineCardType(line) + ": </td><td>" + StringUtils.removeWhiteSpace(line) + "</td><td> (" + CardValidator.validate(line) + ") </td></tr>");
            }

            br.close();
            is.close();
        }

        out.write("</table>");
        out.write("</body>");
        out.write("</html>");

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
