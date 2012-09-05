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

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String q = request.getParameter("status");
    if (q == null) q = "200";
    response.setStatus(Integer.parseInt(q));
    response.setContentType("text/html");
    PrintWriter w = response.getWriter();
    w.write(getPage(q));
  }

  String getPage(String status) {
    return wrap("html",
      wrap("head", 
        wrap("title", "Http Status Generator"))
    + wrap("body",
        wrap("h1", "Http Status Generator")
      + wrap("form", "Status <input value=\"" + status + "\" size=\"5\" name=\"status\" />")
      + wrap("p", "<a href='https://github.com/timp21337/http-status-generator'>github</a>")
      ));
  }

  private String wrap(String tag, String content) { 
    return "<" + tag + ">" + content + "</" + tag + ">" + "\n";  
  }
}
