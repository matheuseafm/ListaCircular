import entities.*;

public class Main{
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        // Testando inserção
        System.out.println(lista.insere(1));
        System.out.println(lista.insere(2));
        System.out.println(lista.insere(3));
        System.out.println(lista.insere(4));

        // Imprimindo a lista
        System.out.println(lista.imprime());

        // Testando remoção
        System.out.println(lista.remove());
        System.out.println(lista.remove());

        // Imprimindo a lista após remoção
        System.out.println(lista.imprime());
    }
}