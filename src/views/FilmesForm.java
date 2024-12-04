package views;

import models.Filmes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmesForm extends JDialog{
    private JTextField filmeTituloField;
    private JTextField filmeDescField;
    private JTextField filmeDuracaoField;
    private JTextField filmeAnoField;
    private JTextField filmeClasField;
    private JTextField catIdField;
    private JButton salvarButton;
    private JButton cancelarButton;

    private Filmes filmes;
    private boolean isEditMode;

    public FilmesForm(Frame parent, String title) {
        super(parent, title, true);
        this.isEditMode = false;
        initializeComponents();
    }

    public FilmesForm(Frame parent, String title, Filmes filmes) {
        super(parent, title, true);
        this.filmes = filmes;
        this.isEditMode = true;
        initializeComponents();
        preencherCampos();
    }

    private void initializeComponents() {
        filmeTituloField = new JTextField(20);
        filmeDescField = new JTextField(20);
        filmeDuracaoField = new JTextField(20);
        filmeAnoField = new JTextField(20);
        filmeClasField = new JTextField(20);
        catIdField = new JTextField(20);
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Titulo"));
        panel.add(filmeTituloField);
        panel.add(new JLabel("Descrição"));
        panel.add(filmeDescField);
        panel.add(new JLabel("Duração"));
        panel.add(filmeDuracaoField);
        panel.add(new JLabel("Ano"));
        panel.add(filmeAnoField);
        panel.add(new JLabel("Classificação"));
        panel.add(filmeClasField);
        panel.add(new JLabel("Categoria"));
        panel.add(catIdField);
        panel.add(salvarButton);
        panel.add(cancelarButton);

        // Adicionando uma margem de 10 pixels nas bordas laterais e verticais
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (isEditMode) {
                        atualizarFilmes();
                    } else {
                        adicionarFilmes();
                    }
                    dispose();
                }
            }
        });

        cancelarButton.addActionListener(_-> dispose());

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(getParent());
    }
    


    private void preencherCampos() {
        if (filmes != null) {
            filmeTituloField.setText(filmes.getFilmeTitulo());
            filmeDescField.setText(filmes.getFilmeDesc());
            filmeDuracaoField.setText(toString(filmes.getFilmeDuracao()));
            filmeAnoField.setText(toString(filmes.getFilmeAno()));
            filmeClasField.setText(toString(filmes.getFilmeClas()));
            catIdField.setText(toString(filmes.getCatId()));
        }
    }


    private boolean validarCampos() {
        if (filmeTituloField.getText().trim().isEmpty() ) {
            JOptionPane.showMessageDialog(
                this,
                "O título é obrigatòrio.",
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    private void adicionarFilmes() {
        filmes = new Filmes(
            filmeTituloField.getText().trim(),
            filmeDescField.getText().trim(),
            filmeDuracaoField.getText().trim(),
            filmeAnoField.getText().trim(),
            filmeClasField.getText().trim(),
            catIdField.getText().trim()
        );
    }


    private void atualizarFilmes() {
        if (filmes != null) {
            filmes.setFilmeTitulo(filmeTituloField.getText().trim());
            filmes.setFilmeDesc(filmeDescField.getText().trim());
            filmes.setFilmeDuracao(filmeDuracaoField.getText().trim());
            filmes.setFilmeAno(filmeAnoField.getText().trim());
            filmes.setFilmeClas(filmeClasField.getText().trim());
            filmes.setCatId(catId.getText().trim());
        }
    }

    public Filmes getFilmes() {
        return filmes;
    }
    
}

