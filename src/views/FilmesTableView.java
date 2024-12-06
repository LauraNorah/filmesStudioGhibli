package views;

import models.Filmes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FilmesTableView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public FilmesTableView() {
        super("Gerenciamento de Filmes");
        initializeComponents();
    }
    
    private void initializeComponents () {
        String[] columnNames = {"Id", "Titulo", "Descricao", "Duração", "Ano", "Classificação", "Categoria"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void atualizarTabela(List<Filmes> filmes) {
        tableModel.setRowCount(0); // limpa a tabela
        for (Filmes filme : filmes) {
            Object[] row = {
                filme.getFilmeId(),
                filme.getFilmeTitulo(),
                filme.getFilmeDesc(),
                filme.getFilmeDuracao(),
                filme.getFilmeAno(),
                filme.getFilmeClas(),
                filme.getCatId()
            };
            tableModel.addRow(row);
        }
    }

    public int getSelectedFilmesId() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return (int) tableModel.getValueAt(selectedRow, 0);
        }
        return -1;
    }
}
