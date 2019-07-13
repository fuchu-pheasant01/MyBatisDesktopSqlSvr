package desk.sample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDesktopSqlSvr {
	private JFrame fwindow = new JFrame();
	private JPanel fpanel = new JPanel();
	private JButton ButtonQuery = new JButton();
	private JButton ButtonInsert = new JButton();
	private JButton ButtonUpdate = new JButton();
	private JButton ButtonDelete = new JButton();
	private JTextField TextCode = new JTextField();
	private JTextArea LabelArea = new JTextArea();
	private JLabel LabelCode = new JLabel();
	private JTextField TextNum = new JTextField();
	private JTextField TextName = new JTextField();
	private JTextField TextDate = new JTextField();
	private JTextField TextTime = new JTextField();
	private JTextField TextNote = new JTextField();
	private String[] headers = {"NumId", "ShohinNum", "ShohinName", "EditDate", "EditTime", "Note"};
	private JTable Table1;
	private JScrollPane Scroll1;
	private DefaultTableModel dTableModel;
	
	public static void main(String[] args) {
		MyBatisDesktopSqlSvr batids = new MyBatisDesktopSqlSvr();
		batids.CreateWindow();
		String resource = "mybatis-config.xml";
		InputStream inst;
		try {
			inst = Resources.getResourceAsStream(resource);
			//FileInputStream inst = new FileInputStream(resource);
			SqlSessionFactory sfactory = new SqlSessionFactoryBuilder().build(inst);
			SqlSession session = sfactory.openSession(true);
			SqlOperation ope = session.getMapper(SqlOperation.class);
			List<ShohinMap> data = ope.findAll();
			System.out.println(data.get(2).getShohinName());
			//String name = (String) session.selectOne("map-batis.findName", new Short((short) 7500));
			//System.out.println(name);
			session.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		batids.fwindow.add(batids.fpanel);
		batids.fwindow.getContentPane().add(batids.fpanel,BorderLayout.CENTER);
		batids.fwindow.setVisible(true);

		//batids.initialData();
	}

	private void CreateWindow() {
		fwindow.setTitle("MyBatis + SQLServer デスクトップアプリ");
		fwindow.setLocation(500,200);
		fwindow.setSize(800, 600);
		fwindow.setUndecorated(false); // タイトルバー表示・非表示
		fwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dTableModel = new DefaultTableModel(headers, 0);
		Table1 = new JTable(dTableModel);
		Scroll1 = new JScrollPane(Table1);
		Scroll1.setBounds(25,25,700,200);
		fpanel.setPreferredSize(new Dimension(700, 100));
		fpanel.add(Scroll1);
		LabelArea.setText("表示エリア");
		LabelArea.setBounds(25,235,350,100);
		LabelArea.setFocusable(false);
		fpanel.add(LabelArea);

		ButtonQuery.setText("抽出");
		ButtonQuery.setBounds(50,470,150,50);
		fpanel.add(ButtonQuery);
		ButtonInsert.setText("追加");
		ButtonInsert.setBounds(230, 470, 150, 50);
		fpanel.add(ButtonInsert);
		ButtonUpdate.setText("更新");
		ButtonUpdate.setBounds(410, 470, 150, 50);
		fpanel.add(ButtonUpdate);
		ButtonDelete.setText("削除");
		ButtonDelete.setBounds(590, 470, 150, 50);
		fpanel.add(ButtonDelete);

		LabelCode.setText("主キーID：");
		LabelCode.setBounds(25,340,75,25);
		fpanel.add(LabelCode);
		TextCode.setBounds(100,340,200,25);
		TextNum.setBounds(530,235, 200,25);
		TextName.setBounds(530,265,200,25);
		TextDate.setBounds(530,295,200,25);
		TextTime.setBounds(530,325,200,25);
		TextNote.setBounds(530,355,200,25);
		fpanel.add(TextCode);
		fpanel.add(TextNum);
		fpanel.add(TextName);
		fpanel.add(TextDate);
		fpanel.add(TextTime);
		fpanel.add(TextNote);
		fpanel.setLayout(null);
	}

	private void initialData() {
		/*MyBatisDao<SyohinMap> batidao = new MyBatisDao<SyohinMap>();

		SyohinMap syohindata = new SyohinMap();
		syohindata.setSyohinCode((short)7500);
		syohindata.setSyohinName("ｾﾄｳﾁﾚﾓﾝ");
		syohindata.setEditDate(BigDecimal.valueOf(20190417));
		syohindata.setEditTime(BigDecimal.valueOf(203145));
		syohindata.setNote("瀬戸内レモンです");
		batidao.insert(syohindata);

		syohindata.setSyohinCode((short)2840);
		syohindata.setSyohinName("ﾘﾝｺﾞｼﾞｭｰｽ");
		syohindata.setEditDate(BigDecimal.valueOf(20050923));
		syohindata.setEditTime(BigDecimal.valueOf(102532));
		syohindata.setNote("果汁100%の炭酸飲料です");
		batidao.insert(syohindata);

		syohindata.setSyohinCode((short)1580);
		syohindata.setSyohinName("ｶﾌｪｵﾚ");
		syohindata.setEditDate(BigDecimal.valueOf(20160716));
		syohindata.setEditTime(BigDecimal.valueOf(91103));
		syohindata.setNote("200ml増量です");
		batidao.insert(syohindata);

		syohindata.setSyohinCode((short)270);
		syohindata.setSyohinName("ｳﾒｵﾆｷﾞﾘ");
		syohindata.setEditDate(BigDecimal.valueOf(20080825));
		syohindata.setEditTime(BigDecimal.valueOf(141520));
		syohindata.setNote("none");
		batidao.insert(syohindata);*/
	}
}
