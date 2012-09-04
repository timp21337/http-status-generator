package net.pizey.generator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author timp
 * @since 4 Sep 2012
 *
 */
public class HttpStatus extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String q = request.getParameter("status");
    if (q != null) {
      response.setStatus(Integer.parseInt(q));
    }
    response.setContentType("text/html");
    PrintWriter w = response.getWriter();
    w.write(
      getPage()
        );
  }

  String getPage() {
    return wrap("html",
      wrap("head", 
        wrap("title", "Htpp Status Generator"))
    + wrap("body",
        wrap("h1", "Htpp Status Generator")
      + wrap("form", "Status <input value=\"200\" name=\"status\" />")));
  }

  private String wrap(String tag, String content) { 
    return "<" + tag + ">" + content + "</" + tag + ">" + "\n";  
  }
}
