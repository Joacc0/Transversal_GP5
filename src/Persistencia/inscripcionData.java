package Persistencia;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import Vistas.VistaInscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class inscripcionData {
    private Connection con = null;

    public inscripcionData() {
        con = Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) "
                + "VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se ha creado la inscripcion");
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
    }
    
    public void actualizarNota(int idAlumno,int idMateria,double nota){
        String sql = "UPDATE inscripcion SET nota = ?"
                + "WHERE idMateria = ? AND idAlumno = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2,idMateria);
            ps.setInt(3,idAlumno);
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado la nota");
            }
            ps.close();
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> inscripciones = new ArrayList<>();
        alumnoData alumData = new alumnoData();
        materiaData matData = new materiaData();
        String sql = "SELECT * FROM inscripcion";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alum = alumData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alum);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            }
     
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return inscripciones;
    }
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        alumnoData alumData = new alumnoData();
        materiaData matData = new materiaData();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alum = alumData.buscarAlumno(id);
                Materia mat = matData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alum);
                insc.setMateria(mat);
                insc.setNota(rs.getInt("nota"));
                inscripciones.add(insc);
            }
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return inscripciones;
    }
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno){
        List<Materia> materias = new ArrayList<>();
        
        String sql = "SELECT materia.* FROM `materia` JOIN inscripcion "
                + " ON materia.idMateria = inscripcion.idMateria "
                + " WHERE inscripcion.idAlumno = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("año"));
                mat.setEstado(rs.getBoolean("estado"));
                materias.add(mat);
            }   
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return materias;
    }
    
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno){
        List<Materia> materias = new ArrayList<>();
        
        String sql = "SELECT materia.* FROM materia "
               + "LEFT JOIN inscripcion ON materia.idMateria = inscripcion.idMateria "
               + "AND inscripcion.idAlumno = ? "
               + "WHERE inscripcion.idAlumno IS NULL";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("año"));
                mat.setEstado(rs.getBoolean("estado"));
                materias.add(mat);
            }   
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return materias;
    }
    
    public List<Alumno> obtenerAlumnosPorMateria(int idMateria){
        List<Alumno> alumnos = new ArrayList<>();
        
        String sql = "SELECT alumno.* FROM `alumno` "
                + "JOIN inscripcion ON alumno.idAlumno = inscripcion.idAlumno "
                + "WHERE inscripcion.idMateria = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alum = new Alumno();
                alum.setIdAlumno(rs.getInt("idAlumno"));
                alum.setDni(rs.getInt("dni"));
                alum.setApellido(rs.getString("apellido"));
                alum.setNombre(rs.getString("nombre"));
                alum.setFecha(rs.getDate("fechaNac").toLocalDate());
                alum.setEstado(rs.getBoolean("estado"));
                alumnos.add(alum);
            }
            
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
        return alumnos;
    }
    
    public void eliminarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        String sql = "DELETE FROM `inscripcion` WHERE idAlumno = ? AND idMateria = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente la inscripcion");
            }
        }catch(SQLException ex){
            System.out.println("Error al acceder a la tabla, Error: " + ex);
        }
    }
}
