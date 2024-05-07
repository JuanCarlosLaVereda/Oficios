package es.ieslavereda.oficios.repository.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Oficio {
    private int id;
    private String descripcion;
    private String image;
    private String imageURL;

    @Override
    public boolean equals(Object object){
        if (object == null || !(object instanceof Oficio)){
            return false;
        }

        Oficio oficio = (Oficio) object;

        return id == oficio.getId();
    }

    @Override
    public int hashCode(){
        return id;
    }
}
