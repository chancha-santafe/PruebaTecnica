package com.prueba.demo.controller.service;

import org.springframework.stereotype.Service;
import com.prueba.demo.model.Input;
import com.prueba.demo.model.util.UtilConstant;

@Service
public class TestServiceImpl implements TestService {

  /**
   * 
   * Metodo que hace el calculo.
   * 
   * @param operation, {@link Input}
   * @return {@link Integer}
   */
  public Integer calculate(String operation, Input input) {
    Integer result = 0;
    if (validate(operation)) {
      if (UtilConstant.SUM.equals(operation)) {
        return input.getListNumber().stream().mapToInt(a -> a).sum();
      }

      if (UtilConstant.MULTIPLICATION.equals(operation)) {
        if (input.getListNumber().size() == 0) {
          return 0;
        }
        return input.getListNumber().stream().mapToInt(x -> x).reduce(1, Math::multiplyExact);
      }

      if (UtilConstant.SUBTRACTION.equals(operation)) {
        if (input.getListNumber().size() > 0) {
          if (input.getListNumber().size() == 2) {
            return input.getListNumber().get(0) - input.getListNumber().get(1);
          }
          result = input.getListNumber().get(0);
          for (int i = 1; i < input.getListNumber().size(); i++) {
            result = result - (input.getListNumber().get(i));
          }
        }
      }

      if (UtilConstant.DIVISION.equals(operation)) {
        if (input.getListNumber().size() > 0) {
          result = input.getListNumber().get(0);
          for (int i = 1; i < input.getListNumber().size(); i++) {
            result = result / input.getListNumber().get(i);
          }
        }
      }

      input = new Input();
    }
    return result;

  }

  /**
   * 
   * Metodo que nos valida que el usuario haya ingresado una operacion valida
   * 
   * @param operation
   * @return {@link Boolean}
   */
  private boolean validate(String operation) {
    boolean result = false;

    if (UtilConstant.SUM.equals(operation) || UtilConstant.DIVISION.equals(operation)
        || UtilConstant.MULTIPLICATION.equals(operation)
        || UtilConstant.SUBTRACTION.equals(operation)) {
      result = true;
    }

    return result;
  }

}
