package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ProdutoController;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProdutoView {

	List<Produto> listar = new ArrayList<>();
	ProdutoController produtoController;
	
	public static final int POSICAO_BOTAO = 460;
	public static final int POSICAO_CAMPO_TEXTO = 27;
	public static final int POSICAO_LABEL = 14;
	public static final int POSICAO_TITULO = 40;
	public static final int ALTURA_TELA = 540;
	public static final int LARGURA_TELA = 769;
	
	private JFrame frame;//Tela
	private JTextField tfId;//Campo de texto
	private JTextField tfNome;//Campo de texto
	private JTextField tfQuantidade;//Campo de texto
	private JTextField tfValor;//Campo de texto
	private JTextField tfCodigoBarras;//Campo de texto
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JTable table;
	private JComboBox cbDepartamento;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView window = new ProdutoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProdutoView() {
		iniciarTela();
		listar();
	}
	
	public void limparCampos() {
		tfCodigoBarras.setText("");
		tfId.setText("");
		tfNome.setText("");
		tfQuantidade.setText("");
		tfValor.setText("");
		btnEditar.setEnabled(false);
		btnSalvar.setEnabled(true);
		listar();
	}
	
	public void setarCampos(Produto produto) {
		tfCodigoBarras.setText(produto.getCodBarras());
		tfId.setText(String.valueOf(produto.getId()));
		tfNome.setText(produto.getNome());
		tfQuantidade.setText(String.valueOf(produto.getQuantidade()));
		tfValor.setText(String.valueOf(produto.getValor()));
		cbDepartamento.setSelectedItem(produto.getDepartamento());
		btnEditar.setEnabled(true);
		btnSalvar.setEnabled(false);
		//listar();
	}
	
	private void listar() { 
		produtoController = new ProdutoController();
        listar = produtoController.getProduto();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        int tamanhoLista = listar.size();
        for(int i = 0; i < tamanhoLista; i++){
            model.addRow(new Object[]{
            	listar.get(i).getId(),
            	listar.get(i).getNome(),
            	listar.get(i).getQuantidade(),
            	listar.get(i).getDepartamento(),
            	listar.get(i).getValor()
            });
        }
    }

	private void iniciarTela() {
		try {
			//Iniciar tele
			frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(100, 100, LARGURA_TELA, ALTURA_TELA);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setLocationRelativeTo(null);
			
			//Iniciar painel
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 753, ALTURA_TELA);
			//Adicionando painel na tela
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel labelProduto = new JLabel("Produto");
			labelProduto.setFont(new Font("Calibri", Font.PLAIN, 26));
			labelProduto.setBounds(10, 11, 149, POSICAO_TITULO);
			panel.add(labelProduto);
			
			JLabel labelId = new JLabel("ID:");
			labelId.setBounds(10, 62, 46, POSICAO_LABEL);
			panel.add(labelId);
			
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setBounds(10, 87, 86, POSICAO_CAMPO_TEXTO);
			panel.add(tfId);
			tfId.setColumns(10);
			
			JLabel nome = new JLabel("Nome:");
			nome.setBounds(106, 62, 46, POSICAO_LABEL);
			panel.add(nome);
			
			tfNome = new JTextField();
			tfNome.setColumns(10);
			tfNome.setBounds(106, 87, 249, POSICAO_CAMPO_TEXTO);
			panel.add(tfNome);
			
			JLabel codBarras = new JLabel("Cód. Barras:");
			codBarras.setBounds(226, 127, 73, POSICAO_LABEL);
			panel.add(codBarras);
			
			tfCodigoBarras = new JTextField();
			tfCodigoBarras.setColumns(10);
			tfCodigoBarras.setBounds(226, 152, 517, POSICAO_CAMPO_TEXTO);
			panel.add(tfCodigoBarras);
			
			JLabel departamento = new JLabel("Departamento:");
			departamento.setBounds(365, 62, 110, POSICAO_LABEL);
			panel.add(departamento);
			
			cbDepartamento = new JComboBox();
			cbDepartamento.setModel(new DefaultComboBoxModel(new String[] {"LIMPEZA", "AÇOUGUE", "PAPELARIA"}));
			cbDepartamento.setBounds(365, 87, 378, POSICAO_CAMPO_TEXTO);
			panel.add(cbDepartamento);
			
			JLabel labelQuantidade = new JLabel("Quantidade:");
			labelQuantidade.setBounds(10, 127, 73, POSICAO_LABEL);
			panel.add(labelQuantidade);
			
			tfQuantidade = new JTextField();
			tfQuantidade.setColumns(10);
			tfQuantidade.setBounds(10, 152, 86, POSICAO_CAMPO_TEXTO);
			panel.add(tfQuantidade);
			
			JLabel labelValor = new JLabel("Valor:");
			labelValor.setBounds(106, 127, 73, POSICAO_LABEL);
			panel.add(labelValor);
			
		    tfValor = new JTextField();
		    tfValor.setColumns(10);
		    tfValor.setBounds(106, 152, 110, POSICAO_CAMPO_TEXTO);
			panel.add(tfValor);
			
			JButton btnCancelar = new JButton("Cancelar");
			fecharTelaEvent(btnCancelar);
			btnCancelar.setBounds(654, POSICAO_BOTAO, 89, 23);
			panel.add(btnCancelar);
			
			JButton btnPesquisar = new JButton("Pesquisar");
			pesquisarProdutoEvent(btnPesquisar);
			btnPesquisar.setBounds(12, POSICAO_BOTAO, 99, 23);
			panel.add(btnPesquisar);
			
			btnSalvar = new JButton("Salvar");
			salvarProdutoEvent(tfValor, btnSalvar);
			btnSalvar.setBounds(555, POSICAO_BOTAO, 89, 23);
			panel.add(btnSalvar);
			btnSalvar.setEnabled(true);
			
			btnEditar = new JButton("Editar");
			editarProdutoEvent(tfValor);
			btnEditar.setBounds(455, POSICAO_BOTAO, 89, 23);
			panel.add(btnEditar);
			btnEditar.setEnabled(false);
			
			btnDeletar = new JButton("Deletar");
			
			btnDeletar.setBounds(355, POSICAO_BOTAO, 89, 23);
			panel.add(btnDeletar);
			btnDeletar.setEnabled(false);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(11, 200, 732, 247);
			panel.add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
				},
				new String[] {
					"#ID", "Nome", "Qtd.", "Departamento", "Valor"
				}
					) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
			table.setSelectionBackground(new java.awt.Color(204, 204, 204));
			table.setRowHeight(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(252);
			table.getColumnModel().getColumn(3).setPreferredWidth(118);
			tabelaEvent();
			scrollPane.setViewportView(table);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selecionarNaTabela() {
        int linha = table.getSelectedRow();
        int id = Integer.parseInt(String.valueOf(table.getValueAt(linha, 0)));
        produtoController = new ProdutoController();
        Produto produto = produtoController.getProduto(id);
        setarCampos(produto);
	}

	//Eventos de botões
	public void salvarProdutoEvent(JTextField tfValor, JButton btnSalvar) {
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codBarras = tfCodigoBarras.getText();
				String id = tfId.getText();
				String nome = tfNome.getText();
				Integer quantidade = Integer.parseInt(tfQuantidade.getText());
				String departamento = cbDepartamento.getSelectedItem() + "";
				if(tfValor.getText() == null) {
					JOptionPane.showMessageDialog(null, "É necessário passar um valor para esse produto!");
					return;
				}
				Double valor = Double.parseDouble(tfValor.getText());
				
				if(codBarras.equals("")) {
					JOptionPane.showMessageDialog(null, "É necessário preencher o campo de código de barras!");
				} else {
					Produto produto = new Produto();
					produto.setCodBarras(codBarras);
					produto.setDepartamento("");
					produto.setNome(nome);
					produto.setValor(valor);
					produto.setQuantidade(quantidade);
					produto.setDepartamento(departamento);
					produtoController = new ProdutoController();
					int cadastrou = produtoController.salvarProduto(produto);
					
					if(cadastrou == 1) {
						JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
						limparCampos();
					} else {
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar produto.");
					}
				}
			}
		});
	}
	
	public void editarProdutoEvent(JTextField tfValor) {
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codBarras = tfCodigoBarras.getText();
				Integer id = Integer.parseInt(tfId.getText());
				String nome = tfNome.getText();
				Integer quantidade = Integer.parseInt(tfQuantidade.getText());
				String departamento = cbDepartamento.getSelectedItem() + "";
				if(tfValor.getText() == null) {
					JOptionPane.showMessageDialog(null, "É necessário passar um valor para esse produto!");
					return;
				}
				Double valor = Double.parseDouble(tfValor.getText());
				
				if(codBarras.equals("")) {
					JOptionPane.showMessageDialog(null, "É necessário preencher o campo de código de barras!");
				} else {
				
				Produto produto = new Produto();
				produto.setId(id);
				produto.setCodBarras(codBarras);
				produto.setDepartamento("");
				produto.setNome(nome);
				produto.setValor(valor);
				produto.setQuantidade(quantidade);
				produto.setDepartamento(departamento);
				
				produtoController = new ProdutoController();
				boolean cadastrou = produtoController.editarProduto(produto);
				
				if(cadastrou) {
					JOptionPane.showMessageDialog(null, "Produto editado com sucesso.");
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar produto.");
				}
				
				}
			}
		});
	}

	public void fecharTelaEvent(JButton btnNewButton) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}

	public void pesquisarProdutoEvent(JButton btnPesquisar) {
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoBarras = JOptionPane.showInputDialog("Informe o código de barras");
				produtoController = new ProdutoController();
				Produto produto = produtoController.getProduto(codigoBarras);
				if(produto == null) {
					JOptionPane.showMessageDialog(null, "Produto não existe!");
					return;
				}
				tfCodigoBarras.setText(produto.getCodBarras());
				tfId.setText(produto.getId()+"");
				tfNome.setText(produto.getNome());
				tfQuantidade.setText(produto.getQuantidade()+"");
				tfValor.setText(produto.getValor()+"");
				btnEditar.setEnabled(true);
				btnSalvar.setEnabled(false);
			}
		});
	}
	
	public void tabelaEvent() {
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	selecionarNaTabela();
		    }
		});
	}
	
}