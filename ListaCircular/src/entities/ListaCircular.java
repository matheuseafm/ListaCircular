package entities;

public class ListaCircular {
    private Node head;
    private Node tail;
    private int tamanho;

    public ListaCircular() {
        head = null;
        tail = null;
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
            head = novo;
            tail = novo;
            tail.prox = head; // Faz a lista circular
        } else {
            tail.prox = novo;
            tail = novo;
            tail.prox = head; // Faz a lista circular
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
            valorRemovido = head.valor;
            head = null;
            tail = null;
        } else {
            valorRemovido = head.valor;
            head = head.prox;
            tail.prox = head; // Atualiza a referência circular
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
        Node atual = head;
        for (int i = 0; i < tamanho; i++) {
            sb.append(atual.valor).append(" ");
            atual = atual.prox;
        }
        return sb.toString();
    }
}
