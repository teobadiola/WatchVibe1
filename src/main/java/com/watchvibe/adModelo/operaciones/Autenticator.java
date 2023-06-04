package com.watchvibe.adModelo.operaciones;

import com.watchvibe.adModelo.tablas.Usuarios;

public class Autenticator {
    private static Usuarios usuarioLogueado;

    public static void setUsuarioLogueado(Usuarios usuario) {
        usuarioLogueado = usuario;
    }

    public static Usuarios getUsuarioLogueado() {
        return usuarioLogueado;
    }
}
