package br.com.univille.app;

import java.util.Calendar;

import br.com.univille.db.TarefaDAO;
import br.com.univille.db.UsuarioDAO;
import br.com.univille.entity.Tarefa;
import br.com.univille.entity.Usuario;

public class Main {

	public static void main(String[] args) throws Exception {
		TarefaDAO tarefaDao = new TarefaDAO();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		// Adicionando usuário
		Usuario user = new Usuario();
		user.setNome("Matheus");
		user.setLogin("matheus");
		user.setSenha("fdgfga");
		user.setEmail("matheus@univille.br");
		user.setAtivo(true);
		
		int idUser = usuarioDao.insert(user);
		
		// Adicionando tarefa
		Tarefa t = new Tarefa();
		t.setTitulo("TESTE");
		t.setDescricao("TESTE DESC11");
		t.setRealizada(true);
		Calendar c = Calendar.getInstance();
		c.set(2019, 6, 20);
		t.setData(c.getTime());
		t.setPrioridade(3);
		t.setUsuario_id(idUser);
		
		int idTarefa = tarefaDao.insert(t);
		t.setId(idTarefa);
		
		// Mostamos o estado atual das tarefas
		System.out.println(tarefaDao.getById(idTarefa));
		
		
		// Atualizamos a tarefa
		t.setDescricao("Trabalho POO44");
		tarefaDao.update(t);
		
		// Mostamos o estado atual das tarefas
		System.out.println(tarefaDao.getAll());
	}

}
