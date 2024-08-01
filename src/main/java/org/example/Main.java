package org.example;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.example.Tabuleiro.*;

public class Main {
    public static void main(String[] args) {
        boolean ganhador = false;
        String jogador = "X";
        List<String> tabuleiro = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Scanner sc = new Scanner(System.in);
        System.out.println("Tic-Tac-Toe Game Board: ");
        while (!ganhador) {
            boolean entradaInvalida = true;
            while (entradaInvalida) {
                boolean jogadaValida = fazerJogada(tabuleiro, jogador, sc);
                if (jogadaValida) {
                    entradaInvalida = false;
                }
            }
            if (Tabuleiro.verificarVencedor(tabuleiro)) {
                if(verificarVencedor(tabuleiro) == jogador.equals("X")) {
                    System.out.println("\u001B[34mJogador " + jogador + " venceu!\u001B[0m");
                    mostrarTabuleiro(tabuleiro);
                    break;
                } else{
                    System.out.println("\u001B[31mJogador " + jogador + " venceu!\u001B[0m");
                    mostrarTabuleiro(tabuleiro);
                    break;
                }
            }if (Tabuleiro.verificarEmpate(tabuleiro)) {
                System.out.println("Empate!");
                mostrarTabuleiro(tabuleiro);
                break;
            }
            jogador = jogador.equals("X") ? "O" : "X";
        }
    }
}