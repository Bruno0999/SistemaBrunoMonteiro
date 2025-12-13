/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.BcmCliente;
import bean.BcmFuncionarios;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author brundo_monteiro
 */
public class BcmConsultaFuncionariosControler extends AbstractTableModel {

    private List listaFuncionarios;

    @Override
    public int getRowCount() {
        return listaFuncionarios.size();
    }

    public void setLista(List lista) {
        this.listaFuncionarios = lista;
        this.fireTableDataChanged();
    }

    public BcmFuncionarios getBean(int rowIndex) {
        BcmFuncionarios funcionarios = (BcmFuncionarios) listaFuncionarios.get(rowIndex);
        return funcionarios;
    }

     @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BcmFuncionarios funcionarios = (BcmFuncionarios) getBean(rowIndex);
        if (columnIndex == 0) {
            return funcionarios.getBcmIdCodigo();
        } else if (columnIndex == 1) {
            return funcionarios.getBcmNome();
        } else if (columnIndex == 2) {
            return funcionarios.getBcmCpf();
        } else if (columnIndex == 3) {
            return Util.dateToStr(funcionarios.getBcmDataNascimento());
        } else if (columnIndex == 4) {
            return funcionarios.getBcmNacionalidade();
        } else if (columnIndex == 5) {
            return funcionarios.getBcmTelefone();
        } else if (columnIndex == 6) {
            String sexo = funcionarios.getBcmSexo();
            if (sexo == null) {
                return "Não informado";
            }
            
            return sexo.equals("0") ? "Masculino" : "Feminino";
        }
        return "";
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return "CPF";
        } else if (columnIndex == 3) {
            return "Data de nascimento";
        } else if (columnIndex == 4) {
            return "Nacionalidade";
        } else if (columnIndex == 5) {
            return "Telefone";
        } else if (columnIndex == 6) {
            return "Sexo";
        }
        return "";
    }
}
