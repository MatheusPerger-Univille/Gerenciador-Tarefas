package br.com.univille.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.univille.entity.Tarefa;
import br.com.univille.exception.MyException;

public class TarefaDAO extends DAO {

	public int insert(Tarefa tarefa) throws Exception {

		String sql = " INSERT INTO tarefa(titulo, descricao, realizada, data, prioridade, usuario_id) VALUES(?,?,?,?,?,?)";
		
		try (Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, tarefa.getTitulo());
			statement.setString(2, tarefa.getDescricao());
			statement.setBoolean(3, tarefa.isRealizada());
			statement.setDate(4, new java.sql.Date(tarefa.getData().getTime()));
			statement.setInt(5, tarefa.getPrioridade());
			statement.setInt(6, tarefa.getUsuario_id());
			statement.execute();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs != null) { while(rs.next()) { return rs.getInt(1); } }
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao cadastrar uma tarefa: " + e.getMessage());
		}
		
		return 0;
	}
	
	public int update(Tarefa tarefa) throws Exception {
		String sql = " UPDATE tarefa SET titulo = ?, descricao = ?, realizada = ?, data = ?, prioridade = ? WHERE id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, tarefa.getTitulo());
			statement.setString(2, tarefa.getDescricao());
			statement.setBoolean(3, tarefa.isRealizada());
			statement.setDate(4, new java.sql.Date(tarefa.getData().getTime()));
			statement.setInt(5, tarefa.getPrioridade());
			statement.setInt(6, tarefa.getId());
			statement.execute();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs != null) { while(rs.next()) { return rs.getInt(1); } }
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao atualizar uma tarefa: " + e.getMessage());
		}
		
		return 0;
	}
	
	public void delete(Tarefa tarefa) throws Exception {
		
		String sql = " DELETE FROM tarefa WHERE id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, tarefa.getId());
			statement.execute();
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao deletar uma tarefa: " + e.getMessage());
		}
	}
	
	public Tarefa getById(int id) throws Exception {
		Tarefa tarefa = null;
		String sql = " SELECT id, titulo, descricao, realizada, data, prioridade, usuario_id FROM tarefa WHERE id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt(1));
				tarefa.setTitulo(resultSet.getString(2));
				tarefa.setDescricao(resultSet.getString(3));
				tarefa.setRealizada(resultSet.getBoolean(4));
				tarefa.setData(resultSet.getDate(5));
				tarefa.setPrioridade(resultSet.getInt(6));
				tarefa.setUsuario_id(resultSet.getInt(7));
			}
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao consultar uma tarefa: " + e.getMessage());
		}
		return tarefa;
	}
	
	public List<Tarefa> getAll() throws Exception {
		List<Tarefa> list = new ArrayList<>();
		String sql = " SELECT id, titulo, descricao, realizada, data, prioridade, usuario_id FROM tarefa";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getInt(1));
				tarefa.setTitulo(resultSet.getString(2));
				tarefa.setDescricao(resultSet.getString(3));
				tarefa.setRealizada(resultSet.getBoolean(4));
				tarefa.setData(resultSet.getDate(5));
				tarefa.setPrioridade(resultSet.getInt(6));
				tarefa.setUsuario_id(resultSet.getInt(7));
				
				list.add(tarefa);
			}
		}catch(Exception e) {
			throw new MyException("O seguinte erro ocorreu ao consultar todas as tarefas: " + e.getMessage());
		}
		return list;
	}
}
