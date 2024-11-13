package aulacelular;
import java.util.Scanner;

public class Celular {

    private String marca;
    private String cor;
    private int tamanho;
    private boolean aprova_dagua;
    private String tamanhoDescricao;
    private int cameras = 2;
    private int senha;
    private boolean ligado;
    private boolean camera;
    private boolean tirarFoto;

    public static void main(String[] args) {
        Celular celular = new Celular();
        celular.perguntarTamanho();
        celular.perguntarLigado();
        celular.colocarSenha();
        celular.desbloqueado();
        celular.perguntarCamera();
        celular.perguntarTirarFoto();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
        definirTamanhoDescricao();
    }

    public boolean isAprovaDagua() {
        return aprova_dagua;
    }

    public void setAprovaDagua(boolean aprova_dagua) {
        this.aprova_dagua = aprova_dagua;
    }

    public String getTamanhoDescricao() {
        return tamanhoDescricao;
    }

    public int getCameras() {
        return cameras;
    }

    public void setCameras(int cameras) {
        this.cameras = cameras;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public boolean isTirarFoto() {
        return tirarFoto;
    }

    public void setTirarFoto(boolean tirarFoto) {
        this.tirarFoto = tirarFoto;
    }

    private void definirTamanhoDescricao() {
        switch (tamanho) {
            case 1:
                tamanhoDescricao = "Mini";
                break;
            case 2:
                tamanhoDescricao = "Padrão";
                break;
            case 3:
                tamanhoDescricao = "Plus";
                break;
            default:
                tamanhoDescricao = "Tamanho inválido";
                break;
        }
        System.out.println("Tamanho do celular: " + tamanhoDescricao);
    }

    public void perguntarTamanho() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escolha o tamanho do celular (1: Mini, 2: Padrão, 3: Plus): ");
        setTamanho(entrada.nextInt());
    }

    public void perguntarLigado() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("O celular está ligado? (true/false): ");
        setLigado(entrada.nextBoolean());

        if (isLigado()) {
            System.out.println("Seu celular está ligado, pode utilizar.");
        } else {
            System.out.println("Seu celular está desligado, ligue para usá-lo.");
        }
    }

    public void colocarSenha() {
        if (!isLigado()) return;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        setSenha(entrada.nextInt());
    }

    public void desbloqueado() {
        if (!isLigado()) return;

        if (getSenha() == 1234) {
            System.out.println("Celular desbloqueado!");
        } else {
            System.out.println("Senha incorreta, tente novamente.");
        }
    }

    public void perguntarCamera() {
        if (!isLigado()) return;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Deseja usar a câmera? (true/false): ");
        setCamera(entrada.nextBoolean());

        if (isCamera()) {
            System.out.println("Entrou no aplicativo câmera.");
        } else {
            System.out.println("Usou outro aplicativo.");
        }
    }

    public void perguntarTirarFoto() {
        if (!isCamera()) return;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Deseja tirar uma foto? (true/false): ");
        setTirarFoto(entrada.nextBoolean());

        if (isTirarFoto()) {
            System.out.println("Parabéns! As fotos ficaram lindas.");
        } else {
            System.out.println("Deseja tirar foto ou gravar vídeo?");
        }
    }
}
