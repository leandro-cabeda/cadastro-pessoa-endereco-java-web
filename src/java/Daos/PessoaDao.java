package Daos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.DaoGenerico;
import com.crud.pessoas.modelo.Pessoa;
import java.io.Serializable;


/**
 *
 * @author Leandro
 */
public class PessoaDao<T> extends DaoGenerico<Pessoa>  implements Serializable {

    public PessoaDao()
    {
        super();
        // define a classe persistente
        ClassePersistente=Pessoa.class;
        
        // define o atributo padrão ao inicializar da ordem
        ordem="nome";
    }

}
