package org.example.ejercicio1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class ProxySet implements Set {
    private boolean telefonosCargados = false;
    private int id;
    private Set<Telefono> telefonos;

    public ProxySet(int id) {
        this.id = id;
        this.telefonos = new HashSet<>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (!telefonosCargados) {
            Set<Telefono> telefonosCargados =   new PersonaDAO().cargarTelefonos(id) ;
            this.telefonos.addAll(telefonosCargados);
            this.telefonosCargados = true;
        }
        return this.telefonos.toArray(new Telefono[0]);
    }
}