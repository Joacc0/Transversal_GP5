package Persistencia;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class alumnoData {
     private Connection con = null;

    public alumnoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) "
                + "VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFecha()));
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de alumnos");
        }
    }
    
    public void actualizarAlumno(Alumno alumno){
        try {
            String sql = "UPDATE alumno SET dni= ?,apellido= ?,nombre= ?,fechaNacimiento= ? "
                    + "WHERE id_alumno = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,alumno.getDni());
            ps.setString(2,alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFecha()));           
            ps.setInt(5, alumno.getIdAlumno());
            
            int fila = ps.executeUpdate();
            
            if (fila ==1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de alumnos");
        }  
    }
    
    public Alumno buscarAlumno(int id){
        Alumno alumno = null;
        try{
            String sql = "SELECT `dni`, `apellido`, `nombre`, `fechaNacimiento` FROM `alumno` WHERE id_alumno = ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecha(rs.getDate("fechaNacimietno").toLocalDate());
                alumno.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno con id: " + id);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No error al acceder a la tabla alumnos");
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        Alumno alumno = null;
        try{
            String sql = "SELECT `id_alumno`, dni, `apellido`, `nombre`, `fechaNacimiento` FROM `alumno` WHERE dni = ? AND estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,dni);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecha(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
            }else{
                JOptionPane.showMessageDialog(null,"No existe el alumno con dni: " + dni);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumnos");
        }
        return alumno;
    }
    
    public void eliminarAlumno(int id){
        try{
            String sql = "UPDATE alumno SET estado = 0 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas == 1) {
                System.out.println("Se ha eliminado el alumno");
            }
        }catch(SQLException e){
            System.out.println("");
        }
    }
    
      public List<Alumno> listarAlumnos(){
        List<Alumno> alumnos = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM `alumno` WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFecha((rs.getDate("fechaNacimiento").toLocalDate()));
                alumno.setEstado(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ ex.getMessage());
            
        }
        return alumnos;
        
    }
}
