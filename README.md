# 🛒 Sistema Loja Fácil – Java

Este projeto é um **sistema de vendas em Java** desenvolvido para fins acadêmicos, com o objetivo de aplicar os conceitos de **Programação Orientada a Objetos (POO)** e organização em camadas.

O sistema simula o funcionamento de uma loja, permitindo o gerenciamento de clientes, produtos e vendas através de um **menu interativo no console**.

---

## 🚀 Funcionalidades

✅ CRUD completo de Clientes  
✅ CRUD completo de Produtos  
✅ Módulo de Vendas  
✅ Atualização automática de estoque  
✅ Emissão de Nota Fiscal em formato JSON  
✅ Módulo de Atendimento ao Cliente (com Enum)  
✅ Módulo de Marketing  
✅ Menu interativo no console  
✅ Estrutura em camadas (model, service, controller)  

---

## 📁 Estrutura do Projeto

```text
src
 ├── controller
 │   ├── ClienteController.java
 │   └── ProdutoController.java
 │
 ├── service
 │   ├── ClienteService.java
 │   └── ProdutoService.java
 │
 ├── model
 │   ├── Pessoa.java
 │   ├── Cliente.java
 │   ├── Funcionario.java
 │   ├── Fornecedor.java
 │   ├── Produto.java
 │   ├── ItemVenda.java
 │   ├── Venda.java
 │   ├── NotaFiscal.java
 │   ├── Atendimento.java
 │   └── CampanhaMarketing.java
 │
 ├── enums
 │   └── StatusAtendimento.java
 │
 └── Main.java
▶️ Como executar o projeto
Abra o projeto no IntelliJ IDEA

Execute o arquivo Main.java

Use o menu no console para interagir com o sistema:

Cadastrar clientes

Cadastrar produtos

Listar, atualizar e deletar

Rodar a simulação completa (opção 9)

🖥️ Exemplo de saída (Nota Fiscal em JSON)
json
Copiar código
{
  "numeroNota": 1,
  "cliente": "sam",
  "funcionario": "João Vendedor",
  "itens": [
    {
      "produto": "papel",
      "quantidade": 3,
      "subtotal": 9.0
    },
    {
      "produto": "Produto Simulação",
      "quantidade": 1,
      "subtotal": 10.0
    }
  ],
  "total": 19.0
}
💡 Conceitos aplicados
Programação Orientada a Objetos (POO)

Herança (Pessoa → Cliente, Funcionario, Fornecedor)

Encapsulamento (getters e setters)

Abstração

Enum (StatusAtendimento)

Interface em camadas (Controller e Service)

CRUD em memória utilizando ArrayList

Menu interativo com Scanner

