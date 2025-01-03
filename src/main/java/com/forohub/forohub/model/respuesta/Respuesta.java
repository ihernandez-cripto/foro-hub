package com.forohub.forohub.model.respuesta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Table(name = "respuesta")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String mensaje;
    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    String fechaCreacion;
    String solucion;
    Long usuarioId;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta){
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.solucion = datosRegistroRespuesta.respuesta();
        this.usuarioId = datosRegistroRespuesta.usuarioId();
    }

}
