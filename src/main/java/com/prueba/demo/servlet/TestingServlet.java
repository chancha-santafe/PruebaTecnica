package com.prueba.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.prueba.demo.controller.service.TestService;
import com.prueba.demo.model.Input;

/**
 * 
 * @author User. 
 * Servlet que nos resuelve las consignas.
 */
@WebServlet("/loadList")
public class TestingServlet extends HttpServlet {

  private static final long serialVersionUID = 155653574654132L;

  @Autowired
  TestService testService;

  private Input input;

  /**
   * Metodo que nos da como resultado la operacion que se ejecuta sobre la lista de numneros.
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.println("Resultado: " + testService.calculate(req.getParameter("operation"), input));
    input = new Input();

  }

  /**
   * Metodo que carga la lista de numeros.
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("post!");
    String[] list = req.getParameterValues("list");
    for (int i = 0; i < list.length; i++) {
      this.input.getListNumber().add(Integer.valueOf(list[i]));
    }
    PrintWriter out = resp.getWriter();
    out.println(input.getListNumber().toString());
  }

  @Override
  public void destroy() {
    System.out.println("¡Destruir!");
  }

  public TestingServlet() {
    System.out.println("¡Inicio!");
  }

  @Override
  public void init() throws ServletException {
    input = new Input();
    System.out.println("¡Inicializar!");
  }

}
