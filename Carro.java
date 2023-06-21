package model;

public class Carro {
    public String marca;
    public String modelo;
    public int ano;
    public String cor;
    public double preco;
    public int quantidadeEmEstoque;

        public Carro(String marca, String modelo, int ano, String cor, double preco, int quantidadeEmEstoque) {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            this.cor = cor;
            this.preco = preco;
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }

    public Carro(int id, String marca, String modelo, int ano, String cor, double preco, int quantidadeEmEstoque) {
    }

    // Getters e setters

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public String getCor() {
            return cor;
        }

        public void setCor(String cor) {
            this.cor = cor;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public int getQuantidadeEmEstoque() {
            return quantidadeEmEstoque;
        }

        public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }

        // Método toString()

        @Override
        public String toString() {
            return "Carro{" +
                    "marca='" + marca + '\'' +
                    ", modelo='" + modelo + '\'' +
                    ", ano=" + ano +
                    ", cor='" + cor + '\'' +
                    ", preco=" + preco +
                    ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                    '}';
        }

    public int getCodigo() {
        return 0;
    }

    public int getId() {
        return 1;
    }
}


