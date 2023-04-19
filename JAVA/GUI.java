import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {
	static GUI window;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;
	private JTextField login_textF, loginPwd_pField;
	private JTextField joinId_textF, joinPwd_pField1, joinPwd_pField2, joinName_textF, checkJumin_textF, joinHp_textF, joinAddr_textF, joinEmail_textF, joinJumin_textF; 
	private JTextField chanId_textF, chanPwd_textF, chanPwd_pField1, chanPwd_pField2;
	private JTextField findJumin_textF, findHp_textF;
	private JTextField result_textF, resultHp_textF, resultJumin_textF;
	private JTextField treatReason_textF;
	private JTextField check_textF, checkHp_textF;
	private ImageIcon check_q, out;
	private Icon w;
	private ImageIcon s = new ImageIcon("imgs\\s.png");
	private JTextField phyCheckJumin_textF, phyCheckHp_textF, phyCheck_textF;
	private JTextField visitJumin_textF, visitHp_textF, visit_textF;
	private JTextField surgeryJumin_textF, surgeryHp_textF, surgery_textF;
	String DEP_NAME, DOC_NAME, date, loginId, reason;
	String selectedSchedule;
	String selectedDoc, selectedDept, dateStr, treatReason;
	JComboBox<String> phySelect_comB1;

	public GUI() {
		initialize();
	}

	private void initialize() {
		GHosDBHandler gdb = new GHosDBHandler();

		frame = new JFrame();
		frame.setSize(400, 600);
		frame.setTitle("�ڽ��� ���ﺴ��");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//////////////////////////////////////// �гε� ////////////////////////////////////////
		JPanel visit_panel = new JPanel();
		JPanel surgery_panel = new JPanel();
		JPanel phyCheck_panel = new JPanel();
		JPanel physical_panel = new JPanel();
		JPanel treatReserv_panel = new JPanel();
		JPanel reserv_panel = new JPanel();	
		JPanel result_panel = new JPanel();
		JPanel check_panel = new JPanel();
		JPanel main_panel = new JPanel();
		JPanel join_panel = new JPanel();
		JPanel change_panel = new JPanel();
		JPanel find_panel = new JPanel();
		JPanel login_panel = new JPanel();
		
		//////////////////////////////////////// �α��ν� �ٸ� �г� �Ⱥ��̰� �� ////////////////////////////////////////
		physical_panel.setVisible(false);  treatReserv_panel.setVisible(false);  reserv_panel.setVisible(false);
		result_panel.setVisible(false);    check_panel.setVisible(false);        main_panel.setVisible(false);
		join_panel.setVisible(false);      change_panel.setVisible(false);       find_panel.setVisible(false);
		phyCheck_panel.setVisible(false);  visit_panel.setVisible(false);        surgery_panel.setVisible(false);
		
		
		//////////////////////////////////////// �ǰ������̷� �г� ////////////////////////////////////////
		phyCheck_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(phyCheck_panel);
		phyCheck_panel.setLayout(null);
		
		JLabel phyCheckH_lab = new JLabel("�ǰ����� ��� ��ȸ");
		phyCheckH_lab.setBounds(44, 10, 300, 40);
		phyCheckH_lab.setHorizontalAlignment(SwingConstants.CENTER);
		phyCheckH_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		phyCheck_panel.add(phyCheckH_lab);
		
		JLabel phyCheckJumin_lab = new JLabel("�ֹε�Ϲ�ȣ(-�����ؼ� �Է�)");
		phyCheckJumin_lab.setHorizontalAlignment(SwingConstants.LEFT);
		phyCheckJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheckJumin_lab.setBounds(50, 80, 195, 35);
		phyCheck_panel.add(phyCheckJumin_lab);
		
		JLabel phyCheckHp_lab = new JLabel("�ڵ��� ��ȣ(-�����ؼ� �Է�)");
		phyCheckHp_lab.setHorizontalAlignment(SwingConstants.LEFT);
		phyCheckHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheckHp_lab.setBounds(50, 165, 227, 35);
		phyCheck_panel.add(phyCheckHp_lab);
		
		JLabel phyCheckDetail_lab = new JLabel("�������");
		phyCheckDetail_lab.setHorizontalAlignment(SwingConstants.LEFT);
		phyCheckDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheckDetail_lab.setBounds(50, 260, 87, 35);
		phyCheck_panel.add(phyCheckDetail_lab);
		
		phyCheckJumin_textF = new JTextField();
		phyCheckJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheckJumin_textF.setColumns(10);
		phyCheckJumin_textF.setBounds(50, 120, 285, 35);
		phyCheck_panel.add(phyCheckJumin_textF);
		
		phyCheckHp_textF = new JTextField();
		phyCheckHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheckHp_textF.setColumns(10);
		phyCheckHp_textF.setBounds(50, 205, 285, 35);
		phyCheck_panel.add(phyCheckHp_textF);
		
		
		phyCheck_textF = new JTextField();
		phyCheck_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheck_textF.setColumns(10);
		phyCheck_textF.setBounds(197, 294, 135, 35);
		phyCheck_panel.add(phyCheck_textF);
		
		JComboBox<String> phyCheckCul_comb = new JComboBox<String>(gdb.columnNames);
		phyCheckCul_comb.setBackground(Color.WHITE);
		phyCheckCul_comb.setBounds(50, 295, 135, 35);
		phyCheck_panel.add(phyCheckCul_comb);
		phyCheck_textF.addKeyListener(new KeyAdapter() {
			String str, ser, ssn, tel;			
			@Override
			public void keyReleased(KeyEvent e) {
					tel = phyCheckHp_textF.getText().trim();
					ssn = phyCheckJumin_textF.getText().trim();
					str = (String)phyCheckCul_comb.getSelectedItem().toString();
					if(str.equals("�����Ͻ�")) {
						str = "E_DATE";
					}else if(str.equals("����")) {
						str = "HEIGHT";
					}else if(str.equals("ü��")) {
						str = "WEIGHT";
					}else if(str.equals("����")) {
						str = "BP";
					}else if(str.equals("��������")) {
						str = "FBS";
					}
					ser = phyCheck_textF.getText();			
					if(ser != null) ser = ser.trim();
					if(ser.length() !=0) {
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.phyCheckCom(str, ser, ssn, tel);
					}else if(ser.length() == 0) {
						result_textF.setText("");
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.phyCheckCom(str, ser, ssn, tel);
					}
			}		
		}); 

		JButton phyCheck_butt = new JButton("��  ȸ");
		phyCheck_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn, tel, ser;
				if(e.getSource() == phyCheck_butt) {
					ssn = phyCheckJumin_textF.getText().trim();
					tel = phyCheckHp_textF.getText().trim();
					ser = phyCheck_textF.getText();
					if(ssn.isEmpty()) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkSSN(ssn)) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(tel.isEmpty()) {
						gdb.showBox("�ڵ��� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkTEL(tel)) {
						gdb.showBox("�ڵ��� ��ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!tel.isEmpty()) {
						if(gdb.identify(loginId, ssn, tel) == false) {
							gdb.showBox("ID�� ȸ�������� ��ġ���� �ʽ��ϴ�.", "�ڽ��� ���ﺴ��");
						}else {
							gdb.dftmodel.setRowCount(0);
							gdb.dftmodel.setColumnCount(0);
							if(ser.isEmpty()) {
								gdb.phyCheckShow(ssn, tel);	
							}
						}	
					}
				}				
			}
		});
		phyCheck_butt.setOpaque(false);
		phyCheck_butt.setForeground(new Color(0, 128, 255));
		phyCheck_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheck_butt.setFocusPainted(false);
		phyCheck_butt.setContentAreaFilled(false);
		phyCheck_butt.setBorderPainted(false);
		phyCheck_butt.setBackground(Color.WHITE);
		phyCheck_butt.setBounds(143, 245, 97, 30);
		phyCheck_panel.add(phyCheck_butt);
		
		JButton phyCheckBack_butt = new JButton("�ڷΰ���");
		phyCheckBack_butt.setBorderPainted(false);
		phyCheckBack_butt.setContentAreaFilled(false);
		phyCheckBack_butt.setFocusPainted(false);
		phyCheckBack_butt.setOpaque(false);
		phyCheckBack_butt.setBackground(new Color(255, 255, 255));
		phyCheckBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phyCheckHp_textF.setText("");
				phyCheckJumin_textF.setText("");
				phyCheck_textF.setText("");
				gdb.dftmodel.setRowCount(0);
				gdb.dftmodel.setColumnCount(0);
				phyCheckCul_comb.removeAllItems();
				phyCheck_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		
		phyCheckBack_butt.setForeground(new Color(0, 128, 255));
		phyCheckBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyCheckBack_butt.setBounds(148, 521, 97, 30);
		phyCheck_panel.add(phyCheckBack_butt);
		
		JTable phyCheck_table = new JTable(gdb.dftmodel);
		phyCheck_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		phyCheck_table.setBackground(Color.WHITE);
		phyCheck_table.setBounds(50, 340, 285, 165);
		JScrollPane phyCheck_sp = new JScrollPane();
		phyCheck_sp.setBounds(50, 340, 285, 165);
		phyCheck_panel.add(phyCheck_sp);
		phyCheck_panel.add(phyCheck_table);
		phyCheck_sp.setViewportView(phyCheck_table);
		
		JLabel phyCheck_lab = new JLabel("");
		phyCheck_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		phyCheck_lab.setBounds(0, 0, 384, 561);
		phyCheck_panel.add(phyCheck_lab);
		
		//////////////////////////////////////////////// ó���̷� �г� ///////////////////////////////////////
		
		visit_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(visit_panel);
		visit_panel.setLayout(null);
		
		JLabel visitH_lab = new JLabel("ó���̷� ��ȸ");
		visitH_lab.setBounds(44, 10, 300, 40);
		visitH_lab.setHorizontalAlignment(SwingConstants.CENTER);
		visitH_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		visit_panel.add(visitH_lab);
		
		JLabel visitJumin_lab = new JLabel("�ֹε�Ϲ�ȣ(-�����ؼ� �Է�)");
		visitJumin_lab.setHorizontalAlignment(SwingConstants.LEFT);
		visitJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visitJumin_lab.setBounds(50, 80, 195, 35);
		visit_panel.add(visitJumin_lab);
		
		JLabel visitHp_lab = new JLabel("�ڵ��� ��ȣ(-�����ؼ� �Է�)");
		visitHp_lab.setHorizontalAlignment(SwingConstants.LEFT);
		visitHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visitHp_lab.setBounds(50, 165, 201, 35);
		visit_panel.add(visitHp_lab);
		
		JLabel visitDetail_lab = new JLabel("ó���̷�");
		visitDetail_lab.setHorizontalAlignment(SwingConstants.LEFT);
		visitDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visitDetail_lab.setBounds(50, 260, 87, 35);
		visit_panel.add(visitDetail_lab);
		
		visitJumin_textF = new JTextField();
		visitJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visitJumin_textF.setColumns(10);
		visitJumin_textF.setBounds(50, 120, 285, 35);
		visit_panel.add(visitJumin_textF);
		
		visitHp_textF = new JTextField();
		visitHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visitHp_textF.setColumns(10);
		visitHp_textF.setBounds(50, 205, 285, 35);
		visit_panel.add(visitHp_textF);
		
		visit_textF = new JTextField();
		visit_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visit_textF.setColumns(10);
		visit_textF.setBounds(200, 294, 135, 35);
		visit_panel.add(visit_textF);
		
		JComboBox<String> visitCul_comb = new JComboBox<String>(gdb.columnNames);
		visitCul_comb.setBackground(Color.WHITE);
		visitCul_comb.setBounds(50, 295, 135, 35);
		visit_panel.add(visitCul_comb);
		visit_textF.addKeyListener(new KeyAdapter() {
			String str, ser, ssn, tel;			
			@Override
			public void keyReleased(KeyEvent e) {
					tel = visitHp_textF.getText().trim();
					ssn = visitJumin_textF.getText().trim();
					str = (String)visitCul_comb.getSelectedItem().toString();
					if(str.equals("ó���")) {
						str = "PR_NAME";
					}else if(str.equals("ó���Ͻ�")) {
						str = "PR_DATE";
					}else if(str.equals("�뷮")) {
						str = "DOSE";
					}else if(str.equals("�ϼ�")) {
						str = "DAYS";
					}else if(str.equals("Ƚ��")) {
						str = "NUM";
					}else if(str.equals("ó����")) {
						str = "DOC_NAME";
					}
					ser = visit_textF.getText();			
					if(ser != null) ser = ser.trim();
					if(ser.length() !=0) {
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.visitCom(str, ser, ssn, tel);
					}else if(ser.length() == 0) {
						visit_textF.setText("");
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.visitCom(str, ser, ssn, tel);
				}
			}
		}); 
		
		JButton visitBack_butt = new JButton("�ڷΰ���");
		visitBack_butt.setBorderPainted(false);
		visitBack_butt.setContentAreaFilled(false);
		visitBack_butt.setFocusPainted(false);
		visitBack_butt.setOpaque(false);
		visitBack_butt.setBackground(new Color(255, 255, 255));
		visitBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visitHp_textF.setText("");
				visitJumin_textF.setText("");
				visit_textF.setText("");
				gdb.dftmodel.setRowCount(0);
				gdb.dftmodel.setColumnCount(0);
				visitCul_comb.removeAllItems();
				visit_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		
		JButton visit_butt = new JButton("��  ȸ");
		visit_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn, tel, ser;
				if(e.getSource() == visit_butt) {
					ssn = visitJumin_textF.getText().trim();
					tel = visitHp_textF.getText().trim();
					ser = visit_textF.getText();
					if(ssn.isEmpty()) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkSSN(ssn)) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(tel.isEmpty()) {
						gdb.showBox("�ڵ��� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkTEL(tel)) {
						gdb.showBox("�ڵ��� ��ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!tel.isEmpty()) {
						if(gdb.identify(loginId, ssn, tel) == false) {
							gdb.showBox("ID�� ȸ�������� ��ġ���� �ʽ��ϴ�.", "�ڽ��� ���ﺴ��");
						}else {
							gdb.dftmodel.setRowCount(0);
							gdb.dftmodel.setColumnCount(0);
							if(ser.isEmpty()) {
								gdb.visitShow(ssn, tel);	
							}
						}	
					}
				}				
			}
		});
		visit_butt.setOpaque(false);
		visit_butt.setForeground(new Color(0, 128, 255));
		visit_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visit_butt.setFocusPainted(false);
		visit_butt.setContentAreaFilled(false);
		visit_butt.setBorderPainted(false);
		visit_butt.setBackground(Color.WHITE);
		visit_butt.setBounds(143, 245, 97, 30);
		visit_panel.add(visit_butt);
		
		
		visitBack_butt.setForeground(new Color(0, 128, 255));
		visitBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		visitBack_butt.setBounds(148, 516, 97, 30);
		visit_panel.add(visitBack_butt);
		
		JTable visit_table = new JTable(gdb.dftmodel);
		visit_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		visit_table.setBackground(Color.WHITE);
		visit_table.setBounds(50, 340, 285, 165);
		JScrollPane visit_sp = new JScrollPane();
		visit_sp.setBounds(50, 340, 285, 165);
		visit_panel.add(visit_sp);
		visit_panel.add(visit_table);
		visit_sp.setViewportView(visit_table);
		
		JLabel visit_lab = new JLabel("");
		visit_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		visit_lab.setBounds(0, 0, 384, 561);
		visit_panel.add(visit_lab);
		
		//////////////////////////////////////////////// �����̷� �г� ////////////////////////////////////////
		surgery_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(surgery_panel);
		surgery_panel.setLayout(null);
		
		JLabel surgeryH_lab = new JLabel("�����̷� ��ȸ");
		surgeryH_lab.setBounds(44, 10, 300, 40);
		surgeryH_lab.setHorizontalAlignment(SwingConstants.CENTER);
		surgeryH_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		surgery_panel.add(surgeryH_lab);
		
		JLabel surgeryJumin_lab = new JLabel("�ֹε�Ϲ�ȣ(-�����ؼ� �Է�)");
		surgeryJumin_lab.setHorizontalAlignment(SwingConstants.LEFT);
		surgeryJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgeryJumin_lab.setBounds(50, 80, 195, 35);
		surgery_panel.add(surgeryJumin_lab);
		
		JLabel surgeryHp_lab = new JLabel("�ڵ��� ��ȣ(-�����ؼ� �Է�)");
		surgeryHp_lab.setHorizontalAlignment(SwingConstants.LEFT);
		surgeryHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgeryHp_lab.setBounds(50, 165, 201, 35);
		surgery_panel.add(surgeryHp_lab);
		
		JLabel surgeryDetail_lab = new JLabel("�����̷�");
		surgeryDetail_lab.setHorizontalAlignment(SwingConstants.LEFT);
		surgeryDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgeryDetail_lab.setBounds(50, 260, 87, 35);
		surgery_panel.add(surgeryDetail_lab);
		
		surgeryJumin_textF = new JTextField();
		surgeryJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgeryJumin_textF.setColumns(10);
		surgeryJumin_textF.setBounds(50, 120, 285, 35);
		surgery_panel.add(surgeryJumin_textF);
		
		surgeryHp_textF = new JTextField();
		surgeryHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgeryHp_textF.setColumns(10);
		surgeryHp_textF.setBounds(50, 205, 285, 35);
		surgery_panel.add(surgeryHp_textF);
		
		surgery_textF = new JTextField();
		surgery_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgery_textF.setColumns(10);
		surgery_textF.setBounds(197, 294, 135, 35);
		surgery_panel.add(surgery_textF);
		
		JComboBox<String> surgeryCul_comb = new JComboBox<String>(gdb.columnNames);
		surgeryCul_comb.setBackground(Color.WHITE);
		surgeryCul_comb.setBounds(50, 295, 135, 35);
		surgery_panel.add(surgeryCul_comb);
		surgery_textF.addKeyListener(new KeyAdapter() {
			String str, ser, ssn, tel;			
			@Override
			public void keyReleased(KeyEvent e) {
					tel = surgeryHp_textF.getText().trim();
					ssn = surgeryJumin_textF.getText().trim();
					str = (String)surgeryCul_comb.getSelectedItem().toString();
					if(str.equals("������")) {
						str = "S_NAME";
					}else if(str.equals("���ܸ�")) {
						str = "DIS_NAME";
					}else if(str.equals("�ǻ��")) {
						str = "DOC_NAME";
					}else if(str.equals("�����Ͻ�")) {
						str = "S_DATE";
					}
					ser = surgery_textF.getText();			
					if(ser != null) ser = ser.trim();
					if(ser.length() !=0) {
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.surgeryCom(str, ser, ssn, tel);
					}else if(ser.length() == 0) {
						visit_textF.setText("");
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.surgeryCom(str, ser, ssn, tel);
				}
			}
		}); 
		
		JButton surgeryBack_butt = new JButton("�ڷΰ���");
		surgeryBack_butt.setBorderPainted(false);
		surgeryBack_butt.setContentAreaFilled(false);
		surgeryBack_butt.setFocusPainted(false);
		surgeryBack_butt.setOpaque(false);
		surgeryBack_butt.setBackground(new Color(255, 255, 255));
		surgeryBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				surgeryHp_textF.setText("");
				surgeryJumin_textF.setText("");
				surgery_textF.setText("");
				gdb.dftmodel.setRowCount(0);
				gdb.dftmodel.setColumnCount(0);
				surgeryCul_comb.removeAllItems();
				surgery_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
	
		JButton surgery_butt = new JButton("��  ȸ");
		surgery_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn, tel, ser;
				if(e.getSource() == surgery_butt) {
					ssn = surgeryJumin_textF.getText().trim();
					tel = surgeryHp_textF.getText().trim();
					ser = surgery_textF.getText();
					if(ssn.isEmpty()) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkSSN(ssn)) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(tel.isEmpty()) {
						gdb.showBox("�ڵ��� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkTEL(tel)) {
						gdb.showBox("�ڵ��� ��ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!tel.isEmpty()) {
						if(gdb.identify(loginId, ssn, tel) == false) {
							gdb.showBox("ID�� ȸ�������� ��ġ���� �ʽ��ϴ�.", "�ڽ��� ���ﺴ��");
						}else {
							gdb.dftmodel.setRowCount(0);
							gdb.dftmodel.setColumnCount(0);
							if(ser.isEmpty()) {
								gdb.surgeryShow(ssn, tel);	
							}
						}	
					}
				}				
			}
		});
			
		surgery_butt.setOpaque(false);
		surgery_butt.setForeground(new Color(0, 128, 255));
		surgery_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgery_butt.setFocusPainted(false);
		surgery_butt.setContentAreaFilled(false);
		surgery_butt.setBorderPainted(false);
		surgery_butt.setBackground(Color.WHITE);
		surgery_butt.setBounds(143, 245, 97, 30);
		surgery_panel.add(surgery_butt);

		surgeryBack_butt.setForeground(new Color(0, 128, 255));
		surgeryBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		surgeryBack_butt.setBounds(148, 521, 97, 30);
		surgery_panel.add(surgeryBack_butt);
		
		JTable surgery_table = new JTable(gdb.dftmodel);
		surgery_table.setBackground(Color.WHITE);
		surgery_table.setBounds(50, 340, 285, 165);
		JScrollPane surgery_sp = new JScrollPane();
		surgery_sp.setBounds(50, 340, 285, 165);
		surgery_panel.add(surgery_sp);
		surgery_panel.add(surgery_table);
		surgery_sp.setViewportView(surgery_table);
		
		JLabel surgery_lab = new JLabel("");
		surgery_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		surgery_lab.setBounds(0, 0, 384, 561);
		surgery_panel.add(surgery_lab);
		
		//////////////////////////////////////// ������ ��ȸ �г� ////////////////////////////////////////
		result_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(result_panel);
		result_panel.setLayout(null);
		
		JLabel resultH_lab = new JLabel("������ ��ȸ");
		resultH_lab.setHorizontalAlignment(SwingConstants.CENTER);
		resultH_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		resultH_lab.setBounds(56, 15, 270, 45);
		result_panel.add(resultH_lab);
		
		JLabel resultJumin_lab = new JLabel("�ֹε�Ϲ�ȣ(-�����ؼ� �Է�)");
		resultJumin_lab.setHorizontalAlignment(SwingConstants.LEFT);
		resultJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultJumin_lab.setBounds(50, 80, 195, 35);
		result_panel.add(resultJumin_lab);
		
		JLabel resultHp_lab = new JLabel("�ڵ��� ��ȣ(-�����ؼ� �Է�)");
		resultHp_lab.setHorizontalAlignment(SwingConstants.LEFT);
		resultHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultHp_lab.setBounds(50, 165, 201, 35);
		result_panel.add(resultHp_lab);
		
		JLabel resultDetail_lab = new JLabel("������");
		resultDetail_lab.setHorizontalAlignment(SwingConstants.LEFT);
		resultDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultDetail_lab.setBounds(50, 260, 87, 35);
		result_panel.add(resultDetail_lab);
		
		resultJumin_textF = new JTextField();
		resultJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultJumin_textF.setColumns(10);
		resultJumin_textF.setBounds(50, 120, 285, 35);
		result_panel.add(resultJumin_textF);
		
		resultHp_textF = new JTextField();
		resultHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultHp_textF.setColumns(10);
		resultHp_textF.setBounds(50, 205, 285, 35);
		result_panel.add(resultHp_textF);
				
				
		JComboBox<String> resultCul_comb = new JComboBox<String>(gdb.columnNames);
		resultCul_comb.setBackground(Color.WHITE);
		resultCul_comb.setBounds(50, 295, 135, 35);
		result_panel.add(resultCul_comb);
		
		result_textF = new JTextField();
		result_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		result_textF.setColumns(10);
		result_textF.setBounds(197, 294, 135, 35);
		result_panel.add(result_textF);
		result_textF.addKeyListener(new KeyAdapter() {
			String str, ser, ssn, tel;			
			@Override
			public void keyReleased(KeyEvent e) {
					tel = resultHp_textF.getText().trim();
					ssn = resultJumin_textF.getText().trim();
					str = (String)resultCul_comb.getSelectedItem().toString();
					if(str.equals("�����")) {
						str = "DEP_NAME";
					}else if(str.equals("�ǻ��")) {
						str = "DOC_NAME";
					}else if(str.equals("���ܸ�")) {
						str = "DIS_NAME";
					}else if(str.equals("�����Ͻ�")) {
						str = "TR_DATE";
					}
					ser = result_textF.getText();			
					if(ser != null) ser = ser.trim();
					if(ser.length() !=0) {
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.resultCom(str, ser, ssn, tel);
					}else if(ser.length() == 0) {
						result_textF.setText("");
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.resultCom(str, ser, ssn, tel);
				}
			}
		}); 
		
		JButton resultBack_butt = new JButton("�ڷΰ���");
		resultBack_butt.setBorderPainted(false);
		resultBack_butt.setContentAreaFilled(false);
		resultBack_butt.setFocusPainted(false);
		resultBack_butt.setOpaque(false);
		resultBack_butt.setBackground(new Color(255, 255, 255));
		resultBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultHp_textF.setText("");
				resultJumin_textF.setText("");
				result_textF.setText("");
				gdb.dftmodel.setRowCount(0);
				gdb.dftmodel.setColumnCount(0);
				resultCul_comb.removeAllItems();
				result_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		
		JButton resultChe_butt = new JButton("��  ȸ");
		resultChe_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn, tel;
				if(e.getSource() == resultChe_butt) {
					gdb.dftmodel.setRowCount(0);
					gdb.dftmodel.setColumnCount(0);
					ssn = resultJumin_textF.getText().trim();
					tel = resultHp_textF.getText().trim();
					if(ssn.isEmpty()) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkSSN(ssn)) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(tel.isEmpty()) {
						gdb.showBox("�ڵ��� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkTEL(tel)) {
						gdb.showBox("�ڵ��� ��ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!tel.isEmpty()) {
						if(gdb.identify(loginId, ssn, tel) == false) {
							gdb.showBox("ID�� ȸ�������� ��ġ���� �ʽ��ϴ�.", "�ڽ��� ���ﺴ��");
						}else {
							result_textF.setText("");
							gdb.resultShow(ssn, tel);	
						}	
					}
				}				
			}
		});
		
		resultChe_butt.setBorderPainted(false);
		resultChe_butt.setContentAreaFilled(false);
		resultChe_butt.setFocusPainted(false);
		resultChe_butt.setOpaque(false);
		resultChe_butt.setBackground(new Color(255, 255, 255));
		resultChe_butt.setForeground(new Color(0, 128, 255));
		resultChe_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultChe_butt.setBounds(143, 245, 97, 30);
		result_panel.add(resultChe_butt);
		
		resultBack_butt.setForeground(new Color(0, 128, 255));
		resultBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		resultBack_butt.setBounds(148, 521, 97, 30);
		result_panel.add(resultBack_butt);
		
		JTable resultRs_table = new JTable(gdb.dftmodel);
		resultRs_table.setBackground(new Color(255, 255, 255));
		resultRs_table.setBounds(50, 340, 285, 165);
		JScrollPane resultRs_sp = new JScrollPane();
		resultRs_sp.setBounds(50, 340, 285, 165);
		result_panel.add(resultRs_sp);
		result_panel.add(resultRs_table);
		resultRs_sp.setViewportView(resultRs_table);
		
		JLabel result_lab = new JLabel("");
		result_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		result_lab.setBounds(0, 0, 384, 561);
		result_panel.add(result_lab);
		
		//////////////////////////////////////// ���� ��ȸ �� ��� �г� ////////////////////////////////////////
		check_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(check_panel);
		check_panel.setLayout(null);
		
		JLabel checkHead_lab = new JLabel("���� ��ȸ �� ���");
		checkHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		checkHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		checkHead_lab.setBounds(56, 15, 270, 45);
		check_panel.add(checkHead_lab);
		
		JLabel checkJumin_lab = new JLabel("�ֹε�Ϲ�ȣ(-�����ؼ� �Է�)");
		checkJumin_lab.setHorizontalAlignment(SwingConstants.LEFT);
		checkJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkJumin_lab.setBounds(50, 80, 195, 35);
		check_panel.add(checkJumin_lab);
		
		JLabel checkHp_lab = new JLabel("�ڵ��� ��ȣ(-�����ؼ� �Է�)");
		checkHp_lab.setHorizontalAlignment(SwingConstants.LEFT);
		checkHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkHp_lab.setBounds(50, 165, 201, 35);
		check_panel.add(checkHp_lab);
		
		JLabel checkDetail_lab = new JLabel("���೻��");
		checkDetail_lab.setHorizontalAlignment(SwingConstants.LEFT);
		checkDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkDetail_lab.setBounds(50, 260, 87, 35);
		check_panel.add(checkDetail_lab);
		
		checkJumin_textF = new JTextField();
		checkJumin_textF.setBounds(50, 120, 285, 35);
		check_panel.add(checkJumin_textF);
		checkJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkJumin_textF.setColumns(10);
		
		checkHp_textF = new JTextField();
		checkHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkHp_textF.setColumns(10);
		checkHp_textF.setBounds(50, 205, 285, 35);
		check_panel.add(checkHp_textF);
		
		JComboBox<String> checkCul_comb = new JComboBox<String>(gdb.columnNames);
		checkCul_comb.setBackground(Color.WHITE);
		checkCul_comb.setBounds(50, 295, 135, 35);
		check_panel.add(checkCul_comb);
		
		check_textF = new JTextField();
		check_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		check_textF.setColumns(10);
		check_textF.setBounds(197, 294, 135, 35);
		check_panel.add(check_textF);
		check_textF.addKeyListener(new KeyAdapter() {
			String str, ser, ssn, tel;			
			@Override
			public void keyReleased(KeyEvent e) {
					tel = checkHp_textF .getText().trim();
					ssn = checkJumin_textF.getText().trim();
					str = (String)checkCul_comb.getSelectedItem().toString();
					if(str.equals("�����")) {
						str = "DEP_NAME";
					}else if(str.equals("�ǻ��")) {
						str = "DOC_NAME";
					}else if(str.equals("�����Ͻ�")) {
						str = "R_DATE";
					}
					ser = check_textF.getText();			
					if(ser != null) ser = ser.trim();
					if(ser.length() !=0) {
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.reservCom(str, ser, ssn, tel);
					}else if(ser.length() == 0) {
						check_textF.setText("");
						gdb.dftmodel.setRowCount(0);
						gdb.dftmodel.setColumnCount(0);
						gdb.reservCom(str, ser, ssn, tel);
				}
			}
		}); 
		
		JButton checkCan_butt = new JButton("�������");
		checkCan_butt.setBorderPainted(false);
		checkCan_butt.setContentAreaFilled(false);
		checkCan_butt.setFocusPainted(false);
		checkCan_butt.setOpaque(false);
		checkCan_butt.setBackground(new Color(255, 255, 255));
		checkCan_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ssn, tel;
				ssn = checkJumin_textF.getText().trim();
				tel = checkHp_textF.getText().trim();
				int answer = JOptionPane.showConfirmDialog(null, "���� ����Ͻðڽ��ϱ�?", "Cancel",
						JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, check_q);
					if (answer == JOptionPane.YES_OPTION) {
						gdb.reservDEL(DEP_NAME, DOC_NAME, date);
						JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.");
						gdb.scheduleRes(DEP_NAME, DOC_NAME, date);
						gdb.dftmodel.setColumnCount(0);
						gdb.dftmodel.setRowCount(0);
						gdb.reservShow(ssn, tel);
						
					}
			}
		});
		check_q = new ImageIcon("imgs\\q1.png");
		
		JButton chechChe_butt = new JButton("��  ȸ");
		chechChe_butt.setBorderPainted(false);
		chechChe_butt.setContentAreaFilled(false);
		chechChe_butt.setFocusPainted(false);
		chechChe_butt.setOpaque(false);
		chechChe_butt.setBackground(new Color(255, 255, 255));	
		chechChe_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chechChe_butt.setForeground(new Color(0, 128, 255));
		chechChe_butt.setBounds(143, 245, 97, 30);
		check_panel.add(chechChe_butt);
		chechChe_butt.addActionListener(new ActionListener() {
			String ssn, tel;
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == chechChe_butt) {
					gdb.dftmodel.setColumnCount(0);
					gdb.dftmodel.setRowCount(0);
					ssn = checkJumin_textF.getText().trim();
					tel = checkHp_textF.getText().trim();
					if(ssn.isEmpty()) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkSSN(ssn)) {
						gdb.showBox("�ֹε�Ϲ�ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(tel.isEmpty()) {
						gdb.showBox("�ڵ��� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!gdb.checkTEL(tel)) {
						gdb.showBox("�ڵ��� ��ȣ�� �ٽ� Ȯ�����ּ���", "�ڽ��� ���ﺴ��");
					}else if(!tel.isEmpty()) {
						if(gdb.identify(loginId, ssn, tel) == false){
							gdb.showBox("ID�� ȸ�������� ��ġ���� �ʽ��ϴ�.", "�ڽ��� ���ﺴ��");
						}else {
							gdb.reservShow(ssn, tel);
							checkCan_butt.setEnabled(true);
						}
					}
				}			
			}
		});
		
		checkCan_butt.setEnabled(false);
		checkCan_butt.setForeground(new Color(0, 128, 255));
		checkCan_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkCan_butt.setBounds(237, 516, 97, 30);
		check_panel.add(checkCan_butt);
		chechChe_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCan_butt.setEnabled(true);
			}
		});
		
		JButton checkBack_butt = new JButton("�ڷΰ���");
		checkBack_butt.setBorderPainted(false);
		checkBack_butt.setContentAreaFilled(false);
		checkBack_butt.setFocusPainted(false);
		checkBack_butt.setOpaque(false);
		checkBack_butt.setBackground(new Color(255, 255, 255));
		checkBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkJumin_textF.setText("");
				checkHp_textF.setText("");
				check_textF.setText("");
				gdb.dftmodel.setRowCount(0);
				gdb.dftmodel.setColumnCount(0);
				checkCul_comb.removeAllItems();
				checkCan_butt.setEnabled(false);
				check_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		checkBack_butt.setForeground(new Color(0, 128, 255));
		checkBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		checkBack_butt.setBounds(50, 516, 97, 30);
		check_panel.add(checkBack_butt);
		
		JTable checkRs_table = new JTable(gdb.dftmodel);
		checkRs_table.setBackground(Color.WHITE);
		checkRs_table.setBounds(50, 337, 285, 169);
		JScrollPane checkRs_sp = new JScrollPane();
		checkRs_sp.setBounds(50, 337, 285, 169);
		check_panel.add(checkRs_sp);
		check_panel.add(checkRs_table);
		checkRs_sp.setViewportView(checkRs_table);
		checkRs_table.addMouseListener(new MouseAdapter() { 
		      public void mouseClicked(MouseEvent e){
					int i = checkRs_table.getSelectedRow();
					DEP_NAME = (String) checkRs_table.getValueAt(i, 0);
					DOC_NAME = (String) checkRs_table.getValueAt(i, 1);
					date = (String) checkRs_table.getValueAt(i, 2);
		      	}
		      });
		
		JLabel check_lab = new JLabel("");
		check_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		check_lab.setBounds(0, 0, 384, 561);
		check_panel.add(check_lab);
		
		////////////////////////////////////////�������� �г� ////////////////////////////////////////
		treatReserv_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(treatReserv_panel);
		treatReserv_panel.setLayout(null);
		
		JLabel treatHead_lab = new JLabel("��������");
		treatHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		treatHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		treatHead_lab.setBounds(54, 25, 270, 45);
		treatReserv_panel.add(treatHead_lab);
		
		JLabel treatSelect_lab1 = new JLabel("����� ����");
		treatSelect_lab1.setForeground(new Color(0, 0, 0));
		treatSelect_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSelect_lab1.setBounds(50, 100, 85, 25);
		treatReserv_panel.add(treatSelect_lab1);
		
		JLabel treatSelect_lab2 = new JLabel("�Ƿ��� ����");
		treatSelect_lab2.setForeground(Color.BLACK);
		treatSelect_lab2.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSelect_lab2.setBounds(214, 100, 85, 25);
		treatReserv_panel.add(treatSelect_lab2);
		
		JLabel treatSelect_lab3 = new JLabel("�Ͻ� ����");
		treatSelect_lab3.setForeground(Color.BLACK);
		treatSelect_lab3.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSelect_lab3.setBounds(50, 226, 85, 25);
		treatReserv_panel.add(treatSelect_lab3);
		
		JLabel treatDetail_lab = new JLabel("���� ���� ���� (30�� �̳��� �ۼ�)");
		treatDetail_lab.setForeground(Color.BLACK);
		treatDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatDetail_lab.setBounds(50, 341, 269, 25);
		treatReserv_panel.add(treatDetail_lab);
		
		reserv_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(reserv_panel);
		reserv_panel.setLayout(null);
		
		JComboBox<String> treatSelect_comB1 = new JComboBox<String>(gdb.vector1);
		treatSelect_comB1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSelect_comB1.setBackground(new Color(255, 255, 255));
		treatSelect_comB1.setBounds(50, 135, 120, 35);
		treatReserv_panel.add(treatSelect_comB1);
		treatSelect_comB1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		selectedDept = (String)treatSelect_comB1.getSelectedItem().toString();
				gdb.getDoc(selectedDept);
				}
		});
		
		JComboBox<String> treatSelect_comB2 = new JComboBox<String>(gdb.vector2);
		treatSelect_comB2.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSelect_comB2.setBackground(Color.WHITE);
		treatSelect_comB2.setBounds(214, 135, 120, 35);
		treatReserv_panel.add(treatSelect_comB2);
		treatSelect_comB2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				selectedDoc = (String)treatSelect_comB2.getSelectedItem().toString();		
				gdb.getTRDate(selectedDoc);
				}
		}); 
		
		JComboBox<String> treatSelect_comB3 = new JComboBox<String>(gdb.vector3);
		treatSelect_comB3.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSelect_comB3.setBackground(Color.WHITE);
		treatSelect_comB3.setBounds(50, 261, 284, 35);
		treatReserv_panel.add(treatSelect_comB3);
		treatSelect_comB3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				dateStr = (String)treatSelect_comB3.getSelectedItem().toString();
				}
		});  
		
		treatReason_textF = new JTextField();
		treatReason_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatReason_textF.setBounds(50, 376, 284, 114);
		treatReserv_panel.add(treatReason_textF);
		treatReason_textF.setColumns(10);
		
		
		JButton treatSign_butt = new JButton("�����û");
		treatSign_butt.setBorderPainted(false);
		treatSign_butt.setContentAreaFilled(false);
		treatSign_butt.setFocusPainted(false);
		treatSign_butt.setOpaque(false);
		treatSign_butt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int answer = JOptionPane.showConfirmDialog(null, "�̴�� �����Ͻðڽ��ϱ�?", "�����û",
					JOptionPane.YES_NO_OPTION, JOptionPane.CLOSED_OPTION, s);
			if(answer == JOptionPane.YES_OPTION) {
				if(e.getSource() == treatSign_butt)
				treatReason = treatReason_textF.getText().trim();
				gdb.insertReserv(loginId, selectedDept, selectedDoc, dateStr, treatReason);
				gdb.showBox("������ �Ϸ�Ǿ����ϴ�.", "�ڽ��� ���ﺴ��");
				gdb.deleteD_SCHE(selectedDept, selectedDoc, dateStr);
				treatReason_textF.setText("");
				treatReserv_panel.setVisible(false);
				reserv_panel.setVisible(true);
				}
			}
		}); 
		
		JButton treatBack_butt = new JButton("�ڷΰ���");
		treatBack_butt.setBorderPainted(false);
		treatBack_butt.setContentAreaFilled(false);
		treatBack_butt.setFocusPainted(false);
		treatBack_butt.setOpaque(false);
		treatBack_butt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			treatReason_textF.setText("");
			treatReserv_panel.setVisible(false);
			reserv_panel.setVisible(true);
			}
		});
		
		treatSign_butt.setForeground(new Color(0, 128, 255));
		treatSign_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatSign_butt.setBackground(Color.WHITE);
		treatSign_butt.setBounds(237, 506, 97, 30);
		treatReserv_panel.add(treatSign_butt);
		treatBack_butt.setForeground(new Color(0, 128, 255));
		treatBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		treatBack_butt.setBackground(Color.WHITE);
		treatBack_butt.setBounds(50, 506, 97, 30);
		treatReserv_panel.add(treatBack_butt);
		
		JLabel treatReserv_lab = new JLabel("");
		treatReserv_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		treatReserv_lab.setBounds(0, 0, 384, 561);
		treatReserv_panel.add(treatReserv_lab);

		//////////////////////////////////////// �ǰ����� ���� �г� ////////////////////////////////////////
		physical_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(physical_panel);
		physical_panel.setLayout(null);
		
		JLabel phyHead_lab = new JLabel("�ǰ����� ����");
		phyHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		phyHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		phyHead_lab.setBounds(55, 34, 270, 45);
		physical_panel.add(phyHead_lab);
		
		JLabel phyDetail_lab = new JLabel("�ǰ����� ����");
		phyDetail_lab.setForeground(Color.BLACK);
		phyDetail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyDetail_lab.setBounds(55, 112, 120, 25);
		physical_panel.add(phyDetail_lab);
		
		JLabel phySelect_lab = new JLabel("�Ͻ� ����");
		phySelect_lab.setForeground(Color.BLACK);
		phySelect_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phySelect_lab.setBounds(55, 355, 85, 25);
		physical_panel.add(phySelect_lab);
		
		phySelect_comB1 = new JComboBox<String>();
		phySelect_comB1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phySelect_comB1.setBackground(Color.WHITE);
		phySelect_comB1.setBounds(55, 390, 270, 35);
		physical_panel.add(phySelect_comB1);
		phySelect_comB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedSchedule = (String)phySelect_comB1.getSelectedItem().toString();
				System.out.println(selectedSchedule);
			}
		});
		
		JButton phyBack_butt = new JButton("�ڷΰ���");
		phyBack_butt.setBorderPainted(false);
		phyBack_butt.setContentAreaFilled(false);
		phyBack_butt.setFocusPainted(false);
		phyBack_butt.setOpaque(false);
		phyBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				physical_panel.setVisible(false);
				reserv_panel.setVisible(true);
			}
		});
		
		JButton phySign_butt = new JButton("�����û");
		phySign_butt.setBorderPainted(false);
		phySign_butt.setContentAreaFilled(false);
		phySign_butt.setFocusPainted(false);
		phySign_butt.setOpaque(false);
		phySign_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gdb.insertExam(loginId, selectedSchedule);
				JOptionPane.showMessageDialog(null, "�ǰ����� ������ �Ϸ�Ǿ����ϴ�.");
				phySelect_comB1.removeItem(selectedSchedule);
				physical_panel.setVisible(false);
				reserv_panel.setVisible(true);
			}
		});
		phySign_butt.setForeground(new Color(0, 128, 255));
		phySign_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phySign_butt.setBackground(Color.WHITE);
		phySign_butt.setBounds(228, 504, 97, 30);
		physical_panel.add(phySign_butt);
		phyBack_butt.setForeground(new Color(0, 128, 255));
		phyBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		phyBack_butt.setBackground(Color.WHITE);
		phyBack_butt.setBounds(55, 504, 97, 30);
		physical_panel.add(phyBack_butt);
		
		JTable phy_table = new JTable(gdb.dftmodel2);
		phy_table.setBackground(new Color(255, 255, 255));
		phy_table.setBounds(55, 147, 270, 184);
		JScrollPane phy_sp = new JScrollPane();
		phy_sp.setBounds(55, 147, 270, 184);
		physical_panel.add(phy_sp);
		physical_panel.add(phy_table);
		phy_sp.setViewportView(phy_table);
		
		JLabel physical_lab = new JLabel("");
		physical_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		physical_lab.setBounds(0, 0, 384, 561);
		physical_panel.add(physical_lab);
		
		//////////////////////////////////////// ���� ���� �� �ǰ����� ���� ���� �г� ////////////////////////////////////////
		reserv_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(reserv_panel);
		reserv_panel.setLayout(null);
		
		JLabel reservHead_lab = new JLabel("��   ��");
		reservHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		reservHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		reservHead_lab.setBounds(52, 45, 270, 45);
		reserv_panel.add(reservHead_lab);
		
		JButton reservTreat_butt = new JButton("");
		reservTreat_butt.setIcon(new ImageIcon("imgs\\treat.png"));
		reservTreat_butt.setBorderPainted(false);
		reservTreat_butt.setContentAreaFilled(false);
		reservTreat_butt.setFocusPainted(false);
		reservTreat_butt.setOpaque(false);
		reservTreat_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gdb.getDept();
				reserv_panel.setVisible(false);
				treatReserv_panel.setVisible(true);
			}
		});
		reservTreat_butt.setForeground(new Color(0, 128, 255));
		reservTreat_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 22));
		reservTreat_butt.setBackground(new Color(255, 255, 255));
		reservTreat_butt.setBounds(30, 215, 150, 150);
		reserv_panel.add(reservTreat_butt);
		
		JButton reservPhy_butt = new JButton("");
		reservPhy_butt.setBorderPainted(false);
		reservPhy_butt.setContentAreaFilled(false);
		reservPhy_butt.setFocusPainted(false);
		reservPhy_butt.setOpaque(false);
		reservPhy_butt.setIcon(new ImageIcon("imgs\\phy.png"));
		reservPhy_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserv_panel.setVisible(false);
				physical_panel.setVisible(true);
				gdb.getSchedule(window);
				gdb.examColumns();
			}
		});
		reservPhy_butt.setForeground(new Color(0, 128, 255));
		reservPhy_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 22));
		reservPhy_butt.setBackground(Color.WHITE);
		reservPhy_butt.setBounds(200, 215, 150, 150);
		reserv_panel.add(reservPhy_butt);
		
		JButton reservBack_butt = new JButton("�ڷΰ���");
		reservBack_butt.setBorderPainted(false);
		reservBack_butt.setContentAreaFilled(false);
		reservBack_butt.setFocusPainted(false);
		reservBack_butt.setOpaque(false);
		reservBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserv_panel.setVisible(false);
				main_panel.setVisible(true);
			}
		});
		reservBack_butt.setForeground(new Color(0, 128, 255));
		reservBack_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		reservBack_butt.setBackground(Color.WHITE);
		reservBack_butt.setBounds(139, 500, 97, 35);
		reserv_panel.add(reservBack_butt);
		
		JLabel reserv_lab = new JLabel("");
		reserv_lab.setIcon(new ImageIcon("imgs\\backg.jpg"));
		reserv_lab.setBounds(0, 0, 384, 561);
		reserv_panel.add(reserv_lab);
		
		main_panel.setBackground(new Color(255, 255, 255));
		
		//////////////////////////////////////// �����г� ////////////////////////////////////////
		main_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(main_panel);
		main_panel.setLayout(null);
		
		JLabel mainHome_lab = new JLabel("");
		mainHome_lab.setIcon(new ImageIcon("imgs\\home.png"));
		mainHome_lab.setBounds(5, 5, 50, 50);
		main_panel.add(mainHome_lab);
		
		JLabel mainHead_lab = new JLabel("Kosmo Medical Center");
		mainHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		mainHead_lab.setForeground(Color.BLACK);
		mainHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 18));
		mainHead_lab.setBounds(60, 10, 200, 42);
		main_panel.add(mainHead_lab);
		
		JLabel mainWelceom_lab = new JLabel("�������!");
		mainWelceom_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 30));
		mainWelceom_lab.setForeground(new Color(0, 0, 0));
		mainWelceom_lab.setBounds(20, 77, 148, 74);
		main_panel.add(mainWelceom_lab);
		
		JLabel mainAddr_lab2 = new JLabel("");
		mainAddr_lab2.setIcon(new ImageIcon("imgs\\addr.png"));
		mainAddr_lab2.setBounds(10, 487, 20, 20);
		main_panel.add(mainAddr_lab2);
		
		JLabel mainAddr_lab1 = new JLabel("����Ư���� ��õ�� ���������2�� 123 (08505)");
		mainAddr_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 12));
		mainAddr_lab1.setForeground(new Color(0, 0, 0));
		mainAddr_lab1.setBounds(40, 487, 304, 20);
		main_panel.add(mainAddr_lab1);
		
		JLabel mainTell_lab2 = new JLabel("");
		mainTell_lab2.setIcon(new ImageIcon("imgs\\tel.png"));
		mainTell_lab2.setBounds(10, 511, 20, 20);
		main_panel.add(mainTell_lab2);
		
		JLabel mainTell_lab1 = new JLabel("(02) - 1234 - 5678");
		mainTell_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 12));
		mainTell_lab1.setForeground(new Color(0, 0, 0));
		mainTell_lab1.setBounds(40, 511, 304, 20);
		main_panel.add(mainTell_lab1);
		
		JLabel mainSns_lab2 = new JLabel("");
		mainSns_lab2.setIcon(new ImageIcon("imgs\\sns.png"));
		mainSns_lab2.setBounds(10, 535, 20, 20);
		main_panel.add(mainSns_lab2);
		
		JLabel mainSns_lab1 = new JLabel("KOSMO_MC");
		mainSns_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 12));
		mainSns_lab1.setForeground(new Color(0, 0, 0));
		mainSns_lab1.setBounds(40, 535, 304, 20);
		main_panel.add(mainSns_lab1);
		
		JButton mainCheck_butt = new JButton("");
		mainCheck_butt.setIcon(new ImageIcon("imgs\\check1.jpg"));
		mainCheck_butt.setBorderPainted(false);
		mainCheck_butt.setContentAreaFilled(false);
		mainCheck_butt.setFocusPainted(false);
		mainCheck_butt.setOpaque(false);
		mainCheck_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				check_panel.setVisible(true);
			}
		});
		
		
		JButton mainReserv_butt = new JButton("");
		mainReserv_butt.setIcon(new ImageIcon("imgs\\reserv1.png"));
		mainReserv_butt.setBorderPainted(false);
		mainReserv_butt.setContentAreaFilled(false);
		mainReserv_butt.setFocusPainted(false);
		mainReserv_butt.setOpaque(false);
		mainReserv_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				reserv_panel.setVisible(true);
			}
		});
		mainReserv_butt.setBounds(10, 170, 105, 105);
		main_panel.add(mainReserv_butt);
		
		JButton mainVisit_butt = new JButton("");
		mainVisit_butt.setIcon(new ImageIcon("imgs\\visit.png"));
		mainVisit_butt.setOpaque(false);
		mainVisit_butt.setFocusPainted(false);
		mainVisit_butt.setContentAreaFilled(false);
		mainVisit_butt.setBorderPainted(false);
		mainVisit_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				visit_panel.setVisible(true);
			}
		});
		mainVisit_butt.setBounds(10, 309, 105, 105);
		main_panel.add(mainVisit_butt);
		
		JButton mainSurgery_butt = new JButton("");
		mainSurgery_butt.setIcon(new ImageIcon("imgs\\sur.png"));
		mainSurgery_butt.setOpaque(false);
		mainSurgery_butt.setFocusPainted(false);
		mainSurgery_butt.setContentAreaFilled(false);
		mainSurgery_butt.setBorderPainted(false);
		mainSurgery_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				surgery_panel.setVisible(true);
			}
		});
		mainSurgery_butt.setBounds(264, 309, 105, 105);
		main_panel.add(mainSurgery_butt);
		
		JButton mainPhy_butt = new JButton("");
		mainPhy_butt.setIcon(new ImageIcon("imgs\\phycheck.png"));
		mainPhy_butt.setOpaque(false);
		mainPhy_butt.setFocusPainted(false);
		mainPhy_butt.setContentAreaFilled(false);
		mainPhy_butt.setBorderPainted(false);
		mainPhy_butt.setBounds(132, 309, 105, 105);
		mainPhy_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				phyCheck_panel.setVisible(true);
			}
		});
		
		main_panel.add(mainPhy_butt);		
		mainCheck_butt.setBounds(132, 170, 114, 105);
		main_panel.add(mainCheck_butt);
		
		JButton mainResult_butt = new JButton("");
		mainResult_butt.setIcon(new ImageIcon("imgs\\result1.png"));
		mainResult_butt.setBorderPainted(false);
		mainResult_butt.setContentAreaFilled(false);
		mainResult_butt.setFocusPainted(false);
		mainResult_butt.setOpaque(false);
		mainResult_butt.setBounds(264, 170, 111, 105);
		main_panel.add(mainResult_butt);
		mainResult_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				result_panel.setVisible(true);
			}
		});
		
		JButton mainLogout_butt = new JButton("");
		mainLogout_butt.setToolTipText("�α׾ƿ�");
		mainLogout_butt.setBorderPainted(false);
		mainLogout_butt.setContentAreaFilled(false);
		mainLogout_butt.setFocusPainted(false);
		mainLogout_butt.setOpaque(false);
		mainLogout_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer3 = JOptionPane.showConfirmDialog(null, "���� �α׾ƿ� �Ͻðڽ��ϱ�?", "�α׾ƿ�",
						JOptionPane.CANCEL_OPTION, 
							JOptionPane.QUESTION_MESSAGE,out);
					if (answer3 == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ͽ����ϴ�");
							main_panel.setVisible(false);
							login_panel.setVisible(true);
					}
			}
		});
		out = new ImageIcon("imgs\\out.png");
		
		mainLogout_butt.setIcon(new ImageIcon("imgs\\logout.png"));
		mainLogout_butt.setBounds(329, 5, 50, 50);
		main_panel.add(mainLogout_butt);
		
		JLabel main_lab = new JLabel(new ImageIcon("imgs\\backg.jpg"));
		main_lab.setBackground(new Color(255, 255, 255));
		main_lab.setBounds(0, 0, 384, 476);
		main_panel.add(main_lab);
		
		//////////////////////////////////////// ȸ������ �г� ////////////////////////////////////////
		join_panel.setBackground(new Color(255, 255, 255));
		join_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(join_panel);
		join_panel.setLayout(null);
		
		JLabel joinHead_lab = new JLabel("ȸ������");
		joinHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		joinHead_lab.setForeground(Color.WHITE);
		joinHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		joinHead_lab.setBounds(120, 10, 146, 53);
		join_panel.add(joinHead_lab);
		
		JLabel joinId_lab = new JLabel("*���̵�");
		joinId_lab.setForeground(Color.WHITE);
		joinId_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinId_lab.setBounds(30, 70, 57, 19);
		join_panel.add(joinId_lab);
		
		JLabel joinPwd_lab1 = new JLabel("*��й�ȣ (�ִ� 14��)");
		joinPwd_lab1.setForeground(Color.WHITE);
		joinPwd_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinPwd_lab1.setBounds(30, 135, 146, 19);
		join_panel.add(joinPwd_lab1);
		
		JLabel joinPwd_lab2 = new JLabel("*��й�ȣ Ȯ��");
		joinPwd_lab2.setForeground(Color.WHITE);
		joinPwd_lab2.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinPwd_lab2.setBounds(212, 135, 146, 19);
		join_panel.add(joinPwd_lab2);
		
		JLabel joinName_lab = new JLabel("*��   ��");
		joinName_lab.setForeground(Color.WHITE);
		joinName_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinName_lab.setBounds(30, 200, 57, 19);
		join_panel.add(joinName_lab);
		
		JLabel joinJumin_lab = new JLabel("*�ֹε�Ϲ�ȣ (-�����ؼ� �Է�)");
		joinJumin_lab.setForeground(Color.WHITE);
		joinJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinJumin_lab.setBounds(30, 265, 204, 19);
		join_panel.add(joinJumin_lab);
		
		JLabel joinAddr_lab = new JLabel("*��   ��");
		joinAddr_lab.setForeground(Color.WHITE);
		joinAddr_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinAddr_lab.setBounds(30, 330, 204, 19);
		join_panel.add(joinAddr_lab);
		
		JLabel joinHp_lab = new JLabel("*�ڵ��� ��ȣ (-�����ؼ� �Է�)");
		joinHp_lab.setForeground(Color.WHITE);
		joinHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinHp_lab.setBounds(30, 395, 204, 19);
		join_panel.add(joinHp_lab);
		
		JLabel joinEmail_lab = new JLabel("�̸��� �ּ� (@�����ؼ� �Է�)");
		joinEmail_lab.setForeground(Color.WHITE);
		joinEmail_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinEmail_lab.setBounds(30, 460, 204, 19);
		join_panel.add(joinEmail_lab);
		
		joinId_textF = new JTextField();
		joinId_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinId_textF.setColumns(10);
		joinId_textF.setBounds(30, 95, 136, 27);
		join_panel.add(joinId_textF);
		
		joinPwd_pField1 = new JPasswordField();
		joinPwd_pField1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinPwd_pField1.setBounds(30, 160, 136, 27);
		join_panel.add(joinPwd_pField1);
		
		joinPwd_pField2 = new JPasswordField();
		joinPwd_pField2.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinPwd_pField2.setBounds(212, 160, 136, 27);
		join_panel.add(joinPwd_pField2);
		
		joinName_textF = new JTextField();
		joinName_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinName_textF.setColumns(10);
		joinName_textF.setBounds(30, 225, 136, 27);
		join_panel.add(joinName_textF);
		
		joinJumin_textF = new JTextField();
		joinJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinJumin_textF.setColumns(10);
		joinJumin_textF.setBounds(30, 294, 318, 27);
		join_panel.add(joinJumin_textF);
		
		joinAddr_textF = new JTextField();
		joinAddr_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinAddr_textF.setColumns(10);
		joinAddr_textF.setBounds(30, 355, 318, 27);
		join_panel.add(joinAddr_textF);
		
		joinHp_textF = new JTextField();
		joinHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinHp_textF.setColumns(10);
		joinHp_textF.setBounds(30, 420, 318, 27);
		join_panel.add(joinHp_textF);
		
		joinEmail_textF = new JTextField();
		joinEmail_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinEmail_textF.setColumns(10);
		joinEmail_textF.setBounds(30, 485, 318, 27);
		join_panel.add(joinEmail_textF);
		
		JButton joinJoin_butt = new JButton("���ԿϷ�");		
		joinJoin_butt.setBorderPainted(false);    
		joinJoin_butt.setContentAreaFilled(false); 
		joinJoin_butt.setFocusPainted(false);      
		joinJoin_butt.setOpaque(false);
		joinJoin_butt.setFocusPainted(false);
		joinJoin_butt.addActionListener(new ActionListener() {
			String id, pwd, pwd2, name, ssn, tel, addr, email;
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource() == joinJoin_butt) {
						id = joinId_textF.getText().trim();
						pwd = joinPwd_pField1.getText().trim();
						pwd2 = joinPwd_pField2.getText().trim();
						name = joinName_textF.getText().trim();
						ssn = joinJumin_textF.getText().trim();
						tel = joinHp_textF.getText().trim();
						addr = joinAddr_textF.getText();
						email = joinEmail_textF.getText().trim();
						if(id.isEmpty()){
						gdb.showBox("���̵� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(!id.isEmpty() && gdb.checkId(id) == true) {
							gdb.showBox("�ߺ��� ���̵��Դϴ�", "�ڽ��� ���ﺴ��");
							joinId_textF.setText("");
						}else if(pwd.isEmpty()){ 
							gdb.showBox("��й�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(pwd.length()>=15) {
							gdb.showBox("��й�ȣ�� 14�� �̳��� �Է����ּ���","�ڽ��� ���ﺴ��");
						}else if(pwd2.isEmpty()) {
							gdb.showBox("��й�ȣ Ȯ���� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(!pwd.equals(pwd2)) {
							gdb.showBox("�� ��й�ȣ�� �Է°��� �ٸ��ϴ�", "�ڽ��� ���ﺴ��");
						}else if(name.isEmpty()){
							gdb.showBox("�̸��� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(ssn.isEmpty()){
							gdb.showBox("�ֹι�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(ssn.length() != 14) {
							gdb.showBox("�ֹε�Ϲ�ȣ�� �ٽ� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(!ssn.isEmpty() && gdb.checkSSN(ssn) == true) {
							gdb.showBox("���Ե� �̷��� �ֽ��ϴ�. IDã�⸦ �������ּ���", "�ڽ��� ���ﺴ��");
						}else if(addr.isEmpty()){
							gdb.showBox("�ּҸ� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(tel.isEmpty()){
							gdb.showBox("�޴�����ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(!tel.startsWith("010")) {
							gdb.showBox("'010' ���� �����ϴ� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(tel.length() != 13){
							gdb.showBox("�޴�����ȣ�� �ٽ� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(!tel.isEmpty() && gdb.checkTEL(tel) == true) {					
							gdb.showBox("���Ե� �̷��� �ֽ��ϴ�. IDã�⸦ �������ּ���", "�ڽ��� ���ﺴ��");
						}else if(!tel.isEmpty()) {	
							gdb.insertPatient(id, pwd, name, ssn, tel, addr, email);
							JOptionPane.showMessageDialog(null, "ȯ���մϴ�.", "�ڽ��� ���ﺴ��", JOptionPane.INFORMATION_MESSAGE, w);
							loginId = id;

							joinId_textF.setText("");
							joinPwd_pField1.setText("");
							joinPwd_pField2.setText("");
							joinName_textF.setText("");
							joinJumin_textF.setText("");
							joinHp_textF.setText("");
							joinAddr_textF.setText("");
							joinEmail_textF.setText("");
							
							join_panel.setVisible(false);
							main_panel.setVisible(true);
						}
					}	
				}catch(Exception ee) {}
			}
		});
		w = new ImageIcon("imgs\\w.png");
		joinJoin_butt.setForeground(new Color(255, 255, 255));
		joinJoin_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		joinJoin_butt.setBounds(140, 525, 97, 27);
		join_panel.add(joinJoin_butt);
		
		JButton joinBack_butt = new JButton("");
		joinBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinId_textF.setText("");
				joinPwd_pField1.setText("");
				joinPwd_pField2.setText("");
				joinName_textF.setText("");
				joinJumin_textF.setText("");
				joinHp_textF.setText("");
				joinAddr_textF.setText("");
				joinEmail_textF.setText("");
				
				join_panel.setVisible(false);
				login_panel.setVisible(true);
			}
		});
		joinBack_butt.setIcon(new ImageIcon("imgs\\back.png"));
		joinBack_butt.setOpaque(false);
		joinBack_butt.setFocusPainted(false);
		joinBack_butt.setContentAreaFilled(false);
		joinBack_butt.setBorderPainted(false);
		joinBack_butt.setBounds(322, 10, 50, 50);
		join_panel.add(joinBack_butt);
		
		JLabel join_lab = new JLabel("");
		join_lab.setIcon(new ImageIcon("imgs\\loginBG.jpg"));
		join_lab.setBounds(0, 0, 384, 561);
		join_panel.add(join_lab);
		
		//////////////////////////////////////// ��й�ȣ �缳�� �г� ////////////////////////////////////////
		change_panel.setBackground(new Color(255, 255, 255));
		change_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(change_panel);
		change_panel.setLayout(null);
		
		JLabel chanHead_lab = new JLabel("�����ȣ �缳��");
		chanHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		chanHead_lab.setForeground(Color.WHITE);
		chanHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		chanHead_lab.setBounds(73, 50, 224, 53);
		change_panel.add(chanHead_lab);
		
		JLabel chanId_lab = new JLabel("���̵�");
		chanId_lab.setForeground(new Color(255, 255, 255));
		chanId_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanId_lab.setBounds(73, 127, 57, 15);
		change_panel.add(chanId_lab);
		
		JLabel chanPwd_lab1 = new JLabel("�ڵ��� ��ȣ(-�����ؼ� �Է�)");
		chanPwd_lab1.setForeground(Color.WHITE);
		chanPwd_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_lab1.setBounds(73, 210, 200, 15);
		change_panel.add(chanPwd_lab1);
		
		JLabel chanPwd_lab2 = new JLabel("��й�ȣ (�ִ� 14��)");
		chanPwd_lab2.setForeground(Color.WHITE);
		chanPwd_lab2.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_lab2.setBounds(73, 295, 142, 15);
		change_panel.add(chanPwd_lab2);
		
		JLabel chanPwd_lab3 = new JLabel("��й�ȣ ��Ȯ��");
		chanPwd_lab3.setForeground(Color.WHITE);
		chanPwd_lab3.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_lab3.setBounds(73, 375, 142, 15);
		change_panel.add(chanPwd_lab3);
		
		chanId_textF = new JTextField();
		chanId_textF.setBackground(new Color(255, 255, 255));
		chanId_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanId_textF.setBounds(73, 152, 224, 35);
		change_panel.add(chanId_textF);
		chanId_textF.setColumns(10);
		
		chanPwd_textF = new JTextField();
		chanPwd_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_textF.setBackground(Color.WHITE);
		chanPwd_textF.setBounds(73, 235, 224, 35);
		change_panel.add(chanPwd_textF);
		
		chanPwd_pField1 = new JPasswordField();
		chanPwd_pField1.setBackground(new Color(255, 255, 255));
		chanPwd_pField1.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_pField1.setBounds(73, 320, 224, 35);
		change_panel.add(chanPwd_pField1);
		
		chanPwd_pField2 = new JPasswordField();
		chanPwd_pField2.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_pField2.setBackground(Color.WHITE);
		chanPwd_pField2.setBounds(73, 400, 224, 35);
		change_panel.add(chanPwd_pField2);
		
		JButton chanPwd_butt = new JButton("����");
		chanPwd_butt.setBorderPainted(false);    
		chanPwd_butt.setContentAreaFilled(false); 
		chanPwd_butt.setFocusPainted(false);      
		chanPwd_butt.setOpaque(false);
		chanPwd_butt.setFocusPainted(false);
		chanPwd_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == chanPwd_butt) {
	                String id = chanId_textF.getText().trim();
	                String tel = chanPwd_textF.getText().trim();
	                String newpwd = chanPwd_pField1.getText().trim();
	                String newpwd2 = chanPwd_pField2.getText().trim();
				    if(id.isEmpty()){
				    	gdb.showBox("���̵� �Է����ּ���", "�ڽ��� ���ﺴ��");
				    }else if(tel.isEmpty()){
				        gdb.showBox("�ڵ��� ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
				    }else if(newpwd.isEmpty()){
				        gdb.showBox("���ο� ��й�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
				    }else if(newpwd.length()>=15) {
						gdb.showBox("��й�ȣ�� 14�� �̳��� �Է����ּ���","�ڽ��� ���ﺴ��");
					}else if(newpwd2.isEmpty()){
				    	gdb.showBox("��й�ȣ Ȯ���� �Է����ּ���", "�ڽ��� ���ﺴ��");
				    }else if(!newpwd.equals(newpwd2)){
				    	gdb.showBox("�� ��й�ȣ �Է°��� ���� �ٸ��ϴ�", "�ڽ��� ���ﺴ��");
				    }else {		
				        boolean flag = gdb.changePWD(newpwd, id, tel);
				        if(flag) {
				        	JOptionPane.showMessageDialog(null, "��й�ȣ�� �����Ͽ����ϴ�.");
				        	chanId_textF.setText("");
				        	chanPwd_textF.setText("");
				        	chanPwd_pField1.setText("");  
				        	chanPwd_pField2.setText(""); 
				        	change_panel.setVisible(false);
							login_panel.setVisible(true);
				        }else {
				        	chanId_textF.setText("");
				        	chanPwd_textF.setText("");
				        	chanPwd_pField1.setText("");
				        	chanPwd_pField2.setText(""); 
				        	JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� ��Ȯ���� �ʽ��ϴ�.");
				        }
				    }      
	            } 
			}
		});
		
		chanPwd_butt.setForeground(new Color(255, 255, 255));
		chanPwd_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		chanPwd_butt.setBounds(135, 485, 97, 35);
		change_panel.add(chanPwd_butt);
		
		JButton chanBack_butt = new JButton("");
		chanBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change_panel.setVisible(false);
				login_panel.setVisible(true);
			}
		});
		chanBack_butt.setIcon(new ImageIcon("imgs\\back.png"));
		chanBack_butt.setOpaque(false);
		chanBack_butt.setFocusPainted(false);
		chanBack_butt.setContentAreaFilled(false);
		chanBack_butt.setBorderPainted(false);
		chanBack_butt.setBounds(322, 10, 50, 50);
		change_panel.add(chanBack_butt);
		
		JLabel chab_lab = new JLabel("");
		chab_lab.setIcon(new ImageIcon("imgs\\loginBG.jpg"));
		chab_lab.setBounds(0, 0, 384, 561);
		change_panel.add(chab_lab);
		
		//////////////////////////////////////// ���̵� ã�� �г� ////////////////////////////////////////
		find_panel.setBackground(new Color(255, 255, 255));
		find_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(find_panel);
		find_panel.setLayout(null);
		
		JLabel findHead_lab = new JLabel("���̵� ã��");
		findHead_lab.setBounds(73, 50, 224, 53);
		findHead_lab.setHorizontalAlignment(SwingConstants.CENTER);
		findHead_lab.setForeground(Color.WHITE);
		findHead_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 35));
		find_panel.add(findHead_lab);
		
		JLabel findJumin_lab = new JLabel("�ֹε�Ϲ�ȣ (-�����ؼ� �Է�)");
		findJumin_lab.setBounds(35, 185, 204, 19);
		findJumin_lab.setForeground(Color.WHITE);
		findJumin_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		find_panel.add(findJumin_lab);
		
		JLabel findHp_lab = new JLabel("�ڵ��� ��ȣ (-�����ؼ� �Է�)");
		findHp_lab.setBounds(35, 290, 204, 19);
		findHp_lab.setForeground(Color.WHITE);
		findHp_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		find_panel.add(findHp_lab);
		
		findJumin_textF = new JTextField();
		findJumin_textF.setBounds(35, 215, 315, 35);
		findJumin_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		findJumin_textF.setColumns(10);
		find_panel.add(findJumin_textF);
		
		findHp_textF = new JTextField();
		findHp_textF.setBounds(35, 320, 315, 35);
		findHp_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		findHp_textF.setColumns(10);
		find_panel.add(findHp_textF);
		
		JButton findId_butt = new JButton("ã��");
		findId_butt.setBorderPainted(false);    
		findId_butt.setContentAreaFilled(false); 
		findId_butt.setFocusPainted(false);      
		findId_butt.setOpaque(false);
		findId_butt.setFocusPainted(false);
		findId_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == findId_butt) {
	                String ssn = findJumin_textF.getText().trim();
	                String tel = findHp_textF.getText().trim();
	                String id = null;
				    if(ssn.isEmpty()){
				    	gdb.showBox("�ֹι�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
				    }else if(tel.isEmpty()){
				        gdb.showBox("��ȭ��ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
				    }else{
				        id = gdb.searchID(ssn, tel);
				        if(id != null) {
				        	JOptionPane.showMessageDialog(null, "���̵�� "+id+"�Դϴ�");
				        	findJumin_textF.setText("");
				        	findHp_textF.setText("");
				        	find_panel.setVisible(false);
					        login_panel.setVisible(true);
				        }else {
				        	JOptionPane.showMessageDialog(null, "�ֹι�ȣ�� ��ȭ��ȣ�� ��Ȯ���� �ʽ��ϴ�.");
				        	findJumin_textF.setText("");
				        	findHp_textF.setText("");
				        }
				    }      
	            }
			}
		});
		findId_butt.setBounds(142, 400, 97, 35);
		findId_butt.setForeground(new Color(255, 255, 255));
		findId_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		findId_butt.setBackground(Color.WHITE);
		find_panel.add(findId_butt);
		
		JButton findBack_butt = new JButton("");
		findBack_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find_panel.setVisible(false);
				login_panel.setVisible(true);
			}
		});
		findBack_butt.setBorderPainted(false);
		findBack_butt.setContentAreaFilled(false);
		findBack_butt.setFocusPainted(false);
		findBack_butt.setOpaque(false);
		findBack_butt.setIcon(new ImageIcon("imgs\\back.png"));
		findBack_butt.setBounds(322, 10, 50, 50);
		find_panel.add(findBack_butt);
		
		JLabel find_lab = new JLabel("");
		find_lab.setIcon(new ImageIcon("imgs\\loginBG.jpg"));
		find_lab.setBounds(0, 0, 384, 561);
		find_panel.add(find_lab);
		
		//////////////////////////////////////// �α��� �г�
		login_panel.setBackground(new Color(255, 255, 255));
		login_panel.setBounds(0, 0, 384, 561);
		frame.getContentPane().add(login_panel);
		login_panel.setLayout(null);
		
		JLabel loginHead_lab1 = new JLabel("�ȳ��ϼ���.");
		loginHead_lab1.setForeground(new Color(255, 255, 255));
		loginHead_lab1.setHorizontalAlignment(SwingConstants.LEFT);
		loginHead_lab1.setFont(new Font("�����ý��丮", Font.PLAIN, 28));
		loginHead_lab1.setBounds(70, 60, 140, 50);
		login_panel.add(loginHead_lab1);
		
		JLabel loginHead_lab2 = new JLabel("KMC �Դϴ�.");
		loginHead_lab2.setForeground(new Color(255, 255, 255));
		loginHead_lab2.setFont(new Font("�����ý��丮", Font.PLAIN, 28));
		loginHead_lab2.setBounds(70, 100, 180, 50);
		login_panel.add(loginHead_lab2);
		
		JLabel loginId_lab = new JLabel("���̵�");
		loginId_lab.setForeground(new Color(255, 255, 255));
		loginId_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		loginId_lab.setBounds(70, 176, 127, 23);
		login_panel.add(loginId_lab);
		
		JLabel loginPwd_lab = new JLabel("��й�ȣ");
		loginPwd_lab.setForeground(Color.WHITE);
		loginPwd_lab.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		loginPwd_lab.setBounds(70, 267, 127, 23);
		login_panel.add(loginPwd_lab);
		
		login_textF = new JTextField();
		login_textF.setToolTipText("���̵� �Է��ϼ���");
		login_textF.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		login_textF.setBounds(70, 211, 244, 32);
		login_panel.add(login_textF);
		login_textF.setColumns(10);
		
		loginPwd_pField = new JPasswordField();
		loginPwd_pField.setToolTipText("��й�ȣ�� �Է��ϼ���");
		loginPwd_pField.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		loginPwd_pField.setBounds(70, 300, 244, 32);
		login_panel.add(loginPwd_pField);
				
		JButton login_butt = new JButton("�α���");
		login_butt.setBorderPainted(false);    
		login_butt.setContentAreaFilled(false); 
		login_butt.setFocusPainted(false);      
		login_butt.setOpaque(false);
		login_butt.setFocusPainted(false);
		login_butt.addActionListener(new ActionListener() {
			String pwd;
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource()==login_butt) {
						loginId = login_textF.getText().trim();
						pln("loginId: " + loginId);
						pwd = loginPwd_pField.getText().trim();
						if(loginId.isEmpty()) {
							gdb.showBox("���̵� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(pwd.isEmpty()) {
							gdb.showBox("��й�ȣ�� �Է����ּ���", "�ڽ��� ���ﺴ��");
						}else if(!pwd.isEmpty()) {
							if(gdb.checkP(loginId, pwd) == true) {
								JOptionPane.showMessageDialog(null, "ȯ���մϴ�.", "�ڽ��� ���ﺴ��", JOptionPane.INFORMATION_MESSAGE, w);
								loginPwd_pField.setText("");
								login_panel.setVisible(false);
								main_panel.setVisible(true);
							}else { 
								gdb.showBox("�������� �ʴ� ID�̰ų� ��й�ȣ�� �ٸ��ϴ�.", "�ڽ��� ���ﺴ��");
								loginPwd_pField.setText("");
							}
						}
					}
				}catch(Exception ee) {
					System.out.println("�����߻�(3)" + ee);
				}
			}
		});
		
		login_butt.setForeground(new Color(255, 255, 255));
		login_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 16));
		login_butt.setBackground(Color.WHITE);
		login_butt.setBounds(139, 370, 106, 32);
		login_panel.add(login_butt);
		
		JButton loginFindId_butt = new JButton("���̵� ã��");
		loginFindId_butt.setBorderPainted(false);    //��ư �ܰ��� ���ֱ�
		loginFindId_butt.setContentAreaFilled(false); //��ư ��� ����ȭ
		loginFindId_butt.setFocusPainted(false);      //��ư ������ �� �ܰ��� ���ֱ�
		//loginFindId_butt.setOpaque(false);
		
		loginFindId_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find_panel.setVisible(true);
				login_panel.setVisible(false);
			}
		});
		loginFindId_butt.setForeground(new Color(255, 255, 255));
		loginFindId_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 12));
		loginFindId_butt.setBounds(21, 445, 106, 23);
		login_panel.add(loginFindId_butt);
		
		JButton loginChaPwd_butt = new JButton("��й�ȣ ����");
		loginChaPwd_butt.setBorderPainted(false);
		loginChaPwd_butt.setContentAreaFilled(false);
		loginChaPwd_butt.setFocusPainted(false);
		loginChaPwd_butt.setOpaque(false);
		
		loginChaPwd_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change_panel.setVisible(true);
				login_panel.setVisible(false);
			}
		});
		loginChaPwd_butt.setForeground(new Color(255, 255, 255));
		loginChaPwd_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 12));
		loginChaPwd_butt.setBounds(139, 445, 106, 23);
		login_panel.add(loginChaPwd_butt);
		
		JButton loginJoin_butt = new JButton("ȸ������");
		loginJoin_butt.setBorderPainted(false);
		loginJoin_butt.setContentAreaFilled(false);
		loginJoin_butt.setFocusPainted(false);
		loginJoin_butt.setOpaque(false);
		
		loginJoin_butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join_panel.setVisible(true);
				login_panel.setVisible(false);
			}
		});
		
		loginJoin_butt.setForeground(new Color(255, 255, 255));
		loginJoin_butt.setFont(new Font("�����ý��丮", Font.PLAIN, 12));
		loginJoin_butt.setBounds(257, 445, 106, 23);
		login_panel.add(loginJoin_butt);
		
		JLabel login_lab = new JLabel("");
		login_lab.setIcon(new ImageIcon("imgs\\loginBG.jpg"));
		login_lab.setBounds(0, 0, 384, 561);
		login_panel.add(login_lab);
	}
	public void pln(String str) {
		System.out.println(str);
	}
}
