package net.pizey.generator;

import junit.framework.TestCase;

public class HttpStatusTest extends TestCase {

  public void testGetPage() {
    assertEquals("<html><head><title>Htpp Status Generator</title>\n"
        + "</head>\n" + "<body><h1>Htpp Status Generator</h1>\n"
        + "<form>Status <input value=\"200\" name=\"status\" /></form>\n"
        + "</body>\n" + "</html>\n", new HttpStatus().getPage());
  }

}
