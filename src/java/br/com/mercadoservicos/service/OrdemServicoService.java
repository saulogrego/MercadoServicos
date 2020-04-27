package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.OrdemServicoDao;
import br.com.mercadoservicos.domain.OrdemServico;
import java.util.Date;
import java.util.List;

public class OrdemServicoService {
    
    private OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
    
    public List<OrdemServico> listar(){
        return ordemServicoDao.listar();
    }
    
    public OrdemServico consultar(Integer id){
        return ordemServicoDao.consultar(id);
    }
    
    public boolean inserir(OrdemServico ordemServico){
        ordemServico.setDataHora(new Date());
        return ordemServicoDao.inserir(ordemServico);
    }
    
    public boolean alterar(OrdemServico ordemServico){
        return ordemServicoDao.alterar(ordemServico);
    }
    
    public boolean excluir(OrdemServico ordemServico){
        return ordemServicoDao.excluir(ordemServico);
    }
}
