
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author alexandrezamberlan
 * @author sylviovieira
 * @author claudialange
 * @author solangefagan
 */
public class Util {

    public static File carregarArquivo() {
        JFileChooser janelaCarregarArquivo = new JFileChooser();
        janelaCarregarArquivo.setMultiSelectionEnabled(false);
        if (janelaCarregarArquivo.showOpenDialog(janelaCarregarArquivo) == JFileChooser.APPROVE_OPTION) {
            return janelaCarregarArquivo.getSelectedFile();
        }
        return null;
    }

    public static void gerarArquivo(File arquivoFonte, ArrayList<Atomo> lista, int versao, String totalAtomos, String taxaRede) {
        File arquivoDestino;
        StringBuffer sb = new StringBuffer();
        

        try {
            arquivoDestino = new File(arquivoFonte.getName().replace(".", "_" + versao + "."));

            //caso jah exista, cria novo
            FileOutputStream fos = new FileOutputStream(arquivoDestino, false);
            sb.append(totalAtomos + "\n" + taxaRede + "\n");
            for (Atomo at : lista) {
                sb.append(at.sigla);
                sb.append("   ");
                sb.append(at.x);
                sb.append("   ");
                sb.append(at.y);
                sb.append("   ");
                sb.append(at.z + "\n");
                
                fos.write(sb.toString().getBytes());
                sb.delete(0, sb.length());
            }
            fos.close();
        } catch (Exception e) {
        }
    }

    public static void ordenarListaPente(ArrayList<Atomo> lista) {
        boolean houveTroca;
        int i, distancia = lista.size();
        Atomo tmp;

        do {
            houveTroca = false;
            distancia = (int) (distancia / 1.3);

            if (distancia < 1) {
                distancia = 1;
            }
            for (i = 0; i + distancia < lista.size(); i++) {
                if (lista.get(i).sigla.compareTo(lista.get(i + distancia).sigla) > 0) {
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, tmp);
                }
            }
        } while (distancia > 1 || houveTroca == true);
    }

    public static void descobrirFrequencia(ArrayList<Atomo> listaOrigem, ArrayList<Atomo> listaDestino) {
        Atomo tmp;
        boolean achou;

        if (!listaOrigem.isEmpty()) {
            listaDestino.add(new Atomo(listaOrigem.get(0).sigla));
        }

        for (int i = 1; i < listaOrigem.size(); i++) {
            tmp = listaOrigem.get(i);
            achou = false;
            for (int j = 0; j < listaDestino.size(); j++) {
                if (tmp.sigla.equals(listaDestino.get(j).sigla)) {
                    listaDestino.get(j).ocorrencia++;
                    achou = true;
                }
            }
            if (!achou) {
                listaDestino.add(new Atomo(tmp.sigla));
            }
        }
    }
}
