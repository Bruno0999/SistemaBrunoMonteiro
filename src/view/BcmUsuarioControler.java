/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.BcmUsuarios;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author brundo_monteiro
 */
public class BcmUsuarioControler extends AbstractTableModel {

    private List listaUsuarios;

    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    public void setLista(List lista) {
        this.listaUsuarios = lista;
    }

    public BcmUsuarios getBean(int rowIndex) {
        BcmUsuarios usuario = (BcmUsuarios) listaUsuarios.get(rowIndex);
        System.out.println(usuario.getBcmNome());
        return usuario;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BcmUsuarios usuarios = (BcmUsuarios) getBean(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getBcmIdUsuario();
        } else if (columnIndex == 1) {
            return usuarios.getBcmNome();
        } else if (columnIndex == 2) {
            return usuarios.getBcmCpf();
        } else if (columnIndex == 3) {
            return Util.dateToStr(usuarios.getBcmDataNascimento());
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
        }
        return "";
    }
}
