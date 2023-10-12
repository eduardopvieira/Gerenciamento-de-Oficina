package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import Exceptions.AutenticationException;
import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.FuncionarioDAO;
import model.VO.Funcionario;
import model.VO.Gerente;

public class FuncionarioBO<VO extends Funcionario>  implements FuncionarioInterBO<VO>{

	@Override
	public <T extends Funcionario> T autenticar(VO vo) throws AutenticationException, InfoNaoCompativelException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet trabalhadorRS = funcDAO.buscar(vo);
	    try {
	        if (trabalhadorRS.next()) {
	            String senhaTrab = trabalhadorRS.getString("senha_func");
	            boolean isGerente = trabalhadorRS.getBoolean("isGerente");

	            if (vo.getSenha().equals(senhaTrab)) {
	                if (isGerente) {
	                    Gerente gerente = new Gerente();
	                    gerente.setCPF(vo.getCPF());
	                    gerente.setNome(trabalhadorRS.getString("nome_func"));
	                    gerente.setEndereco(trabalhadorRS.getString("endereco_func"));
	                    gerente.setIsGerente(true);
	                    
	                    return (T) gerente;
	                } else {
	                    Funcionario funcionario = new Funcionario();
	                    funcionario.setCPF(vo.getCPF());
	                    funcionario.setNome(trabalhadorRS.getString("nome_func"));
	                    funcionario.setEndereco(trabalhadorRS.getString("endereco_func"));
	                    funcionario.setIsGerente(false);
	                    return (T) funcionario;
	                }
	            } else {
	                throw new AutenticationException("Senha incorreta.");
	            }
	        } else {
	            throw new AutenticationException("CPF não cadastrado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new AutenticationException("Falha na autenticação.");
	    }
	}				
						
	@Override
	public void cadastrar(Funcionario vo) throws InsertException{
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet trabalhadorRS = funcDAO.buscar(vo);
		try {
			//encontrou usuario
			if(trabalhadorRS.next()) {
				throw new InsertException("CPF já cadastrado.");
			}
			else
			{
				funcDAO.inserir(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws InsertException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet retorno = funcDAO.listar();
		return retorno;
	}

	@Override
	public void alterar(VO vo) throws InsertException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		funcDAO.alterar(vo);		
	}

	@Override
	public void deletar(VO vo) throws InsertException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		funcDAO.deletar(vo);
	}

	@Override
	public ResultSet buscar(VO vo) throws NotFoundException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		return funcDAO.buscar(vo);
	}	
	
	public ResultSet buscarPorNome(VO vo) throws NotFoundException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		return funcDAO.buscarPorNome(vo);
		
	}
}