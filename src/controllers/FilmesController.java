package controllers;

import models.Filmes;
import repository.FilmesRepository;
import views.FilmesForm;
import views.FilmesTableView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FilmesController {
    private FilmesRepository repository;
    private FilmesTableView tableView;

    public FilmesController() {
        repository = new FilmesRepository();
        tableView = new FilmesTableView();
        inicializar();
    }


    private void inicializar() {
    // Atualizar a tabela com os filmes existentes
    atualizarTabela();
    
    // Criar a barra de ferramentas (toolbar) com botões
    JToolBar toolBar = new JToolBar();
    JButton adicionarButton = new JButton("Adicionar");
    JButton editarButton = new JButton("Editar");
    JButton deletarButton = new JButton("Deletar");
    toolBar.add(adicionarButton );
    toolBar.add(editarButton);
    toolBar.add(deletarButton);
    
    tableView.add(toolBar, java.awt.BorderLayout.NORTH);
    
// Ações dos botões
    // botão para adicionar um registro:
    adicionarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            adicionarFilmes();
        }
    });
    
    // botão para editar um registro:
    editarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            editarFilmes();
        }
    });
    
    // botão para deletar um registro:
    deletarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            deletarFilmes();
        }
    });

    tableView.setVisible(true);
    };


    private void atualizarTabela() {
        List<Filmes> filmes = repository.obterTodosFilmess();
        tableView.atualizarTabela(filmes);
    }
        
    private void adicionarFilmes() {
        FilmesForm form = new FilmesForm(tableView, "Adicionar Filmes");
        form.setVisible(true);
        Filmes novoFilmes = form.getFilmes();
    
        if (novoFilmes != null) {
            repository.adicionarFilmes(novoFilmes);
            atualizarTabela();
        }
    }
    

    private void editarFilmes() {
        int selectedId = tableView.getSelectedFilmesId();
            
        if (selectedId != -1) {
            Filmes Filmes = repository.obterFilmesPorId(selectedId);
    
            if (Filmes != null) {
                FilmesForm form = new FilmesForm(tableView,"Editar Filmes", Filmes);
                form.setVisible(true);
                Filmes FilmesAtualizado = form.getFilmes();
    
                if (FilmesAtualizado != null) {
                    FilmesAtualizado = new Filmes(
                        selectedId,
                        FilmesAtualizado.getFilmeTitulo(),
                        FilmesAtualizado.getFilmeDesc(),
                        FilmesAtualizado.getFilmeDuracao(),
                        FilmesAtualizado.getFilmeAno(),
                        FilmesAtualizado.getFilmeClas(),
                        FilmesAtualizado.getCatId()
                    );
                    repository.atualizarFilmes(FilmesAtualizado);
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(tableView,
                    "Filmes não encontrado.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(tableView,
                "Selecionar um Filmes para edita.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }


    private void deletarFilmes() {
        int selectedId = tableView.getSelectedFilmesId();
        if (selectedId != -1) {
            int confirm = JOptionPane.showConfirmDialog(
                tableView,
                "Tem certeza que deseja deletar este Filmes?",
                "Confirmar Deleção",
                JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                repository.deletarFilmes(selectedId);
                atualizarTabela();
            }
        } else {
            JOptionPane.showMessageDialog(
                tableView,
                "Selecione um Filmes para deletar.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE);
        }
                
    }


    public void iniciar() {
        // Ações já são inicializadas no construtor
    }
}
