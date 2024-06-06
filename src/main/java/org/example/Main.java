package org.example;


import org.example.ejercicio1.Persona;
import org.example.ejercicio1.PersonaDAO;
import org.example.ejercicio1.Telefono;

public class Main {
    public static void main(String args[]) {
        PersonaDAO dao = new PersonaDAO();
        Persona p = dao.personaPorId(1);
        System.out.println(p.nombre());
        for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
        }
    }
}