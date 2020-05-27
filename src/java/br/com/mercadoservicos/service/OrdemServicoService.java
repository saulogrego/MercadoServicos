package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.ItensOrdemServicoDao;
import br.com.mercadoservicos.dao.OrdemServicoDao;
import br.com.mercadoservicos.domain.ItensOrdemServico;
import br.com.mercadoservicos.domain.ItensOrdemServicoPk;
import br.com.mercadoservicos.domain.OrdemServico;
import java.util.Date;
import java.util.List;

public class OrdemServicoService {
    
    private OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
    private ItensOrdemServicoDao itensOrdemServicoDao = new ItensOrdemServicoDao();
    
    public List<OrdemServico> listar(){
        return ordemServicoDao.listar();
    }
    
    public OrdemServico consultar(Integer id){
        return ordemServicoDao.consultar(id);
    }
    
    public boolean inserir(OrdemServico ordemServico, List<ItensOrdemServico> itensOrdemServico){
        ordemServico.setDataHora(new Date());
        Integer id = ordemServicoDao.inserir(ordemServico);
        ordemServico = ordemServicoDao.consultar(id);
        int cont = 1;
        for (ItensOrdemServico item : itensOrdemServico){
            ItensOrdemServicoPk itemPk = new ItensOrdemServicoPk();
            itemPk.setOrdemServico(ordemServico);
            itemPk.setSequencia(cont);
            item.setItensOrdemServicoPk(itemPk);
            itensOrdemServicoDao.inserir(item);
            cont++;
        }
        return true;
    }
    
    public boolean alterar(OrdemServico ordemServico, List<ItensOrdemServico> itensOrdemServico){
        itensOrdemServicoDao.excluir(ordemServico);
        int cont = 1;
        for (ItensOrdemServico item : itensOrdemServico){
            ItensOrdemServicoPk itemPk = new ItensOrdemServicoPk();
            itemPk.setOrdemServico(ordemServico);
            itemPk.setSequencia(cont);
            item.setItensOrdemServicoPk(itemPk);
            itensOrdemServicoDao.inserir(item);
            cont++;
        }
        return ordemServicoDao.alterar(ordemServico);
    }
    
    public boolean excluir(OrdemServico ordemServico){
        return ordemServicoDao.excluir(ordemServico);
    }
    
    public List<ItensOrdemServico> listarItens(OrdemServico ordemServico){
        return itensOrdemServicoDao.listar(ordemServico);
    }
}
