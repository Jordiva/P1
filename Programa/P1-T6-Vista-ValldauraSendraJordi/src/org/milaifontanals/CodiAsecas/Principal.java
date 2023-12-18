package org.milaifontanals.CodiAsecas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Principal extends JFrame implements ActionListener {
    private JTextField filterNameField;
    private JComboBox<String> filterDayComboBox;
    private JComboBox<String> filterMonthComboBox;
    private JComboBox<String> filterYearComboBox;
    private JButton filterButton;

    private JTable firstTable; // Primera tabla
    private DefaultTableModel firstTableModel;

    private JTable secondTable; // Segunda tabla
    private DefaultTableModel secondTableModel;

    private JPanel buttonPanel;

    public Principal(String username) {
        setTitle("WikiLoc - " + username);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Apartado de Filtrar
        JPanel filterPanel = createFilterPanel();
        add(filterPanel, BorderLayout.NORTH);

        // Contenedor para las dos tablas
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setResizeWeight(0.5);

        // Primera tabla
        firstTable = createTable();
        JScrollPane firstTableScrollPane = new JScrollPane(firstTable);
        splitPane.setLeftComponent(firstTableScrollPane);

        // Segunda tabla (con puntos de ruta)
        secondTable = createPathPointsTable();
        JScrollPane secondTableScrollPane = new JScrollPane(secondTable);
        secondTableScrollPane.setPreferredSize(new Dimension(200, 300)); // Ajusta el tamaño
        splitPane.setRightComponent(secondTableScrollPane);

        add(splitPane, BorderLayout.CENTER);

        // Apartado de Botones
        buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    private JPanel createFilterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBorder(BorderFactory.createTitledBorder("Filtrar"));

        String[] days = {"Día", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] months = {"Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String[] years = {"Año", "2023", "2022", "2021", "2020", "2019", "2018", "2017"};

        filterNameField = new JTextField(30);
        filterDayComboBox = new JComboBox<>(days);
        filterMonthComboBox = new JComboBox<>(months);
        filterYearComboBox = new JComboBox<>(years);
        filterButton = new JButton("Filtrar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(filterNameField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(filterDayComboBox, gbc);

        gbc.gridx = 2;
        panel.add(filterMonthComboBox, gbc);

        gbc.gridx = 3;
        panel.add(filterYearComboBox, gbc);

        gbc.gridx = 4;
        panel.add(Box.createRigidArea(new Dimension(10, 0))); // Espacio en blanco horizontal

        gbc.gridx = 5;
        panel.add(filterButton, gbc);

        return panel;
    }

    private JTable createTable() {
        String[] columnNames = {"Nombre", "Apellido", "Edad"};
        Object[][] data = {
            {"Juan", "Pérez", 30},
            {"Ana", "Gómez", 25},
            {"Luis", "Martínez", 35}
        };

        firstTableModel = new DefaultTableModel(data, columnNames);
        return new JTable(firstTableModel);
    }

    private JTable createPathPointsTable() {
        String[] columnNames = {"Punto de Ruta"};
        Object[][] data = {
            {"Ruta 1"},
            {"Ruta 2"},
            {"Ruta 3"}
        };

        secondTableModel = new DefaultTableModel(data, columnNames);
        JTable pathPointsTable = new JTable(secondTableModel);
        pathPointsTable.setPreferredScrollableViewportSize(new Dimension(200, 300)); // Ajusta el tamaño de la tabla
        return pathPointsTable;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Botones"));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JButton("Botón 1"));
        panel.add(new JButton("Botón 2"));
        panel.add(new JButton("Botón 3"));
        panel.add(new JButton("Botón 4"));
        return panel;
    }

    private void filterTable() {
        String selectedName = filterNameField.getText();
        String selectedDay = filterDayComboBox.getSelectedItem().toString();
        String selectedMonth = filterMonthComboBox.getSelectedItem().toString();
        String selectedYear = filterYearComboBox.getSelectedItem().toString();

        // Lógica de filtrado de la tabla

        // Actualizar la tabla con los datos filtrados (borrado en este ejemplo)
        while (firstTableModel.getRowCount() > 0) {
            firstTableModel.removeRow(0);
        }

        // Lógica de filtrado para la segunda tabla

        // Actualizar la segunda tabla con los datos filtrados
        while (secondTableModel.getRowCount() > 0) {
            secondTableModel.removeRow(0);
        }
    }

    /* 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal loginFrame = new Principal();
            loginFrame.setVisible(true);
        });
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
