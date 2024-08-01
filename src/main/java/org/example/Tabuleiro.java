package org.example;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro {
    protected static void mostrarTabuleiro(List<String> tabuleiro){
        //Tabuleiro, Verificando cada entrada para ver se for X ou O. Se for um ou outro, ira imprimir ele de uma cor especifica (34m = vermelho, 31m = azul)
        System.out.println("[ " + (tabuleiro.get(0).equals("X") ? "\u001B[34m" + tabuleiro.get(0) + "\u001B[0m" :
                tabuleiro.get(0).equals("O") ? "\u001B[31m" + tabuleiro.get(0) + "\u001B[0m" : tabuleiro.get(0)) + " ] [ " + (tabuleiro.get(1).equals("X") ?
                "\u001B[34m" + tabuleiro.get(1) + "\u001B[0m" : tabuleiro.get(1).equals("O") ?
                "\u001B[31m" + tabuleiro.get(1) + "\u001B[0m" : tabuleiro.get(1)) + " ] [ " + (tabuleiro.get(2).equals("X") ?
                "\u001B[34m" + tabuleiro.get(2) + "\u001B[0m": tabuleiro.get(2).equals("O") ?
                "\u001B[31m" + tabuleiro.get(2) + "\u001B[0m" : tabuleiro.get(2)) + " ]\n"
                + "[ " + (tabuleiro.get(3).equals("X") ? "\u001B[34m" + tabuleiro.get(3) + "\u001B[0m" :
                tabuleiro.get(3).equals("O") ? "\u001B[31m" + tabuleiro.get(3) + "\u001B[0m" : tabuleiro.get(3)) + " ] [ " + (tabuleiro.get(4).equals("X") ?
                "\u001B[34m" + tabuleiro.get(4) + "\u001B[0m" : tabuleiro.get(4).equals("O") ?
                "\u001B[31m" + tabuleiro.get(4) + "\u001B[0m" : tabuleiro.get(4)) + " ] [ " + (tabuleiro.get(5).equals("X") ?
                "\u001B[34m" + tabuleiro.get(5) + "\u001B[0m" : tabuleiro.get(5).equals("O") ? "\u001B[31m" + tabuleiro.get(5) + "\u001B[0m" : tabuleiro.get(5)) + " ]\n"
                + "[ " + (tabuleiro.get(6).equals("X") ? "\u001B[34m" + tabuleiro.get(6) + "\u001B[0m" : tabuleiro.get(6).equals("O") ?
                "\u001B[31m" + tabuleiro.get(6) + "\u001B[0m" : tabuleiro.get(6)) + " ] [ " + (tabuleiro.get(7).equals("X") ?
                "\u001B[34m" + tabuleiro.get(7) + "\u001B[0m" : tabuleiro.get(7).equals("O") ?
                "\u001B[31m" + tabuleiro.get(7) + "\u001B[0m" : tabuleiro.get(7)) + " ] [ " + (tabuleiro.get(8).equals("X") ?
                "\u001B[34m" + tabuleiro.get(8) + "\u001B[0m" : tabuleiro.get(8).equals("O") ?
                "\u001B[31m" + tabuleiro.get(8) + "\u001B[0m" : tabuleiro.get(8)) + " ]");
    }
    protected static boolean fazerJogada(List<String> tabuleiro, String jogador, Scanner sc) {
        System.out.println("------------------------");
        System.out.println((jogador.equals("X")? "\u001B[34m" + "Qual casa quer jogar, " + jogador + "?" + "\u001B[0m" : jogador.equals("O")? "\u001B[31m" + "Qual casa quer jogar, " + jogador + "?" +"\u001B[0m" : jogador));
        mostrarTabuleiro(tabuleiro);
        try {
            String jogada = sc.next();
            int casa = Integer.parseInt(jogada);
            if (casa < 1 || casa > 9) {
                System.out.println("Casa inválida. Tente novamente.");
                return false;
            }
            if (tabuleiro.get(casa - 1).equals("X") || tabuleiro.get(casa - 1).equals("O")) {
                System.out.println("Você não pode escolher uma casa já escolhida!");
                return false;
            }
            tabuleiro.set(casa - 1, jogador);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            return false;
        }
    }

    protected static boolean verificarVencedor(List<String> tabuleiro) {
        // Verificar linhas
        for (int i = 0; i < 7; i += 3) {
            if (tabuleiro.get(i).equals(tabuleiro.get(i + 1)) && tabuleiro.get(i).equals(tabuleiro.get(i + 2))) {
                return true;
            }
        }
        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro.get(i).equals(tabuleiro.get(i + 3)) && tabuleiro.get(i).equals(tabuleiro.get(i + 6))) {
                return true;
            }
        }
        // Verificar diagonais
        if (tabuleiro.get(0).equals(tabuleiro.get(4)) && tabuleiro.get(0).equals(tabuleiro.get(8))) {
            return true;
        }
        if (tabuleiro.get(2).equals(tabuleiro.get(4)) && tabuleiro.get(2).equals(tabuleiro.get(6))) {
            return true;
        }
        return false;
    }
    protected static boolean verificarEmpate(List<String> tabuleiro){
        int testeEmpate = 0;
        for (int i = 0; i <= 8; i++) {
            if(tabuleiro.get(i).equals("X") || tabuleiro.get(i).equals("O")){
                testeEmpate++;
            }
        }
        if(testeEmpate == 9){
            return true;
        }else {
            return false;
        }
    }
}