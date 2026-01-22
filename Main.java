import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        int notaIndex = 0;

        System.out.println("=== SISTEMA DE CÁLCULO DE MÉDIA ===");
        System.out.println("Digite as 4 notas do aluno (0 a 10)\n");

        while (notaIndex < 4) {
            System.out.print("Digite a " + (notaIndex + 1) + "ª nota: ");
            double nota = scanner.nextDouble();

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida! Digite um valor entre 0 e 10.\n");
                continue; // Volta para o início do loop
            }

            notas[notaIndex] = nota;
            notaIndex++;
        }

        scanner.close();

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.length;

        System.out.println("\n=== RESULTADO ===");
        System.out.printf("Notas digitadas: %.1f, %.1f, %.1f, %.1f\n",
                notas[0], notas[1], notas[2], notas[3]);
        System.out.printf("Média calculada: %.2f\n", media);

        int categoria = determinarCategoria(media);

        switch (categoria) {
            case 1:
                System.out.println("Situação: APROVADO! 🎉");
                System.out.println("Parabéns pelo excelente desempenho!");
                break;
            case 2:
                System.out.println("Situação: RECUPERAÇÃO! ⚠️");
                System.out.println("Você precisa estudar mais para a prova final.");
                break;
            case 3:
                System.out.println("Situação: REPROVADO! ❌");
                System.out.println("Será necessário refazer a disciplina.");
                break;
            default:
                System.out.println("Situação: INDEFINIDA");
                break;
        }

        System.out.println("\n=== ANÁLISE DETALHADA ===");
        if (media == 10) {
            System.out.println("Nota máxima! Excelente trabalho!");
        } else if (media >= 9) {
            System.out.println("Desempenho excepcional!");
        } else if (media >= 7) {
            System.out.println("Atendeu plenamente aos objetivos!");
        } else if (media >= 5) {
            System.out.println("Necessita melhorar para aprovação final.");
        } else if (media > 0) {
            System.out.println("É necessário dedicar mais tempo aos estudos.");
        } else {
            System.out.println("Nota zerada. Procure a coordenação.");
        }
    }

    private static int determinarCategoria(double media) {
        if (media >= 7.0) {
            return 1; // Aprovado
        } else if (media >= 5.0) {
            return 2; // Recuperação
        } else {
            return 3; // Reprovado
        }
    }
}