/**
 *
 * @author alexandrezamberlan
 * @author sylviovieira
 * @author claudialange
 * @author solangefagan
 */
public class Atomo {
    String sigla;
    double x;
    double y;
    double z;
    int posicaoLista;
    int ocorrencia;
    
    public Atomo() {
        
    }
    
    public Atomo(String sigla, double x, double y, double z, int posicao) {
        this.sigla = sigla;
        this.x = x;
        this.y = y;
        this.z = z;
        this.posicaoLista = posicao;
    }
    
    public Atomo(String sigla) {
        this.sigla = sigla;
        this.ocorrencia = 1;
    }
}
