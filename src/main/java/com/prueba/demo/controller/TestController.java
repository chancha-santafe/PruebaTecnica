package com.prueba.demo.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.demo.controller.service.TestService;
import com.prueba.demo.model.Input;


/**
 * 
 * @author User.
 * API REST que tambien resuelve las consignas.
 *
 */
@RestController
@RequestMapping("/api")
public class TestController {

  @Autowired
  TestService testService;

  private Input input;

  @PostConstruct
  public void TestControllerInit() {
    input = new Input();
  }

  /**
   * Metodo para cargar los numeros.
   * 
   * @param input
   * @return {@link String}
   */
  @GetMapping("/loadList")
  public String getImput(@RequestBody Input input) {
    this.input.getListNumber().addAll(input.getListNumber());
    return this.input.getListNumber().toString();
  }


  /**
   * Metodo que nos devuelve el valor de la operacion sobre la lista de numeros.
   * 
   * @param operation
   * @return {@link Integer}
   */
  @GetMapping("/operation/{operation}")
  public Integer sendOperation(@PathVariable String operation) {
    return testService.calculate(operation, input);
  }


}
