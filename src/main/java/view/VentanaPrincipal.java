package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PortatilController;
import controller.MarcaController;
import model.Portatil;
import model.Marca;

import java.awt.BorderLayout;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfModelo;
	private JTextField jtfSerial;
	private JTextField jtfFecha;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnVer;
	private JButton btnTotal;
	private JCheckBox jckVenta;
	private JRadioButton jrbUno;
	private JRadioButton jrbDos;
	private JRadioButton jrbTres;
	private JRadioButton jrbCuatro;
	private JComboBox<Marca> jcbMarca;
	private ButtonGroup btnGroup = new ButtonGroup();

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Portatil o = PortatilController.getPrimero();

	/**
	 * Carga la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = PortatilController.getPrimero();
				cargar();
			}
		});
		toolBar.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = PortatilController.getAnterior(Integer.parseInt(jtfId.getText()));
				cargar();
			}
		});
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = PortatilController.getSiguiente(Integer.parseInt(jtfId.getText()));
				cargar();
			}
		});
		toolBar.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = PortatilController.getUltimo();
				cargar();
			}
		});
		toolBar.add(btnUltimo);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		toolBar.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		toolBar.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de Ordenadores Portátiles");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.gridwidth = 3;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbMarca = new JComboBox<Marca>();
		GridBagConstraints gbc_jcbMarca = new GridBagConstraints();
		gbc_jcbMarca.gridwidth = 2;
		gbc_jcbMarca.weightx = 1.0;
		gbc_jcbMarca.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMarca.gridx = 1;
		gbc_jcbMarca.gridy = 2;
		panel.add(jcbMarca, gbc_jcbMarca);
		
		btnVer = new JButton("Ver Marca");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNuevoDialogo(o.getMarca());
			}
		});
		GridBagConstraints gbc_btnVer = new GridBagConstraints();
		gbc_btnVer.anchor = GridBagConstraints.EAST;
		gbc_btnVer.insets = new Insets(0, 0, 5, 0);
		gbc_btnVer.gridx = 3;
		gbc_btnVer.gridy = 2;
		panel.add(btnVer, gbc_btnVer);
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.gridwidth = 3;
		gbc_jtfModelo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 3;
		panel.add(jtfModelo, gbc_jtfModelo);
		jtfModelo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Serial Number:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfSerial = new JTextField();
		GridBagConstraints gbc_jtfSerial = new GridBagConstraints();
		gbc_jtfSerial.gridwidth = 3;
		gbc_jtfSerial.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSerial.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSerial.gridx = 1;
		gbc_jtfSerial.gridy = 4;
		panel.add(jtfSerial, gbc_jtfSerial);
		jtfSerial.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Num procesadores:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridheight = 2;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jrbUno = new JRadioButton("1 Procesador");
		GridBagConstraints gbc_jrbUno = new GridBagConstraints();
		gbc_jrbUno.anchor = GridBagConstraints.WEST;
		gbc_jrbUno.insets = new Insets(0, 0, 5, 5);
		gbc_jrbUno.gridx = 1;
		gbc_jrbUno.gridy = 5;
		panel.add(jrbUno, gbc_jrbUno);
		btnGroup.add(jrbUno);
		
		jrbDos = new JRadioButton("2 Procesadores");
		GridBagConstraints gbc_jrbDos = new GridBagConstraints();
		gbc_jrbDos.gridwidth = 2;
		gbc_jrbDos.anchor = GridBagConstraints.WEST;
		gbc_jrbDos.insets = new Insets(0, 0, 5, 5);
		gbc_jrbDos.gridx = 2;
		gbc_jrbDos.gridy = 5;
		panel.add(jrbDos, gbc_jrbDos);
		btnGroup.add(jrbDos);
		
		jrbTres = new JRadioButton("3 Procesadores");
		GridBagConstraints gbc_jrbTres = new GridBagConstraints();
		gbc_jrbTres.anchor = GridBagConstraints.WEST;
		gbc_jrbTres.insets = new Insets(0, 0, 5, 5);
		gbc_jrbTres.gridx = 1;
		gbc_jrbTres.gridy = 6;
		panel.add(jrbTres, gbc_jrbTres);
		btnGroup.add(jrbTres);
		
		jrbCuatro = new JRadioButton("4 Procesadores");
		GridBagConstraints gbc_jrbCuatro = new GridBagConstraints();
		gbc_jrbCuatro.gridwidth = 2;
		gbc_jrbCuatro.anchor = GridBagConstraints.WEST;
		gbc_jrbCuatro.insets = new Insets(0, 0, 5, 5);
		gbc_jrbCuatro.gridx = 2;
		gbc_jrbCuatro.gridy = 6;
		panel.add(jrbCuatro, gbc_jrbCuatro);
		btnGroup.add(jrbCuatro);
		
		JLabel lblNewLabel_6 = new JLabel("Vendido:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jckVenta = new JCheckBox("");
		jckVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jckVenta.isSelected()) {
					jtfFecha.setEnabled(true);
				}
				else {
					jtfFecha.setEnabled(false);
					jtfFecha.setText(null);
				}
			}
		});
		GridBagConstraints gbc_jckVenta = new GridBagConstraints();
		gbc_jckVenta.anchor = GridBagConstraints.WEST;
		gbc_jckVenta.insets = new Insets(0, 0, 5, 5);
		gbc_jckVenta.gridx = 1;
		gbc_jckVenta.gridy = 7;
		panel.add(jckVenta, gbc_jckVenta);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de venta:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 3;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 8;
		panel.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		btnTotal = new JButton("Número total de portátiles");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Total de portátiles: " + PortatilController.getTotal());
			}
		});
		GridBagConstraints gbc_btnTotal = new GridBagConstraints();
		gbc_btnTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnTotal.gridwidth = 4;
		gbc_btnTotal.gridx = 0;
		gbc_btnTotal.gridy = 9;
		panel.add(btnTotal, gbc_btnTotal);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 10;
		panel.add(panel_1, gbc_panel_1);
		
		getMarcas();
		cargar();
	}
	
	/**
	 * Método para abrir un nuevo diálogo 
	 */
	public void abrirNuevoDialogo(Marca m) {
		JDialog dialogo = new JDialog();
		dialogo.setResizable(true);
		dialogo.setTitle("Gestión de marcas");
		dialogo.setContentPane(new GestionDeMarcas(m));
		dialogo.pack();
		dialogo.setModal(true);
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		dialogo.setVisible(true);
	}
	
	/**
	 * Método para obtener las marcas
	 */
	private void getMarcas() {
		jcbMarca.removeAllItems();
		List<Marca> l = MarcaController.findAll();
		for (Marca o : l) {
			jcbMarca.addItem(o);
		}
	}
	
	/**
	 * Método para cargar un registro
	 */
	private void cargar() {
		if (o != null) {
			jtfId.setText("" + o.getId());
			for (int i = 0; i < jcbMarca.getItemCount(); i++) {
				Marca m = jcbMarca.getItemAt(i);
				if (m.getId() == o.getMarca().getId()) {
					jcbMarca.setSelectedIndex(i);
				}
			}
			jtfModelo.setText(o.getModelo());
			jtfSerial.setText(o.getSn());
			if (o.getNumProcesadores() == 1) {
				jrbUno.setSelected(true);
			}
			else if (o.getNumProcesadores() == 2) {
				jrbDos.setSelected(true);
			}
			else if (o.getNumProcesadores() == 3) {
				jrbTres.setSelected(true);
			}
			else {
				jrbCuatro.setSelected(true);
			}
			jckVenta.setSelected(o.getVendido());
			if (jckVenta.isSelected()) {
				jtfFecha.setEnabled(true);
			}
			else {
				jtfFecha.setEnabled(false);
			}
			if (o.getFechaVenta() != null) {
				jtfFecha.setText(sdf.format(o.getFechaVenta()));
			}
			else {
				jtfFecha.setText(null);
			}
		}
		if (PortatilController.getAnterior(Integer.parseInt(jtfId.getText())) == null) {
			btnPrimero.setEnabled(false);
			btnAnterior.setEnabled(false);
		}
		else {
			btnPrimero.setEnabled(true);
			btnAnterior.setEnabled(true);
		}
		if (PortatilController.getSiguiente(Integer.parseInt(jtfId.getText())) == null) {
			btnUltimo.setEnabled(false);
			btnSiguiente.setEnabled(false);
		}
		else {
			btnUltimo.setEnabled(true);
			btnSiguiente.setEnabled(true);
		}
	}
	
	/**
	 * Método para guardar un registro
	 */
	private void guardar() {
		Portatil o = new Portatil();
		o.setId(Integer.parseInt(jtfId.getText()));
		o.setMarca((Marca) jcbMarca.getSelectedItem());
		o.setModelo(jtfModelo.getText());
		int noDigito = 0;
		for(int i = 0; i < jtfSerial.getText().length(); i++) {
			if (!Character.isDigit(jtfSerial.getText().charAt(i))) {
				noDigito++;
			}
		}
		if (noDigito > 0 || jtfSerial.getText().length() < 4) {
			JOptionPane.showMessageDialog(null, "El Serial Number introducido es incorrecto");
			return;
		}
		else {
			o.setSn(jtfSerial.getText());
		}
		if (jrbUno.isSelected()) {
			o.setNumProcesadores(1);
		}
		else if (jrbDos.isSelected()) {
			o.setNumProcesadores(2);
		}
		else if (jrbTres.isSelected()) {
			o.setNumProcesadores(3);
		}
		else {
			o.setNumProcesadores(4);
		}
		o.setVendido(jckVenta.isSelected());
		if (!jtfFecha.getText().isEmpty()) {
			try {
				o.setFechaVenta(sdf.parse(jtfFecha.getText()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			o.setFechaVenta(null);
		}
		PortatilController.guardar(o);
	}
	
	/**
	 * Método para limpiar los datos
	 */
	private void limpiar() {
		jtfId.setText("0");
		jtfModelo.setText(null);
		jtfSerial.setText(null);
		jrbUno.setSelected(false);
		jrbDos.setSelected(false);
		jrbTres.setSelected(false);
		jrbCuatro.setSelected(false);
		jckVenta.setSelected(false);
		jtfFecha.setText(null);
	}
	
	/**
	 * Método para eliminar un registro
	 */
	private void eliminar() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?") == JOptionPane.YES_OPTION) {
			PortatilController.eliminar(o);
			int id = Integer.parseInt(jtfId.getText());
			o = PortatilController.getAnterior(id);
			if (o != null) {
				cargar();
			}
			else {
				o = PortatilController.getSiguiente(id);
				if (o != null) {
					cargar();
				}
				else {
					limpiar();
				}
			}
		}
	}

}
