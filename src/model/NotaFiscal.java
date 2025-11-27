package model;

public class NotaFiscal {

    private static int contador = 1;

    public static String gerar(Venda venda) {
        StringBuilder json = new StringBuilder();

        json.append("{\n");
        json.append("  \"numeroNota\": ").append(contador++).append(",\n");
        json.append("  \"cliente\": \"").append(venda.getCliente().getNome()).append("\",\n");
        json.append("  \"funcionario\": \"").append(venda.getFuncionario().getNome()).append("\",\n");
        json.append("  \"itens\": [\n");

        for (int i = 0; i < venda.getItens().size(); i++) {
            ItemVenda item = venda.getItens().get(i);

            json.append("    {\n");
            json.append("      \"produto\": \"").append(item.getProduto().getNome()).append("\",\n");
            json.append("      \"quantidade\": ").append(item.getQuantidade()).append(",\n");
            json.append("      \"subtotal\": ").append(item.getSubtotal()).append("\n");
            json.append("    }");

            // add vírgula
            if (i < venda.getItens().size() - 1) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append("  ],\n");
        json.append("  \"total\": ").append(venda.getTotal()).append("\n");
        json.append("}");

        return json.toString();
    }
}
