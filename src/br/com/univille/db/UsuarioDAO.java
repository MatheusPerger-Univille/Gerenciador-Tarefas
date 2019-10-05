package br.com.univille.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.univille.entity.Usuario;
import br.com.univille.exception.MyException;

public class UsuarioDAO extends DAO {

	public int insert(Usuario usuario) throws Exception {

		String sql = " INSERT INTO usuario(nome, email, login, senha, ativo) VALUES(?,?,?,?,?)";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getLogin());
			statement.setString(4, usuario.getSenha());
			statement.setBoolean(5, usuario.isAtivo());
			statement.execute();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs != null) { while(rs.next()) { return rs.getInt(1); } }
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao cadastrar o usuário: " + e.getMessage());
		}
		
		return 0;
	}
	
	public int update(Usuario usuario) throws Exception {
		String sql = " UPDATE usuario SET nome = ?, email = ?, login = ?, senha = ?, ativo = ? WHERE id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getLogin());
			statement.setString(4, usuario.getSenha());
			statement.setBoolean(5, usuario.isAtivo());
			statement.setInt(6, usuario.getId());
			statement.execute();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs != null) { while(rs.next()) { return rs.getInt(1); } }
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao atualizar o usuário: " + e.getMessage());
		}
		
		return 0;
	}
	
	public void delete(Usuario usuario) throws Exception {
		
		String sql = " DELETE FROM usuario WHERE id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, usuario.getId());
			statement.execute();
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao deletar o usuário: " + e.getMessage());
		}
	}
	
	public Usuario getById(int id) throws Exception {
		Usuario usuario = null;
		String sql = " SELECT id, nome, email, login, senha, ativo FROM usuario WHERE id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setEmail(resultSet.getString(3));
				usuario.setLogin(resultSet.getString(4));
				usuario.setSenha(resultSet.getString(5));
				usuario.setAtivo(resultSet.getBoolean(6));
			}
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao consultar o usuário: " + e.getMessage());
		}
		return usuario;
	}
	
	public List<Usuario> getAll() throws Exception {
		List<Usuario> list = new ArrayList<>();
		String sql = " select id, nome, sobrenome from usuario order by nome";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setEmail(resultSet.getString(3));
				usuario.setLogin(resultSet.getString(4));
				usuario.setSenha(resultSet.getString(5));
				usuario.setAtivo(resultSet.getBoolean(6));
				
				list.add(usuario);
			}
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao consultar todos os usuário: " + e.getMessage());
		}
		return list;
	}
}
