package model;

    public class Funcionario {
        String nome;
        String cargo;
        Double salario;

        // Construtor
        public Funcionario(String nome, String cargo, double salario) {
            this.nome = nome;
            this.cargo = cargo;
            this.salario = salario;
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public String getCargo() {
            return cargo;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }
    }

