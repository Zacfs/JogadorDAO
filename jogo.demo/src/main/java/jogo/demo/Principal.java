package jogo.demo;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		int x = 0;
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		dao.conectar();
		System.out.print("1-Listar\n2-Inserir\n3-Excluir\n4-Atualizar\n5-Sair\n");
		while(x!=5) {
			x = sc.nextInt();
		switch(x){
		case 1:
			Jogo[] jogos = dao.getJogos();
			System.out.println("Lista:");
			for (int i = 0; i < jogos.length; i++) {
				System.out.println(jogos[i].getNome());
			}
			break;
		case 2:
			Jogo in = new Jogo();
			System.out.print("Inserir\n");
			System.out.print("Digite o id: ");
			in.setId(sc.nextInt());
			System.out.print("Digite o nome: ");
			sc.nextLine();
			in.setNome(sc.nextLine());
			System.out.print("Digite o preco: ");
			in.setPreco(sc.nextDouble());
			if(dao.inserirJogo(in)) 
			{System.out.println("Inserido");}
			break;
		case 3:
			System.out.print("Excluir\n");
			System.out.print("Digite o id: ");
			if(dao.excluirJogo(sc.nextInt()))
			{System.out.println("Excluido");}
			break;
		case 4:
			Jogo up = new Jogo();
			System.out.print("Atualizar\n");
			System.out.print("Digite o id: ");
			up.setId(sc.nextInt());
			System.out.print("Digite o novo nome: ");
			sc.nextLine();
			up.setNome(sc.nextLine());
			System.out.print("Digite o novo preco: ");
			up.setPreco(sc.nextDouble());
			if(dao.atualizarJogo(up))
			{System.out.println("Atualizado");}
			break;
		case 5:
			dao.close();
			{System.out.println("FIM");}
			break;
		default:
			break;
		}
		}
		sc.close();
	}
}
