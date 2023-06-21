package model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Carro> carros;

    public Estoque() {
        carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public void removerCarro(Carro carro) {
        carros.remove(carro);
    }

    public List<Carro> getCarrosDisponiveis() {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getQuantidadeEmEstoque() > 0) {
                carrosDisponiveis.add(carro);
            }
        }
        return carrosDisponiveis;
    }

    public List<Carro> getCarros() {
        return carros;
    }
}

