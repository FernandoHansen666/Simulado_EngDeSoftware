package Simulado_EngDeSoftware.Backend;

public class Aluno {
	private int alunoID, serie;
	private String nome, alunoSenha;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, int alunoID, String alunoSenha, int serie) {
		this.nome = nome;
		this.alunoID = alunoID;
		this.alunoSenha = alunoSenha;
		this.serie = serie;
	}

	public int getAlunoID() {
		return alunoID;
	}

	public void setAlunoID(int alunoID) {
		this.alunoID = alunoID;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlunoSenha() {
		return alunoSenha;
	}

	public void setAlunoSenha(String alunoSenha) {
		this.alunoSenha = alunoSenha;
	}
	
	public void listar() {
		System.out.println("Nome: " + toString());
		System.out.println("ID: "+ this.alunoID);
		System.out.println("Senha: " + this.alunoSenha);
		System.out.println("Serie: "+ this.serie);
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
	
	
}
