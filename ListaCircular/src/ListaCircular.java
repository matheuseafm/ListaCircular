package entities;

public class ListaCircular {
    private Node atual;
    private int tamanho;

    public ListaCircular() {
        atual = null;
        tamanho = 0;
    }

    // Classe interna para o nó da lista
    private static class Node {
        int valor;
        Node prox;

        Node(int valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    // Inserir um novo elemento no final da lista
    public String insere(int e) {
        Node novo = new Node(e);
        if (tamanho == 0) {
            novo.prox = novo; // Faz a lista circular
            atual = novo;
        } else {
            Node temp = atual;
            while (temp.prox != atual) {
                temp = temp.prox;
            }
            temp.prox = novo;
            novo.prox = atual;
        }
        tamanho++;
        return "Elemento " + e + " inserido na lista";
    }

    // Remover um elemento da lista
    public String remove() {
        if (tamanho == 0) {
            return "Lista vazia, não é possível remover um elemento";
        }

        int valorRemovido;
        if (tamanho == 1) {
            valorRemovido = atual.valor;
            atual = null;
        } else {
            Node temp = atual;
            while (temp.prox != atual) {
                temp = temp.prox;
            }
            valorRemovido = atual.valor;
            temp.prox = atual.prox;
            atual = atual.prox;
        }
        tamanho--;
        return "Elemento " + valorRemovido + " removido da lista";
    }

    // Imprimir os elementos da lista
    public String imprime() {
        if (tamanho == 0) {
            return "Lista vazia";
        }

        StringBuilder sb = new StringBuilder("Elementos na lista: ");
        Node temp = atual;
        for (int i = 0; i < tamanho; i++) {
            sb.append(temp.valor).append(" ");
            temp = temp.prox;
        }
        return sb.toString();
    }
}
