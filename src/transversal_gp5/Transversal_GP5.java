package transversal_gp5;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import Persistencia.alumnoData;
import Persistencia.materiaData;
import Vistas.Menu;
import java.time.LocalDate;

public class Transversal_GP5 {

    public static void main(String[] args) {
        
//        alumnoData controlAlumno = new alumnoData();
//        Alumno alumno1 = new Alumno(1,123,"Arrieta","Fer",LocalDate.of(1989,10,04),true);
//        Alumno alumno2 = new Alumno(2,124,"Lucero","Joaco",LocalDate.of(2002,10,21),true);
//        
//        Materia mat1 = new Materia(1,"Matematica",2,true);
//        
//        materiaData controlMateria = new materiaData();
//        
//        Inscripcion insc1 = new Inscripcion(alumno2,mat1,7.5);
//        
        Materia mat2 = new Materia(2,"Algoritmos",2,true);
        Materia mat3 = new Materia(3,"Web",1,true);
//        
//         Inscripcion insc2 = new Inscripcion(alumno1,mat2,9);
//         Inscripcion insc3 = new Inscripcion(alumno1,mat3,8);
         
         Menu m1 = new Menu();
         m1.setVisible(true);
         
    }
    
}
