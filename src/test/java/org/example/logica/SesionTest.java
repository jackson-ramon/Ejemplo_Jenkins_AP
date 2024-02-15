package org.example.logica;

import org.junit.Test;

import static org.junit.Assert.*;

public class SesionTest {
    @Test
    public void given_the_credentials_when_login_then_ok(){
        Sesion s = new Sesion();
        assertEquals("admin",s.validarSesion("admin","admin123"));
    }
}