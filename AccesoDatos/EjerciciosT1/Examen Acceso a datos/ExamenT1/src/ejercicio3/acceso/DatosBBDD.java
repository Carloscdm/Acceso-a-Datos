package ejercicio3.acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ejercicio3.model.Autor;
import ejercicio3.model.Libro;

public class DatosBBDD {
	
	private AccesoBBDD acceso;
	
	public DatosBBDD() {
		acceso = new AccesoBBDD();
	}
	
	public int insertarAutor(Autor au) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtS = null;
		ResultSet rslt = null;
		int id = 0;
		int numReg = 0;
		
		try {
			con = acceso.getConexion();
			
			String sql = "INSERT INTO AUTOR (NOMBRE, NACIONALIDAD) VALUES "
					+ "(?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, au.getNombre());
			pstmt.setString(2, au.getNacionalidad());
			
			numReg = pstmt.executeUpdate();
			
			if (numReg == 1) {
				sql = "SELECT ID_AUTOR FROM AUTOR WHERE NOMBRE = ?";
				pstmtS = con.prepareStatement(sql);
				
				pstmtS.setString(1, au.getNombre());
				
				rslt = pstmtS.executeQuery();
				
				if (rslt.next()) {
					id = rslt.getInt("ID_AUTOR");
				}
			}
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmtS != null) {
					pstmtS.close();
				}
				if (rslt != null) {
					rslt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return id;
	}
	
	public int insertarLibro(Libro lib) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int numReg = 0;
		
		try {
			con = acceso.getConexion();
			
			String sql = "INSERT INTO LIBRO (TITULO, NUM_PAGINAS, ANIO_EDIC, ID_AUTOR) VALUES "
					+ "(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, lib.getTitulo());
			pstmt.setInt(2, lib.getNumPag());
			pstmt.setInt(3, lib.getAnioEdic());
			pstmt.setInt(4, lib.getAutor().getId());
			
			numReg = pstmt.executeUpdate();
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				} 
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return numReg;
	}
	
	public ArrayList<Libro> getListadoLibros() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		Libro libro = null;
		Autor autor = null;
		try {
			con = acceso.getConexion();
			
			String sql = "SELECT L.ID_LIBRO, L.TITULO, L.NUM_PAGINAS, L.ANIO_EDIC, A.ID_AUTOR, A.NOMBRE, A.NACIONALIDAD " 
			+ " FROM LIBRO L, AUTOR A WHERE L.ID_AUTOR = A.ID_AUTOR ";
			pstmt = con.prepareStatement(sql);
			
			rslt = pstmt.executeQuery();
			
			while (rslt.next()) {
				libro = new Libro();
				libro.setId(rslt.getInt(1));
				libro.setTitulo(rslt.getString(2));
				libro.setNumPag(rslt.getInt(3));
				libro.setAnioEdic(rslt.getInt(4));
				autor = new Autor();
				autor.setId(rslt.getInt(5));
				autor.setNombre(rslt.getString(6));
				autor.setNacionalidad(rslt.getString(7));
				libro.setAutor(autor);
				
				listaLibros.add(libro);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				} 
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return listaLibros;
	}
	
	public ArrayList<Libro> getListadoLibrosG() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		Libro libro = null;
		Autor autor = null;
		try {
			con = acceso.getConexion();
			
			String sql = "SELECT L.ID_LIBRO, L.TITULO, L.NUM_PAGINAS, L.ANIO_EDIC, A.ID_AUTOR, A.NOMBRE, A.NACIONALIDAD " 
			+ " FROM LIBRO L, AUTOR A WHERE L.ID_AUTOR = A.ID_AUTOR AND L.NUM_PAGINAS > 600";
			pstmt = con.prepareStatement(sql);
			
			rslt = pstmt.executeQuery();
			
			while (rslt.next()) {
				libro = new Libro();
				libro.setId(rslt.getInt(1));
				libro.setTitulo(rslt.getString(2));
				libro.setNumPag(rslt.getInt(3));
				libro.setAnioEdic(rslt.getInt(4));
				autor = new Autor();
				autor.setId(rslt.getInt(5));
				autor.setNombre(rslt.getString(6));
				autor.setNacionalidad(rslt.getString(7));
				libro.setAutor(autor);
				
				listaLibros.add(libro);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				} 
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return listaLibros;
	}
	
	public Autor getAutorLibroMasPaginas() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		Autor autor = null;
		try {
			con = acceso.getConexion();
			
			String sql = "SELECT A.ID_AUTOR, A.NOMBRE, A.NACIONALIDAD, MAX(L.NUM_PAGINAS) " 
			+ " FROM AUTOR A, LIBRO L WHERE A.ID_AUTOR = L.ID_AUTOR ";
			pstmt = con.prepareStatement(sql);
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				autor = new Autor();
				autor.setId(rslt.getInt(1));
				autor.setNombre(rslt.getString(2));
				autor.setNacionalidad(rslt.getString(3));
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (pstmt != null) {
					pstmt.close();
				} 
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return autor;
	}
	
	
}
