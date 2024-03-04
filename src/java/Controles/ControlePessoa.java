/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;


import Daos.PessoaDao;
import Util.Util;
import com.crud.pessoas.modelo.Endereco;
import com.crud.pessoas.modelo.Pessoa;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Leandro
 */
@ManagedBean(name="controlepessoa")
@ViewScoped
public class ControlePessoa implements Serializable {
    
    private Pessoa pessoa;
    private PessoaDao<Pessoa> daoPessoa;
    private Endereco endereco;
    private Boolean novoEndereco;
    
    
    public ControlePessoa()
    {
        daoPessoa=new PessoaDao<>();
    }
    
    public void novoEndereco()
    {
        endereco=new Endereco();
        novoEndereco=true;
    }
    
    public void alterarEndereco(int index)
    {
        endereco=pessoa.getEndereços().get(index);
        novoEndereco=false;
    }
    
    public void salvarEndereco()
    {
        if(novoEndereco)
        {
            pessoa.adicionarEndereco(endereco);
        }
        Util.mensageminformacao("Endereço atualizado com sucesso!");
    }
    
    public void removerEndereco(int index)
    {
        pessoa.removerEndereco(index);
        Util.mensageminformacao("Endereço removido com sucesso!");
    }
    
    public String listar()
    {
        return "/privado/pessoa/listar?faces-redirect=true";
    }
    
    public void novo()
    {
        pessoa=new Pessoa();
        
    }
    
    public void salvar()
    {
        boolean persistiu=false;
        
        if(pessoa.getId()==null)
        {
            persistiu=daoPessoa.persist(pessoa);
        }
        else
        {
            persistiu=daoPessoa.merge(pessoa);
        }
        if(persistiu)
        {
            Util.mensageminformacao(daoPessoa.getMensagem());
        }
        else
        {
            Util.mensagemErro(daoPessoa.getMensagem());
        }
    }
    
    
    public void editar(Integer id)
    {
        pessoa=daoPessoa.localizar(id);
    }
    
    public void remover(Integer id)
    {
        pessoa=daoPessoa.localizar(id);
        if(daoPessoa.remove(pessoa))
        {
            Util.mensageminformacao(daoPessoa.getMensagem());
        }
        else
        {
            Util.mensagemErro(daoPessoa.getMensagem());
        }
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaDao<Pessoa> getDaoPessoa() {
        return daoPessoa;
    }

    public void setDaoPessoa(PessoaDao<Pessoa> daoPessoa) {
        this.daoPessoa = daoPessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getNovoEndereco() {
        return novoEndereco;
    }

    public void setNovoEndereco(Boolean novoEndereco) {
        this.novoEndereco = novoEndereco;
    }
    
}
