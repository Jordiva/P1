package org.milaifontanals;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import p_interficiepersistencia.GestorBDExceptionTOT;
import p_interficiepersistencia.IGestorBDWiki;

/**
 *
 * @author isard
 */
final public class BDGeneral implements IGestorBDWiki{

    private static Connection conn;

    private BDGeneral() throws GestorBDExceptionTOT {
        this("Oracle.properties");
    }

    public BDGeneral(String nomFitxerPropietats) throws GestorBDExceptionTOT {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new GestorBDExceptionTOT("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            conn = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            conn.setAutoCommit(false);
        } catch (IOException ex) {
            throw new GestorBDExceptionTOT("Problemes en recuperar l'arxiu de configuració " + nomFitxerPropietats + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("No es pot establir la connexió.\n" + ex.getMessage());
        }
    }

    public static Connection getConnection() throws GestorBDExceptionTOT {
        if (conn == null) {
            new BDGeneral();
        }
        return conn;
    }

    public void tancar() throws GestorBDExceptionTOT {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new GestorBDExceptionTOT("Error en fer rollback final.\n" + ex.getMessage());
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new GestorBDExceptionTOT("Error en tancar la connexió.\n" + ex.getMessage());
            }
        }
    }

    public void validarCanvis() throws GestorBDExceptionTOT {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en validar els canvis: " + ex.getMessage());
        }
    }

    public void desferCanvis() throws GestorBDExceptionTOT {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en desfer els canvis: " + ex.getMessage());
        }
    }

    public Boolean validarLogn(String login, String password) throws GestorBDExceptionTOT {
        
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM USUARI WHERE LOGIN = ? AND contrasenya = ?");
            ps.setString(1, login);
            ps.setString(2, password);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            return rs.next();
            
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en validar els canvis: " + ex.getMessage());
        } 
    }

    @Override
    public List<Ruta> getRutesDelUsuari(String loginUsuari) throws GestorBDExceptionTOT, ExceptionTOT {
        List <Ruta> rr = new ArrayList<Ruta>();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM RUTA WHERE USU_LOGIN = ?");
            ps.setString(1, loginUsuari);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_RUTA");
                String usuari = rs.getString("USU_LOGIN");
                String titol = rs.getString("TITOL");
                String descripcio = rs.getString("DESCRIPCIO");
                Clob text = rs.getClob("TEXT");
                int distancia = rs.getInt("DISTANCIA");
                int temps = rs.getInt("TEMPS");
                int desnivellPositiu = rs.getInt("DESNIVELL_POSITIU");
                int desnivellNegatiu = rs.getInt("DESNIVELL_NEGATIU");
                int dificultat = rs.getInt("DIFICULTAT");
                int numPersones = rs.getInt("NUM_PERSONES");
                int sumaValoracions = rs.getInt("SUMA_VALORACIONS");
                int numPersonesFetRuta = rs.getInt("NUM_PERSONES_FET_RUTA");
                int sumaValoracioSeguretat = rs.getInt("SUMA_VALORACION_SAGURETAT");
                int sumaValoracioPaisatge = rs.getInt("SUMA_VALORACIO_PAISATGE");
                Timestamp datacreacio = rs.getTimestamp("MOMENT_TEMP");

                rr.add(new Ruta( id,  usuari,  titol,  descripcio,  text,  distancia,  temps,
                         desnivellPositiu,  desnivellNegatiu,  dificultat,  numPersones,  sumaValoracions,
                         numPersonesFetRuta,  sumaValoracioSeguretat,  sumaValoracioPaisatge,datacreacio));
            }
            
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en Recuperar els valors del usuari de les Rutes: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
        return rr;
    }

    @Override
    public List<Punts> getPuntsDeLaRutaDelUsuari(int id_Ruta) throws GestorBDExceptionTOT, ExceptionTOT {
        
        List <Punts> pp = new ArrayList<Punts>();
        PreparedStatement ps = null;
        try {
            
            ps = conn.prepareStatement("SELECT * FROM PUNT WHERE ID_RUTA = ?");
            ps.setInt(1, id_Ruta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numPunt = rs.getInt("NUM_PUNT");
                int id_ruta = rs.getInt("ID_RUTA");
                int id_tipus = rs.getInt("ID_TIPUS");
                String nom = rs.getString("NOM");
                String descripcio = rs.getString("DESCRIPCIO");
                //Clob foto = rs.getClob("FOTO");
                float latitud = rs.getFloat("LATITUD");
                float longitud = rs.getFloat("LONGITUD");
                float altitud = rs.getFloat("ALTITUD");
                

                pp.add(new Punts(numPunt, id_ruta, id_tipus, nom, descripcio, latitud, longitud, altitud));
            }

        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error en Recuperar els valors del usuari de les Rutes: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
        return pp;
    }




    @Override
    public boolean afagirRuta(Ruta ruta, String clob) throws GestorBDExceptionTOT, ExceptionTOT {
        
        PreparedStatement ps = null;

        try {
            Clob Clob = stringToClob( clob, conn);
            ps = conn.prepareStatement("INSERT INTO RUTA (usu_login, titol, descripcio, text, distancia, temps, desnivell_positiu, desnivell_negatiu, dificultat) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, ruta.getUsuari());
            ps.setString(2, ruta.getTitol());
            ps.setString(3, ruta.getDescripcio());
            ps.setClob(4, Clob);
            ps.setInt(5, ruta.getDistancia());
            ps.setInt(6, ruta.getTemps());
            ps.setInt(7, ruta.getDesnivellPositiu());
            ps.setInt(8, ruta.getDesnivellNegatiu());
            ps.setInt(9, ruta.getDificultat());
            
            if(ps.executeUpdate() == 1){
                return true;
            }                
            return false;

        } catch (SQLException | IOException e) {
            throw new GestorBDExceptionTOT("Error al Crear la ruta: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }


    


    @Override
    public boolean afagirPunt(Punts punt) throws GestorBDExceptionTOT, ExceptionTOT {

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO PUNT (id_ruta, id_tipus, nom, descripcio, latitud, longitud, altitud) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, punt.getId_ruta());
            ps.setInt(2, punt.getId_tipus());
            ps.setString(3, punt.getNom());
            ps.setString(4, punt.getDescripcio());
            ps.setFloat(5, punt.getLatitud());
            ps.setFloat(6, punt.getLongitud());
            ps.setFloat(7, punt.getAltitud());

            if(ps.executeUpdate() != 1){
                desferCanvis();
                return false;
            }                
            return true;

        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error al Crear la ruta: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }

    }

    private static Clob stringToClob(String data, Connection connection) throws SQLException, IOException {
        // Convertir la cadena a un objeto CLOB
        Clob clob = connection.createClob();
        clob.setString(1, data);
        return clob;
    }

    @Override
    public boolean modificarRuta(Ruta ruta,String txt) throws GestorBDExceptionTOT, ExceptionTOT {
        
        PreparedStatement ps = null;

        

        try {//componentes de ruta RUTA (usu_login, titol, descripcio, text, distancia, temps, desnivell_positiu, desnivell_negatiu, dificultat)
            ps = conn.prepareStatement("UPDATE RUTA SET titol = ?, descripcio = ?, text = ?, distancia = ?, temps = ?, desnivell_positiu = ?, desnivell_negatiu = ?, dificultat = ? WHERE id_ruta = ?");
            

            String titol = ruta.getTitol();
            String desc = ruta.getDescripcio();
            Clob clob = stringToClob( txt, conn);
            int dist = ruta.getDistancia();
            int teps = ruta.getTemps();
            int despo = ruta.getDesnivellPositiu();
            int desNo = ruta.getDesnivellNegatiu();
            int dif = ruta.getDificultat();
            int id_ruta = ruta.getId_Ruta();

            ps.setString(1, titol);
            ps.setString(2, desc);
            ps.setClob(3, clob);
            ps.setInt(4, dist);
            ps.setInt(5, teps);
            ps.setInt(6,despo);
            ps.setInt(7, desNo);
            ps.setInt(8, dif);
            ps.setInt(9, id_ruta);

            if(ps.executeUpdate() == 1){
                return true;
            }                

        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error al Modificar una ruta: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
    return false;

    }

    @Override
    public List<Tipus> geTipusllista() throws GestorBDExceptionTOT, ExceptionTOT {
        List <Tipus> tt = new ArrayList<Tipus>();
        Statement ps = null;
        try {
            
            ps = conn.createStatement();
            
            ResultSet rs = ps.executeQuery("SELECT id_tipus , nom FROM TIPUS");
            while(rs.next()) {
                int id = rs.getInt("ID_TIPUS");
                String nom = rs.getString("NOM");

                tt.add(new Tipus(id, nom));
            }
            
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en Recuperar els valors del usuari de les Rutes: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
        return tt;
    }

    @Override
    public boolean borraRuta(int idRuta, String usuari) throws GestorBDExceptionTOT, ExceptionTOT {

        PreparedStatement ps = null;

        try {
            //borrar puntos 
            ps = conn.prepareStatement("DELETE FROM PUNT WHERE id_ruta = ?");
            ps.setInt(1, idRuta);

            ps.executeUpdate(); 
            ps.close();



            //borar companys de comentaris 
            ps = conn.prepareStatement("DELETE FROM COMPANYS WHERE id_comentar = ? ");
            ps.setInt(1, idRuta);

            ps.executeUpdate();
            ps.close();


            //borrar comentaris 
            ps = conn.prepareStatement("DELETE FROM COMENTARI WHERE id_ruta = ?");
            ps.setInt(1, idRuta);

            ps.executeUpdate();

            ps.close();

            ps = conn.prepareStatement("DELETE FROM RUTA WHERE id_ruta = ? AND usu_login = ?");
            ps.setInt(1, idRuta);
            ps.setString(2, usuari);


            if(ps.executeUpdate() == 1){
                return true;
            }
            return false;

        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error al Borrar una ruta: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }

    @Override
    public boolean borraPunt(int idPunt, int id_ruta) throws GestorBDExceptionTOT, ExceptionTOT {
        
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM PUNT WHERE num_punt = ? AND id_ruta = ?");
            ps.setInt(1, idPunt);
            ps.setInt(2, id_ruta);

            if(ps.executeUpdate() != 1){
                desferCanvis();
                return false;
            }                
            return true;

        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error al Borrar una ruta: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
        
    }

    @Override
    public boolean modificarPunt(Punts punt) throws GestorBDExceptionTOT, ExceptionTOT {
        
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE PUNT SET id_tipus = ?, nom = ?, descripcio = ?, latitud = ?, longitud = ?, altitud = ? WHERE num_punt = ? AND id_ruta = ?");
            ps.setInt(1, punt.getId_tipus());
            ps.setString(2, punt.getNom());
            ps.setString(3, punt.getDescripcio());
            ps.setFloat(4, punt.getLatitud());
            ps.setFloat(5, punt.getLongitud());
            ps.setFloat(6, punt.getAltitud());
            ps.setInt(7, punt.getNumPunt());
            ps.setInt(8, punt.getId_ruta());

            if(ps.executeUpdate() != 1){
                desferCanvis();
                return false;
            }                
            return true;

        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error al Modificar una ruta: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }

    }


    public static String construirConsulta(String usuario, String titulo, String fechaInicio, String fechaFin) {
        StringBuilder consulta = new StringBuilder("SELECT * FROM ruta WHERE");

        if (Objects.isNull(usuario) || usuario.isEmpty()) {
            throw new IllegalArgumentException("El campo 'usuario' es obligatorio.");
        } else {
            consulta.append(" usu_login = '").append(usuario).append("'");
        }

        if (Objects.nonNull(titulo) && !titulo.isEmpty()) {
            consulta.append(" AND titol = '").append(titulo).append("'");
        }

        if (Objects.nonNull(fechaInicio) && !fechaInicio.isEmpty() && Objects.nonNull(fechaFin) && !fechaFin.isEmpty()) {
            consulta.append(" AND moment_temp BETWEEN '").append(fechaInicio).append("' AND '").append(fechaFin).append("'");
        } else if (Objects.nonNull(fechaInicio) && !fechaInicio.isEmpty()) {
            consulta.append(" AND moment_temp >= '").append(fechaInicio).append("'");
        } else if (Objects.nonNull(fechaFin) && !fechaFin.isEmpty()) {
            consulta.append(" AND moment_temp <= '").append(fechaFin).append("'");
        }

        return consulta.toString();
    }


    @Override
    public List<Ruta> getRutesFiltrades(String Titol, String data1, String data2, String usuario)
            throws GestorBDExceptionTOT, ExceptionTOT {
        List<Ruta> ruteList = new ArrayList<>();

        String consulta = construirConsulta(usuario,Titol, data1, data2);
        
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_RUTA");
                String usuari = rs.getString("USU_LOGIN");
                String titol = rs.getString("TITOL");
                String descripcio = rs.getString("DESCRIPCIO");
                Clob text = rs.getClob("TEXT");
                int distancia = rs.getInt("DISTANCIA");
                int temps = rs.getInt("TEMPS");
                int desnivellPositiu = rs.getInt("DESNIVELL_POSITIU");
                int desnivellNegatiu = rs.getInt("DESNIVELL_NEGATIU");
                int dificultat = rs.getInt("DIFICULTAT");
                int numPersones = rs.getInt("NUM_PERSONES");
                int sumaValoracions = rs.getInt("SUMA_VALORACIONS");
                int numPersonesFetRuta = rs.getInt("NUM_PERSONES_FET_RUTA");
                int sumaValoracioSeguretat = rs.getInt("SUMA_VALORACION_SAGURETAT");
                int sumaValoracioPaisatge = rs.getInt("SUMA_VALORACIO_PAISATGE");
                Timestamp datacreacio = rs.getTimestamp("MOMENT_TEMP");

                ruteList.add(new Ruta( id,  usuari,  titol,  descripcio,  text,  distancia,  temps,
                         desnivellPositiu,  desnivellNegatiu,  dificultat,  numPersones,  sumaValoracions,
                         numPersonesFetRuta,  sumaValoracioSeguretat,  sumaValoracioPaisatge,datacreacio));
            }
            return ruteList;
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en Recuperar els valors del usuari de les Rutes: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }

    @Override
    public List<Punts> getTotsPunts() throws GestorBDExceptionTOT, ExceptionTOT {
        List <Punts> pp = new ArrayList<Punts>();
        Statement ps = null;
        try {
            
            ps = conn.createStatement();
            
            ResultSet rs = ps.executeQuery("SELECT * FROM PUNT");
            while(rs.next()) {
                int numPunt = rs.getInt("NUM_PUNT");
                int id_ruta = rs.getInt("ID_RUTA");
                int id_tipus = rs.getInt("ID_TIPUS");
                String nom = rs.getString("NOM");
                String descripcio = rs.getString("DESCRIPCIO");
                //Clob foto = rs.getClob("FOTO");
                float latitud = rs.getFloat("LATITUD");
                float longitud = rs.getFloat("LONGITUD");
                float altitud = rs.getFloat("ALTITUD");
                

                pp.add(new Punts(numPunt, id_ruta, id_tipus, nom, descripcio, latitud, longitud, altitud));
            }
            
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en Recuperar els valors del usuari de les Rutes: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en tancar el PreparedStatement: " + ex.getMessage());
                }
            }
        }
        return pp;

    }
    
  


    

 
}



