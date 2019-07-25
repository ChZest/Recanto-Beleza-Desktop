package util;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import dados.DadosException;
import java.awt.Toolkit;

/* @author BIC-Jr Guia de Estilo */
public class RelatorioAtendimento extends DaoMYSQL {

    public static void main(String[] args) throws JRException, DadosException {
//        Aluno a = new Aluno(1, "Maya", "2345678", "8765432", "8237645");
//        Aluno a1 = new Aluno(2, "Rendura", "2345678", "8765432", "8237645");
//        Aluno a2 = new Aluno(3, "Eriseuru", "2345678", "8765432", "8237645");
//        List<Aluno> aList = new ArrayList<Aluno>();
//        aList.add(a);
//        aList.add(a1);
//        aList.add(a2);
//        
//        RelatorioAtendimento aR = new RelatorioAtendimento();
//        aR.emitirRelatorio(aList);
    }

    //Passa uma lista filtrada. Não precisa do connect
    public static void emitirRelatorio(List<?> pList, String relatorio, String cabecalho) {
        String reportSource = relatorio;

        Map<String, Object> params = new HashMap<>();
        params.put("cabecalho", cabecalho);

        try {
            javax.swing.JDialog viewer = new javax.swing.JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
            Toolkit tk = Toolkit.getDefaultToolkit();
            java.awt.Dimension d = tk.getScreenSize();
            viewer.setSize(900, d.height - 50);
            viewer.setResizable(false);
            viewer.setLocationRelativeTo(null);
            
            JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(pList);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportSource, params, jrBean);
            JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
            viewer.getContentPane().add(jrViewer.getContentPane());
            viewer.setVisible(true);
        } catch (JRException ex) {
        }
    }

    //Passa um connection
    public void processar() throws JRException, DadosException {

        String reportsScrFile = "Serviços.jrxml";

        JasperReport jR = JasperCompileManager.compileReport(reportsScrFile);

        Connection con = getConnection();

        Map<String, Object> parameters = new HashMap<>();

        JasperPrint print = JasperFillManager.fillReport(jR, parameters, con);

        File outDir = new File("C:/jasperoutput");
        outDir.mkdirs();

        JasperViewer.viewReport(print, false);
    }
}
