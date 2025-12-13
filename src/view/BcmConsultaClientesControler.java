/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.BcmCliente;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author brundo_monteiro
 */
public class BcmConsultaClientesControler extends AbstractTableModel {
    
    private List listaClientes;
    
    @Override
    public int getRowCount() {
        return listaClientes.size();
    }
    
    public void setLista(List lista) {
        this.listaClientes = lista;
        this.fireTableDataChanged();
    }
    
    public BcmCliente getBean(int rowIndex) {
        BcmCliente cliente = (BcmCliente) listaClientes.get(rowIndex);
        return cliente;
    }
    
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BcmCliente clientes = (BcmCliente) getBean(rowIndex);
        if (columnIndex == 0) {
            return clientes.getBcmIdCodigo();
        } else if (columnIndex == 1) {
            return clientes.getBcmNome();
        } else if (columnIndex == 2) {
            return clientes.getBcmCpf();
        } else if (columnIndex == 3) {
            return Util.dateToStr(clientes.getBcmDataNascimento());
        } else if (columnIndex == 4) {
            return clientes.getBcmNacionalidade();
        } else if (columnIndex == 5) {
            return clientes.getBcmTelefone();
        } else if (columnIndex == 6) {
            String sexo = clientes.getBcmSexo();
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
