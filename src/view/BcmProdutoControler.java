/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.BcmProduto;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brundo_monteiro
 */
public class BcmProdutoControler extends AbstractTableModel {

    private List listaProdutos;

    @Override
    public int getRowCount() {
        return listaProdutos.size();
    }

    public void setLista(List lista) {
        this.listaProdutos = lista;
    }

    public BcmProduto getBean(int rowIndex) {
        BcmProduto produto = (BcmProduto) listaProdutos.get(rowIndex);
        return produto;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BcmProduto produtos = (BcmProduto) getBean(rowIndex);
        if (columnIndex == 0) {
            return produtos.getBcmIdCodigo();
        } else if (columnIndex == 1) {
            return produtos.getBcmNome();
        } else if (columnIndex == 2) {
            return produtos.getBcmMarca();
        } else if (columnIndex == 3) {
            return produtos.getBcmModelo();
        }else if (columnIndex == 4) {
            return produtos.getBcmValor();
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
            return "Marca";
        } else if (columnIndex == 3) {
            return "Modelo";
        }else if (columnIndex == 4) {
            return "Valor";
        }
        return "";
    }
}
