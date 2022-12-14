package com.java.InformacionPersonas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.InformacionPersonas.Conexion.Conexion;
import com.java.InformacionPersonas.modelo.Personas;

public class PersonaDAO {
private static Connection conexion;
	
	public static ArrayList<Personas> listarPersonas() throws SQLException{
		conexion= Conexion.getConexion();
		ArrayList<Personas> listado= new ArrayList<Personas>();
		String query= "SELECT * FROM persona";
		PreparedStatement ps=conexion.prepareStatement(query);
		ResultSet rs= ps.executeQuery(query);
		
		while(rs.next()) {
			listado.add(new Personas(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
		}
		
		
		return listado;
		
	}
}
