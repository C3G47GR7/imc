package com.softwarenlinea.imc.repository;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.softwarenlinea.imc.CallbackFirestore;
import com.softwarenlinea.imc.model.Persona;

public class ImcRepositoryImp implements ImcRepository {
    final static String COLLECTION = "ImcPersonas";
    FirebaseFirestore db = FirebaseFirestore.getInstance();




    @Override
    public void crear(Persona persona, CallbackFirestore callback) {
        db.collection(COLLECTION)
                .document(persona.getReference())
                .set(persona.getMap())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        callback.onSuccess(persona);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public void actualizar(Persona persona, CallbackFirestore callback) {
        db.collection(COLLECTION)
                .document(persona.getReference())
                .update(persona.getMap())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        callback.onSuccess(persona);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public void eliminar(String reference, CallbackFirestore callback) {
        db.collection(COLLECTION)
                .document(reference)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        callback.onSuccess(null);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        callback.onFailure(e);
                    }
                });
    }
    @Override
    public void consultarTodos(CallbackFirestore callback) {
        db.collection(COLLECTION)
                .get()//trae la consulta de toda la coleccion
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            callback.onSuccess(task.getResult().getDocuments());
                        }else{
                            callback.onFailure(null);
                        }
                    }
                });
    }

    @Override
    public void consultarDocumentos(String reference, CallbackFirestore callback) {
        db.collection(COLLECTION)
                .document(reference)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            callback.onSuccess(task.getResult());
                        }else{
                            callback.onFailure(reference);
                        }
                    }
                });
    }

    @Override
    public void consultarDocumentosPorClasificacion(String clasificacion, CallbackFirestore callback) {
        db.collection(COLLECTION)
                .whereEqualTo("clasificacion", clasificacion)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            callback.onSuccess(task.getResult().getDocuments());
                        } else {
                            callback.onFailure(null);
                        }
                    }
                });
    }
}
