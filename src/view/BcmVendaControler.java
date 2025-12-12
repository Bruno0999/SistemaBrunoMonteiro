/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.BcmVenda;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author brundo_monteiro
 */
public class BcmVendaControler extends AbstractTableModel {

    private List lista;

    @Override
    public int getRowCount() {
        return lista.size();
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public BcmVenda getBean(int rowIndex) {
        BcmVenda cliente = (BcmVenda) lista.get(rowIndex);
        return cliente;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BcmVenda venda = (BcmVenda) getBean(rowIndex);
        if (columnIndex == 0) {
            return venda.getBcmIdVenda();
        } else if (columnIndex == 1) {
            return Util.dateToStr(venda.getBcmData());
        } else if (columnIndex == 2) {
            return venda.getBcmCliente();
        }else if (columnIndex == 3) {
            return venda.getBcmFuncionarios();
        } else if (columnIndex == 4) {
            return venda.getBcmDesconto();
        } else if (columnIndex == 5) {
            return venda.getBcmTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Data";
        } else if (columnIndex == 2) {
            return "Cliente";
        } else if (columnIndex == 3) {
            return "Funcionario";
        } else if (columnIndex == 4) {
            return "Descontos";
        } else if (columnIndex == 5) {
            return "Total";
        }
        return "";
    }
}
