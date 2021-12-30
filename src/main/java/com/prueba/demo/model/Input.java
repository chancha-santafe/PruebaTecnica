package com.prueba.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Serrano Avila.
 * Clase que nos modela la lista de elementos que vamos a guardar para Operar.
 *
 */
public class Input implements Serializable {

  private static final long serialVersionUID = 1L;
  private List<Integer> listNumber;

  public Input() {
    listNumber = new ArrayList<Integer>();
  }

  public List<Integer> getListNumber() {
    return listNumber;
  }

  public void setListNumber(List<Integer> listNumber) {
    this.listNumber = listNumber;
  }

}
