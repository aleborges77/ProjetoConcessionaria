package model;

public enum MetodoPagamento {

        FINANCIAMENTO("Financiamento"),
        PAGAMENTO_A_VISTA("Pagamento à Vista");

        private String descricao;

        MetodoPagamento(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }


