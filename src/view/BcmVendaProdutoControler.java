/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.BcmVendaProduto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author brundo_monteiro
 */
public class BcmVendaProdutoControler extends AbstractTableModel {

    private List listaVendaProduto = new ArrayList();

    @Override
    public int getRowCount() {
        return listaVendaProduto.size();
    }

    public void setLista(List lista) {
        this.listaVendaProduto = lista;
    }

    public void addBean(BcmVendaProduto bcmVendaProduto) {
        this.listaVendaProduto.add(bcmVendaProduto);
        this.fireTableDataChanged();
    }
    
    public BcmVendaProduto getBean(int rowIndex) {
        BcmVendaProduto vendaProduto = (BcmVendaProduto) listaVendaProduto.get(rowIndex);
        return vendaProduto;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BcmVendaProduto vendaProdutos = (BcmVendaProduto) getBean(rowIndex);
        if (columnIndex == 0) {
            return vendaProdutos.getBcmProduto().getBcmNome();
        } else if (columnIndex == 1) {
            return vendaProdutos.getBcmProduto().getBcmValor();
        } else if (columnIndex == 2) {
            return vendaProdutos.getBcmQuantidade();
        } else if (columnIndex == 3) {
            return vendaProdutos.getBcmSubtotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Produto";
        } else if (columnIndex == 1) {
            return "Valor Unitário";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Subtotal";
        }
        return "";
    }

}
