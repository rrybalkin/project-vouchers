package view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.util.HashMap;
import java.util.Set;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import model.Search;

import core.Controller;
import core.Tools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Talons {

	private JFrame frame;
	private static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static JLabel label_5;
	private static JLabel label_6;
	private static JLabel label_7;
	private static JLabel label_11;
	private static JLabel label_12;
	private static JLabel label_13;
	private static JList list;
	private static HashMap<String, Integer> visitors;
	private static DefaultListModel listModel = new DefaultListModel();
	private static int visitor_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Talons window = new Talons();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Talons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		list = new JList(listModel);
		// �������� ������ �����������
		visitors = Controller.searchAll();
		Set<String> keys = visitors.keySet();
		for (String str : Tools.sortOfAlphabet(keys)) {
			listModel.addElement(str);
		}

		frame = new JFrame();
		frame.setTitle("\u0422\u0430\u043B\u043E\u043D\u044B");
		frame.setBounds(100, 100, 762, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
					.addGap(21))
		);

		JLabel label_4 = new JLabel(
				"\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u043E\u043D\u043D\u043E\u0435 \u043E\u043A\u043D\u043E \u0434\u043B\u044F \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u043E\u0433\u043E \u043F\u043E\u0441\u0435\u0442\u0438\u0442\u0435\u043B\u044F");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		label_5 = new JLabel("\u0424\u0418\u041E: ");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

		label_6 = new JLabel(
				"\u041E\u0431\u0449\u0435\u0435 \u043A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043E\u0431\u0435\u0434\u043E\u0432:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));

		label_7 = new JLabel(
				"\u041E\u0431\u0449\u0435\u0435 \u043A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0443\u0436\u0438\u043D\u043E\u0432:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_8 = new JLabel(
				"\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u043E\u0431\u0435\u0434\u043E\u0432 \u0438 \u0443\u0436\u0438\u043D\u043E\u0432 \u0434\u043B\u044F \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u043E\u0433\u043E \u043F\u043E\u0441\u0435\u0442\u0438\u0442\u0435\u043B\u044F:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));

		final JRadioButton radioButton = new JRadioButton("\u041E\u0431\u0435\u0434");
		radioButton.setSelected(true);

		final JRadioButton radioButton_1 = new JRadioButton(
				"\u0423\u0436\u0438\u043D");
		
		// ����� �������������
		radioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				radioButton.setSelected(false);
			}
		});
		
		radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				radioButton_1.setSelected(false);
			}
		});

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel label_9 = new JLabel(
				"\u041A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E:");

		JButton button = new JButton(
				"\u041F\u0440\u0438\u0431\u0430\u0432\u0438\u0442\u044C");
		

		JLabel label_10 = new JLabel(
				"\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u043E\u043D\u043D\u043E\u0435 \u043E\u043A\u043D\u043E \u0434\u043B\u044F \u0432\u0441\u0435\u0445 \u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u0435\u043B\u0435\u0439");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 14));

		label_11 = new JLabel(
				"\u041E\u0431\u0449\u0435\u0435 \u043A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043F\u043E\u0441\u0435\u0442\u0438\u0442\u0435\u043B\u0435\u0439:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));

		label_12 = new JLabel(
				"\u041E\u0431\u0449\u0435\u0435 \u043A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043E\u0431\u0435\u0434\u043E\u0432:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));

		label_13 = new JLabel(
				"\u041E\u0431\u0449\u0435\u0435 \u043A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0443\u0436\u0438\u043D\u043E\u0432:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_15 = new JLabel(
				"\u0421\u0431\u0440\u043E\u0441 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u0438 \u0434\u043B\u044F \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u043E\u0433\u043E \u043F\u043E\u0441\u0435\u0442\u0438\u0442\u0435\u043B\u044F:");
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton button_3 = new JButton(
				"\u0421\u0431\u0440\u043E\u0441 \u043E\u0431\u0435\u0434\u043E\u0432");

		JButton button_4 = new JButton(
				"\u0421\u0431\u0440\u043E\u0441 \u0443\u0436\u0438\u043D\u043E\u0432");

		JButton button_5 = new JButton(
				"\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u043F\u043E\u0441\u0435\u0442\u0438\u0442\u0435\u043B\u044F");

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_7)
								.addComponent(label_6)
								.addComponent(label_5)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(49)
							.addComponent(label_4))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addComponent(label_8))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_13)
								.addComponent(label_12)
								.addComponent(label_11)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(55)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(115)
									.addComponent(button))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_4, 164, 164, 164)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(radioButton)
											.addGap(58)
											.addComponent(radioButton_1))))
								.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_10))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_4)
							.addGap(18)
							.addComponent(button_5)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addGap(18)
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_7)
					.addGap(23)
					.addComponent(label_8)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton_1)
						.addComponent(radioButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button)
					.addGap(34)
					.addComponent(label_15)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_3)
						.addComponent(button_5)
						.addComponent(button_4))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(label_10)
					.addGap(27)
					.addComponent(label_11)
					.addGap(18)
					.addComponent(label_12)
					.addGap(18)
					.addComponent(label_13)
					.addGap(56))
		);
		panel_1.setLayout(gl_panel_1);

		textField = new JTextField();
		
		// ������������ ��������� ������� � ���������� ����� � ������������ � ��������� ������
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				listModel.clear();
				String mask = textField.getText();
				if (mask.length() != 0) {
					visitors = Controller.search(mask);
					Set<String> keys = visitors.keySet();
					for (String key : Tools.sortOfAlphabet(keys)) {
						listModel.addElement(key);
					}
				} else {
					visitors = Controller.searchAll();
					Set<String> keys = visitors.keySet();
					for (String key : Tools.sortOfAlphabet(keys)) {
						listModel.addElement(key);
					}
				}
			}
		});
		textField.setColumns(10);

		JLabel label = new JLabel(
				"\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D\u0438\u0435 \u043D\u043E\u0432\u043E\u0433\u043E \u043F\u043E\u0441\u0435\u0442\u0438\u0442\u0435\u043B\u044F:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel(
				"\u0424\u0430\u043C\u0438\u043B\u0438\u044F:");

		JLabel label_2 = new JLabel("\u0418\u043C\u044F:");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel label_3 = new JLabel(
				"\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E:");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(35)
									.addComponent(label))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label_2)
										.addComponent(label_3))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 3, Short.MAX_VALUE))
										.addComponent(textField_1, Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))))))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
					.addGap(1))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(97)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(67))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		scrollPane.setViewportView(list);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
		
		String[] info = Search.getInfoAboutAll();
		label_11.setText("����� ����������� �����������:  "+info[0]);
		label_12.setText("����� ����������� ������:  "+info[1]);
		label_13.setText("����� ����������� ������:  "+info[2]);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u0418\u043D\u0441\u0442\u0440\u0443\u043C\u0435\u043D\u0442\u044B");
		menuBar.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0438 \u043E\u0431\u043D\u0443\u043B\u0438\u0442\u044C");
		menuItem_3.addActionListener(new ActionListener() {
			// ��������� ��� ���������� �� ����� � ���� � �������� ��������
			public void actionPerformed(ActionEvent arg0) {
				String fileName = null;
				fileName = JOptionPane.showInputDialog(
						"������� �����_��� (������ '�������_2012'):", fileName);
				if (fileName != null) {
					boolean answer = Controller.saveMonthInfo(Tools.delSpaces(fileName));
					if (answer) {
						// ���� ��� ������ �����������, �� ���������� ��� ����� � �����
						Controller.removeLunchs();
						Controller.removeDinners();
						refresh();
					}
					else {
						JOptionPane
								.showMessageDialog(
										null,
										Controller.getErrorForSaveMonthInfo(),
										"������!", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane
					.showMessageDialog(
							null,
							"���������� ������ �����_���!",
							"������!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u041F\u043E\u043C\u043E\u0449\u044C");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u0418\u043D\u0441\u0442\u0440\u0443\u043A\u0446\u0438\u044F \u043F\u043E \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0435");
		
		menu_1.add(menuItem_2);

		// ������� ���� �� ������� �����
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					int index = list.locationToIndex(arg0.getPoint());
					String key = listModel.getElementAt(index).toString();
					visitor_id = visitors.get(key);
					String[] info = Controller.getInfoByID(visitor_id);
					label_5.setText("���:  " + info[0]);
					label_6.setText("����� ����������� ������:  " + info[1]);
					label_7.setText("����� ����������� ������:  " + info[2]);
				}
			}
		});

		// ���������� ������ ������������
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstname = Tools.delSpaces(textField_2.getText());
				String lastname = Tools.delSpaces(textField_1.getText());
				String middlename = Tools.delSpaces(textField_3.getText());
				
				Controller.addNewVisitor(Tools.toUpperCase(firstname), Tools.toUpperCase(lastname), Tools.toUpperCase(middlename));
				refresh();
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		
		// �������� ����������
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.removeVisitor(visitor_id);
				refresh();
			}
		});
		
		// ������� ������ �����������
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = Integer.parseInt(textField_4.getText());
				if (radioButton.isSelected()){
					Controller.addCountLunch(visitor_id, count);
				}
				if (radioButton_1.isSelected()){
					Controller.addCountDinner(visitor_id, count);
				}
				textField_4.setText("");
				singleRefresh();
				refresh();
			}
		});
		
		// ������ ��� ��������� ������ ������������
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.removeCountLunch(visitor_id);
				singleRefresh();
				refresh();
			}
		});
		
		// ������ ������ ���� ������
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.removeCountDinner(visitor_id);
				singleRefresh();
				refresh();
			}
		});
		
		// ���� - ������ � ���������
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
				.showMessageDialog(
						null,"��������� ��� ����� �������!"+
				"\n\n1. ���������� ������ ������������!\n ����� �������� ������ ���������� � ���� ������ ����������:\n"+
				"- ��������� ��� �������, ��� � �������� � ��������������� ����� (� ������ ���� �����)\n"+
				"- ����� �����, ������ ������ \"��������\"\n"+
				"- ��� ���� ���������� ����� ���� ��������� ���������� � ����� ���������� ����� �������� � ���� ������\n"+
				"\n2. ����� ������������ � ���������� �����!\n ��� ������ ���������� ����������:\n"+
				"- ���� ������ ������� ��� ��� � ���� ������, ���� ����� ������� �� ������ ��������-����������,\n"+
				"- �������� ������ �� ��� ���, ����� ����� ��������� ���� � ������� �� ���� ����������,\n"+
				"� ������ ���������� � ��� ���, ������������ ������ � ������\n"+
				"��� ���������� ���������� ����� ����� � ������ ����������� ������ ��� ������ ��� ����� ���������� ����������:\n"+
				"- ������� ��� ������ (���� ��� ����) �������� ����� � ��������������� �����������\n"+
				"- ����� � ���� \"�����������\" ������ ����������� ����������� ����� � ������ ������ \"���������\".\n"+
				" � ���������� ������ ����� ��������� ��������������� ��������� � ����� ���������� � ����������.\n"+
				"\n3. �������� ������������ �� ���� ������!\n ��� �������� ������������ ������������ �� ���� ������ ����������:\n"+
				"- ����� ��� � ������ �����������, ����� �������� ������ ��� �������� ��� ��������\n"+
				"- ����� ������ ������ \"������� ����������\"\n\n"+
				"4. �������� ����������� ����� ��� ������ ������������!\n ��� �������� ����������� ����� ������ ������������ ����������:\n"+
				"- ������� ������� ������������ � ������ �����������, ������� ������ �� ��� ���\n"+
				"- ����� ����� ������ ������ \"����� ������\" ��� \"����� ������\" ��������������\n"+
				"- ��� ���� ��������������� ��������� ������ ������������ � ���� � ����������� �� ���� ������������\n\n"+
				"5. �������� ����������� ����� ��� ���� �������������!\n"+
				"��� �������� ����������� ����� ��� ���� ������������� ����������:\n"+
				"- ������� ������� \"�����������\" � ����� ������� ����\n"+
				"- ������� �������������� \"����� ������\" ��� \"����� ������\"\n"+
				"- ��� ���� ��������������� ��������� ������ ������������ � ���� � ����� �����������"+
				"\n\n��������� ���������: �������� ����� �������������\nE-mail: ramzes19901224@mail.ru ���� ����� ��������!",
						"MegaPower Talons!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}
	//����� ��� ���������� ����
	private static void refresh(){
		String[] info = Search.getInfoAboutAll();
		label_11.setText("����� ����������� �����������:  "+info[0]);
		label_12.setText("����� ����������� ������:  "+info[1]);
		label_13.setText("����� ����������� ������:  "+info[2]);
		textField.setText("");
		
		listModel.clear();
		visitors = Controller.searchAll();
		Set<String> keys = visitors.keySet();
		for (String key : Tools.sortOfAlphabet(keys))
			listModel.addElement(key);
	}
	
	private static void singleRefresh() {
		String[] info = Controller.getInfoByID(visitor_id);
		label_5.setText("���:  " + info[0]);
		label_6.setText("����� ����������� ������:  " + info[1]);
		label_7.setText("����� ����������� ������:  " + info[2]);
	}
}
