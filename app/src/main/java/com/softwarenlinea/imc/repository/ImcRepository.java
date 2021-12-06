package com.softwarenlinea.imc.repository;

import com.softwarenlinea.imc.CallbackFirestore;
import com.softwarenlinea.imc.model.Persona;

public interface ImcRepository {
    public void crear (Persona persona, CallbackFirestore callback);
    public void actualizar(Persona persona, CallbackFirestore callback);
    public void eliminar( String reference, CallbackFirestore callback);
    public void consultarTodos( CallbackFirestore callback);
    public void consultarDocumentos(String reference, CallbackFirestore callback);
    public void consultarDocumentosPorClasificacion(String clasificacion, CallbackFirestore callback);
}
