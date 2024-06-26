package ar.edu.uade.tpo.ejercicio5;

import ar.edu.uade.tpo.common.Stack;

public class Main {

    public static void main(String[] args) {
        // Algoritmo de paréntesis balanceados
        String balanced = "()()((()))(()())";
        System.out.println(BracketUtils.isBalanced(balanced));

        String notBalanced = "()()((()))(()((((())";
        System.out.println(BracketUtils.isBalanced(notBalanced));

        String balancedWithQuotes = "()()((()))(()'(((('())";
        System.out.println(BracketUtils.isBalanced(balancedWithQuotes));
    }
}
