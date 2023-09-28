import java.util.Random;
import java.util.Scanner;

public class jogo {
	public static void main(String[] args) {
		String[] palavras = { "computador", "programacao", "java", "desenvolvimento", "jogo" };
		Random random = new Random();
		String palavraOculta = palavras[random.nextInt(palavras.length)];

		int tentativasRestantes = 6;
		String letrasAdivinhadas = "";
		String palavraRevelada = "";
		for (int i = 0; i < palavraOculta.length(); i++) {
			palavraRevelada += "_";
		}
		Scanner scanner = new Scanner(System.in);

		while (tentativasRestantes > 0 && !palavraRevelada.equals(palavraOculta)) {
			System.out.println("Palavra :" + palavraRevelada);
			System.out.println("Letras adivinhadas: " + letrasAdivinhadas);
			System.out.println("Tentativas restantes: " + tentativasRestantes);
			System.out.println("Adivinhe uma letra: ");
			String tentativa = scanner.nextLine().toLowerCase();

			if (letrasAdivinhadas.contains(tentativa)) {
				System.out.println("Voce ja adivinhou essa letra. Tente outra");
				continue;

			}

			if (palavraOculta.contains(tentativa)) {
				for (int i = 0; i < palavraOculta.length(); i++) {
					if (palavraOculta.charAt(i) == tentativa.charAt(0)) {
						palavraRevelada = palavraRevelada.substring(0, i) + tentativa
								+ palavraRevelada.substring(i + 1);
					}

				}

			}

			else {
				tentativasRestantes--;
			}

			letrasAdivinhadas += tentativa;

		}

		if (palavraRevelada.equals(palavraOculta)) {
			System.out.println("Parabens! Voce adivinhou a palvra corretamente" + palavraOculta);

		} else {
			System.out.println("Voce perdeu! A palavra correta é " + palavraOculta);
		}
		scanner.close();

	}

}
