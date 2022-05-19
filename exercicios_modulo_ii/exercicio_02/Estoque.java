package exercicio_02;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    public String nome;
    private Long id;
    private List<Produto> produtosLista = new ArrayList<>();
    private static long geradorId = 0;

    public Estoque(){
        //void construct
    }

    public Estoque(String nome){
        this.id = incrementaGeradorId();
        this.nome = nome;
    }

    private static Long incrementaGeradorId (){
        return ++geradorId;
    }

    public void novoProduto (Produto produto){
        int idBusca = buscaProduto(produto.getNome(), produto.getMarca());
        if ( idBusca == -1){
            this.produtosLista.add(produto);
            System.out.println("Produto "+produto.getNome()+" adicionado!");
        } else {
            produtosLista.get(idBusca).incrementaEstoque(produto.getQuantidadeEstoque());
        }
    }

    private int buscaProduto (String nome, String marca){
        for (int i = 0; i < produtosLista.size(); i++){
            if ( produtosLista.get(i).getNome().equals(nome) && produtosLista.get(i).getMarca().equals(marca) ){
                return i;
            }
        }
        return -1;
    }

    public void listarProdutos(){
        if (produtosLista.isEmpty()){
            System.out.println("Não há produtos cadastrados no estoque "+this.nome);
        } else {
            for (Produto produtos : produtosLista){
                System.out.println(produtos.toString());
            }
        }
    }

    public void imprimeProduto(String nome, String marca){
        int idBusca = buscaProduto(nome, marca);
        if ( idBusca == -1){
            System.out.println("Produto não encontrado!");
        } else {
            System.out.printf("\n\n%s", produtosLista.get(idBusca).toString() );
        }
    }

    public void deletaProduto (String nome, String marca){
        int idBusca = buscaProduto(nome, marca);
        if ( idBusca == -1){
            System.out.println("Produto não encontrado!");
        } else {
            produtosLista.remove(idBusca);
            System.out.println("Produto Excluído!");
        }
    }

    public void editaProduto (String nome, String marca, String novoNome, String novaMarca, String novaSessao, String novoTipo){
        int idBusca = buscaProduto(nome, marca);
        if ( idBusca == -1){
            System.out.println("Produto não encontrado!");
        } else {
            if (novoNome != null) {
                produtosLista.get(idBusca).setNome(novoNome);
            }
            if (novaMarca != null) {
                produtosLista.get(idBusca).setMarca(novaMarca);
            }
            if (novaSessao != null) {
                produtosLista.get(idBusca).setSessao(novaSessao);
            }
            if (novoTipo != null) {
                produtosLista.get(idBusca).setTipo(novoTipo);
            }
        }
    }

    public void inserirQuantidadeEstoque (String nome, String marca, int quantidade){
        int idBusca = buscaProduto(nome, marca);
        if ( idBusca == -1){
            System.out.println("Produto não encontrado!");
        } else {
            produtosLista.get(idBusca).incrementaEstoque(quantidade);
        }
    }

    public void removerQuantidadeEstoque (String nome, String marca, int quantidade){
        int idBusca = buscaProduto(nome, marca);
        if ( idBusca == -1){
            System.out.println("Produto não encontrado!");
        } else {
            produtosLista.get(idBusca).decrementaEstoque(quantidade);
        }
    }

}
