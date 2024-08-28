package control;
import model.Imovel;

import java.util.ArrayList;
import java.util.List;

public class RepositorioImoveis {
    private List<Imovel> imoveis;

    // Construtor
    public RepositorioImoveis() {
        imoveis = new ArrayList<>();
    }

    // Métodos para gerenciar imóveis
    public void adicionarImovel(Imovel imovel) {
        imoveis.add(imovel);
    }

    public void removerImovel(int id) {
        imoveis.removeIf(imovel -> imovel.getId() == (id));
    }

    public Imovel buscarImovelPorId(int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == (id)) {
                return imovel;
            }
        }
        return null;
    }

    public List<Imovel> listarTodos() {
        return new ArrayList<>(imoveis);
    }
}

