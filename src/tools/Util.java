/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.Component;
import javax.swing.JDialog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author bruno_monteiro
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... comp) {
        for (int i = 0; i < comp.length; i++) {

            comp[i].setEnabled(valor);
        }
    }

    public static void limpar(JComponent... comp) {
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] instanceof JTextField) {
                ((JTextField) comp[i]).setText("");
            } else if (comp[i] instanceof JComboBox) {
                ((JComboBox) comp[i]).setSelectedIndex(-1);
            } else if (comp[i] instanceof JCheckBox) {
                ((JCheckBox) comp[i]).setSelected(false);
            } else if (comp[i] instanceof JTextArea) {
                ((JTextArea) comp[i]).setText("");
            }
        }
    }

    public static boolean perguntar(String mensagem, String titulo) {
        int option = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    public static void mostrar(String mensagem, String titulo, int type) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, type);
    }

    public static int strToInt(String value) {
        return Integer.valueOf(value);
    }

    public static double strToDouble(String value) {
        return Double.valueOf(value);
    }

    public static Date strToDate(String cad) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(cad);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use dd/MM/yyyy.", e);
        }
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }

    public static String doubleToStr(double num) {
        return Double.toString(num);
    }

    public static String dateToStr(Date data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }
}
