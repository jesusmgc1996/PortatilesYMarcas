package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ContinenteController;
import controller.MarcaController;
import controller.PaisController;
import model.Continente;
import model.Marca;
import model.Pais;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionDeMarcas extends JPanel {
	
	private JTextField jtfId;
	private JTextField jtfDenominacion;
	private JComboBox<Pais> jcbPais;
	private JComboBox<Continente> jcbContinente;
	private Marca m = null;

	/**
	 * Crea el panel
	 */
	public GestionDeMarcas(Marca m) {
		this.m = m;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
//		gridBagLayout.columnWidths = new int[]{0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Marcas");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Denominación:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDenominacion = new JTextField();
		GridBagConstraints gbc_jtfDenominacion = new GridBagConstraints();
		gbc_jtfDenominacion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDenominacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDenominacion.gridx = 1;
		gbc_jtfDenominacion.gridy = 2;
		add(jtfDenominacion, gbc_jtfDenominacion);
		jtfDenominacion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Continente:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbContinente = new JComboBox<Continente>();
		jcbContinente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPaises(((Continente) jcbContinente.getSelectedItem()).getId());			
			}
		});
		GridBagConstraints gbc_jcbContinente = new GridBagConstraints();
		gbc_jcbContinente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbContinente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbContinente.gridx = 1;
		gbc_jcbContinente.gridy = 3;
		add(jcbContinente, gbc_jcbContinente);
		
		JLabel lblNewLabel_4 = new JLabel("País:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbPais = new JComboBox<Pais>();
		GridBagConstraints gbc_jcbPais = new GridBagConstraints();
		gbc_jcbPais.insets = new Insets(0, 0, 5, 0);
		gbc_jcbPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbPais.gridx = 1;
		gbc_jcbPais.gridy = 4;
		add(jcbPais, gbc_jcbPais);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 5;
		add(btnGuardar, gbc_btnGuardar);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		
		getContinentes();
		cargar();

	}
	
	/**
	 * Método para obtener los continentes
	 */
	private void getContinentes() {
		jcbContinente.removeAllItems();
		List<Continente> l = ContinenteController.findAll();
		for (Continente o : l) {
			jcbContinente.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los paises
	 */
	private void getPaises(int id) {
		jcbPais.removeAllItems();
		List<Pais> l = PaisController.findByContinente(id);
		for (Pais o : l) {
			jcbPais.addItem(o);
		}
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void cargar() {
		jtfId.setText("" + m.getId());
		jtfDenominacion.setText(m.getDenominacion());
		for (int i = 0; i < jcbContinente.getItemCount(); i++) {
			Continente c = jcbContinente.getItemAt(i);
			if (c.getId() == m.getPais().getContinente().getId()) {
				jcbContinente.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < jcbPais.getItemCount(); i++) {
			Pais p = jcbPais.getItemAt(i);
			if (p.getId() == m.getPais().getId()) {
				jcbPais.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * Método para guardar un registro
	 */
	private void guardar() {
		m.setId(Integer.parseInt(jtfId.getText()));
		if (jtfDenominacion.getText().length() < 2) {
			JOptionPane.showMessageDialog(null, "La denominación es incorrecta");
			return;
		}
		else {
			m.setDenominacion(jtfDenominacion.getText());
		}
		m.setPais((Pais) jcbPais.getSelectedItem());
		MarcaController.modificar(m);
	}

}
