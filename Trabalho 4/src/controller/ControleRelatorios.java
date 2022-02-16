/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.JDBCUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fabricio
 */
public class ControleRelatorios {

    Connection connection = null;

    public static final String pasta_relatorios = System.getProperty("user.dir") + "/relatorios/";
    
    // normal
    public static final File file_relatorio_herois = new File(pasta_relatorios, "Heroi_simples.jrxml");
    public static final File file_relatorio_herois_comp = new File(pasta_relatorios, "Heroi_simples.jasper");
    public static final File file_relatorio_herois_pdf = new File(pasta_relatorios, "Heroi_simples.pdf");
    // com parametro
    public static final File file_relatorio_herois_parametro = new File(pasta_relatorios, "Heroi_parametro.jrxml");
    public static final File file_relatorio_herois_parametro_comp = new File(pasta_relatorios, "Heroi_parametro.jasper");
    public static final File file_relatorio_herois_parametro_pdf = new File(pasta_relatorios, "relatorio_heroi_parametro.pdf");
    // com group by + variavel relatório
    public static final File file_relatorio_herois_group = new File(pasta_relatorios, "Heroi_group.jrxml");
    public static final File file_relatorio_herois_group_comp = new File(pasta_relatorios, "Heroi_group.jasper");
    public static final File file_relatorio_herois_group_pdf = new File(pasta_relatorios, "Heroi_group.pdf");

    public ControleRelatorios() {
        try {
            String path = System.getProperty("user.dir");
            File config_file = new File(path, "configuracaobd.properties");
            JDBCUtil.init(config_file);
            connection = JDBCUtil.getConnection();
        } catch (ClassNotFoundException | SQLException | IOException erro) {
            System.out.println("Erro ao criar conexao com o BD.");
        }
        //System.out.println(System.getProperties());    
    }

        public void RelatorioHeroi(boolean view) {
        JasperPrint impressao;
        try {
            // caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            FileInputStream arquivo = new FileInputStream(file_relatorio_herois);//jrxml
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);

            //ou poderia utilizar diretamente o relatorio compilado
            //FileInputStream relatorio = new FileInputStream(file_relatorio_herois_comp);//jasper
            //preenchimento do relatorio com a conexao e parametros
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo jasper
                    null,//parametros
                    connection);//conexao
            if (view) {
                //opcao de visualizar o relatorio
                JasperViewer.viewReport(impressao, false);
            } else {
                //opcao de exportar o relatorio diretamente para arquivo
                JasperExportManager.exportReportToPdfFile(impressao, file_relatorio_herois_pdf.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Gerado o arquivo com sucesso: " + file_relatorio_herois_pdf.getAbsolutePath());
            }
        } catch (JRException | FileNotFoundException erro) {
            System.err.println("Não foi possível exportar o relatório.\n\n" + erro);
        }
    }

  
    
    public void RelatorioHeroiParametro(Map parametros, boolean view) {
        JasperPrint impressao;
        try {
            //caso use o relatorio ja compilado (arquivo .jasper)
            //FileInputStream relatorio = new FileInputStream(file_relatorio_herois_parametro_comp);//jasper

            //ou caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            FileInputStream arquivo = new FileInputStream(file_relatorio_herois_parametro);//jrxml
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);//compilar
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo .jasper
                    parametros,
                    connection);
            if (view) {
                JasperViewer.viewReport(impressao, false);
            } else {
                JasperExportManager.exportReportToPdfFile(impressao, file_relatorio_herois_parametro_pdf.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + file_relatorio_herois_parametro_pdf.getAbsolutePath());
            }
        } catch (FileNotFoundException | JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
        }
    }
    
    public void RelatorioSalvamentoPorDia(boolean view) {
        JasperPrint impressao;
        try {
            //caso use o relatorio ja compilado (arquivo .jasper)
            //FileInputStream relatorio = new FileInputStream(file_relatorio_herois_group_comp);//jasper

            //ou caso seja necessário, compila o relatório (caso deseja usar o jrxml)
            FileInputStream arquivo = new FileInputStream(file_relatorio_herois_group);//jrxml
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);//compilar
            impressao = JasperFillManager.fillReport(
                    relatorio,//arquivo compilado ou .jasper ou o .jrxml compilado (veja acima)
                    null,
                    connection);

             if (view) {
                JasperViewer.viewReport(impressao, false);
            } else {
                JasperExportManager.exportReportToPdfFile(impressao, file_relatorio_herois_group_pdf.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Gerado o arquivo " + file_relatorio_herois_group_pdf.getAbsolutePath());
            }
        } catch (FileNotFoundException | JRException erro) {
            System.err.println("Não foi possível visualizar o relatório.\n\n" + erro);
        }
    }
}
