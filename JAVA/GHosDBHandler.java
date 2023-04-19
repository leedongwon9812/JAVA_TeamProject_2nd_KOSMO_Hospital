import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GHosDBHandler
{
	String url = "jdbc:oracle:thin:@localHost:1521:JAVA";
	String user = "GHos";
	String pwd = "ghos1234";
	Connection con;
	Statement stmt;
	PreparedStatement pstmt1, pstmt2, pstmt3, pstmt4, pstmt5, pstmt6, pstmt7, pstmt8, pstmt9, pstmt10, pstmt11, 
	pstmt13, pstmt14, pstmt15, pstmt17, pstmt19, pstmt20, pstmt21, pstmt23, pstmt24, pstmt26, pstmt27, pstmt28, pstmt29;
	DefaultTableModel dftmodel = new DefaultTableModel();
	DefaultTableModel dftmodel2 = new DefaultTableModel();
	
	GHosDBHandler(){
		SQL sq = new SQL();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("DB����Ϸ�");
			
			stmt = con.createStatement();
			pstmt1 = con.prepareStatement(sq.SQL1);
			pstmt2 = con.prepareStatement(sq.SQL2);
			pstmt3 = con.prepareStatement(sq.SQL3);
			pstmt4 = con.prepareStatement(sq.SQL4);
			pstmt5 = con.prepareStatement(sq.SQL5);
			pstmt6 = con.prepareStatement(sq.SQL6);
			pstmt7 = con.prepareStatement(sq.SQL7);
			pstmt8 = con.prepareStatement(sq.SQL8);
			pstmt9 = con.prepareStatement(sq.SQL9, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt10 = con.prepareStatement(sq.SQL10); 
			pstmt11 = con.prepareStatement(sq.SQL11); 
			pstmt13 = con.prepareStatement(sq.SQL13, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
			pstmt14 = con.prepareStatement(sq.SQL14, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
			pstmt15 = con.prepareStatement(sq.SQL15); 
			pstmt17 = con.prepareStatement(sq.SQL17);
			pstmt19 = con.prepareStatement(sq.SQL19);
			pstmt20 = con.prepareStatement(sq.SQL20);
			pstmt21 = con.prepareStatement(sq.SQL21);
			pstmt23 = con.prepareStatement(sq.SQL23);
			pstmt24 = con.prepareStatement(sq.SQL24);
			pstmt26 = con.prepareStatement(sq.SQL26, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt27 = con.prepareStatement(sq.SQL27, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt28 = con.prepareStatement(sq.SQL28);
			pstmt29 = con.prepareStatement(sq.SQL29, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			con.setAutoCommit(false);
		}catch(SQLException se){
		}catch(ClassNotFoundException cnfe){
			p("Cnfe: " + cnfe);
		}
	}
	
	/////////////////////// ȸ������ ///////////////////////
	public void insertPatient(String id, String pwd, String name, String ssn, String tel, String addr, String email){
		ResultSet rs = null;
		try{
			pstmt1.setString(1, id);
			pstmt1.setString(2, pwd);
			pstmt1.setString(3, name);
			pstmt1.setString(4, ssn);
			pstmt1.setString(5, tel);
			pstmt1.setString(6, addr);
			pstmt1.setString(7, email);
			rs = pstmt1.executeQuery();
			System.out.println("���� ����");
			
			con.commit();
		}catch(SQLException se){
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se) {
			}
		}
	}
	
	/////////////////////// ID�ߺ�üũ ///////////////////////
	public boolean checkId(String id) {
		ResultSet rs = null;
		int i = 0;
		try {
			pstmt3.setString(1, id);
			rs = pstmt3.executeQuery();
			while(rs.next()) {
				i++;
			}
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se) {
			}
		}
		return false;
	}
	
	/////////////////////// �ֹι�ȣ�ߺ�üũ ///////////////////////
	public boolean checkSSN(String ssn) {
		ResultSet rs = null;
		int i = 0;
		try {
			pstmt4.setString(1, ssn);
			rs = pstmt4.executeQuery();
			while(rs.next()) {
				i++;
			}
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se) {
			}
		}
		return false;
	}
	
	/////////////////////// ����ó�ߺ�üũ ///////////////////////
	public boolean checkTEL(String tel) {
		ResultSet rs = null;
		int i = 0;
		try {
			pstmt5.setString(1, tel);
			rs = pstmt5.executeQuery();
			while(rs.next()) {
				i++;
			}
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se) {
			}
		}
		return false;
	}
	
	/////////////////////// ȸ������ üũ ///////////////////////
	public boolean checkP(String id, String pwd) {
		ResultSet rs = null;
		int i = 0;
		try {
			pstmt2.setString(1, id);
			pstmt2.setString(2, pwd);
			rs = pstmt2.executeQuery();
			while(rs.next()) {
				i++;
			}
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException se) {
		}finally {
			try {
				rs.close();
			}catch(SQLException se) {
			}
		}
		return false;
	}
	
	/////////////////////// ��й�ȣ ���� ///////////////////////
	 public boolean changePWD(String newpwd, String id, String tel) {
		try {
			pstmt6.setString(1, newpwd);
			pstmt6.setString(2, id);
			pstmt6.setString(3, tel);
			int i = pstmt6.executeUpdate();
			if(i>0) {
				System.out.println("������Ʈ ����");
				con.commit();
				return true;
			}else if(i==0) {
				System.out.println("0");
				return false;
			}else {
				System.out.println("������Ʈ ����");
				return false;
			}
		}catch(SQLException se) {
			System.out.println("�����߻�" + se);
		}
		return false;
	}
	 
	/////////////////////// ���̵� ã�� ///////////////////////
	public String searchID(String ssn, String tel){
		ResultSet rs = null;
		String id = null;
		try{
			pstmt7.setString(1, ssn);
			pstmt7.setString(2, tel);
			rs = pstmt7.executeQuery();
			while(rs.next()){
				id = rs.getString("P_ID");
				return id;
			}
		}catch(SQLException se){
			System.out.println("se: " + se);
			return id;
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
				}catch(SQLException se) {
				}
			}
		}
		return id;
	}
	
	/////////////////////// ���̵� ���� ///////////////////////
	public boolean identify(String loginId, String ssn, String tel) {
		ResultSet rs = null;
		int i = 0;
		try {
			pstmt11.setString(1, loginId);
			pstmt11.setString(2, ssn);
			pstmt11.setString(3, tel);
			rs = pstmt11.executeQuery();
			while(rs.next()) {
				i++;
			}
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
			pln("�����߻�(1): " + se);
		}finally {
			try {
				rs.close();
			}catch(SQLException se) {
				pln("�����߻�(2): " + se);
			}
		}
		return false;
	}
	
	/////////////////////// ������ ��� ///////////////////////
	Vector<String> columnNames = new Vector<String>();
	public void resultShow(String ssn, String tel) {
		Vector<Vector<String>> rowData = new Vector<>();
		ResultSet rs = null;
		try {
			pstmt8.setString(1, ssn);
			pstmt8.setString(2, tel);
			rs = pstmt8.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			pln("�÷�����: " + cc);
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p(cn + "\t");
				p("---------");
			}
			
			while(rs.next()){
		        Vector<String> vector = new Vector<String>();
		        for(int i=1; i<=cc; i++){
		        	vector.add(rs.getString(rsmd.getColumnName(i))); 
		        }
		        rowData.add(vector);
			}
			dftmodel.setDataVector(rowData, columnNames);		
		}catch(SQLException se) {
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}
		}
	}
	
	/////////////////////// ������ �޺��ڽ� ///////////////////////
	public void resultCom(String str, String ser, String ssn, String tel) {
		ResultSet rs = null;
		Vector<Vector<Object>> rowData = new Vector<>();
		String sql = "select DEP_NAME �����, DOC_NAME �ǻ��, DIS_NAME ���ܸ�, TR_DATE �����Ͻ� from PATIENT natural join TREATM natural join DOCTOR where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by TR_DATE desc";
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);	
			p("rs: " + rs);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p("cn: " + cn);
			}
			if(rs.next()) {
				rs.beforeFirst();
				p("str: " + str);
				p("ser: " + ser); 
				p("ssn: " + ssn);
				p("tel: " + tel);				
				while(rs.next()){
			        Vector<Object> vector = new Vector<Object>();
			        for(int i=1; i<=cc; i++){
			        	vector.add(rs.getObject(rsmd.getColumnName(i))); 
			        }
			        rowData.add(vector);
				}
			}
			dftmodel.setDataVector(rowData, columnNames);
		}catch(SQLException se) {
			pln("�����߻�(1)" + se);
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){
				pln("�����߻�(2)" + se);
			}catch(Exception e) {
				pln("�Ӽ�������?(3)" + e);
			}
		}
	}
	
	/////////////////////// ó���̷� ��� ///////////////////////
	public void visitShow(String ssn, String tel) {
		Vector<Vector<String>> rowData = new Vector<>();
		ResultSet rs = null;
		try {
			pstmt19.setString(1, ssn);
			pstmt19.setString(2, tel);
			rs = pstmt19.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			pln("�÷�����: " + cc);
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p(cn + "\t");
				p("---------");
			}
			
			while(rs.next()){
		        Vector<String> vector = new Vector<String>();
		        for(int i=1; i<=cc; i++){
		        	vector.add(rs.getString(rsmd.getColumnName(i))); 
		        }
		        rowData.add(vector);
			}
			dftmodel.setDataVector(rowData, columnNames);		
		}catch(SQLException se) {
			p("�����߻�: " + se);
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}
		}
	}
	
	/////////////////////// ó���̷� �޺��ڽ� ///////////////////////
	public void visitCom(String str, String ser, String ssn, String tel) {
		ResultSet rs = null;
		Vector<Vector<Object>> rowData = new Vector<>();
		String sql = "select PR_DATE ó���Ͻ�, PR_NAME ó���, DOSE �뷮, DAYS �ϼ�, NUM Ƚ��, DOC_NAME ó���� from PRESC natural join PATIENT natural join DOCTOR where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by PR_DATE desc";
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);	
			p("rs: " + rs);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p("cn: " + cn);
			}
			if(rs.next()) {
				rs.beforeFirst();
				p("str: " + str);
				p("ser: " + ser); 
				p("ssn: " + ssn);
				p("tel: " + tel);				
				while(rs.next()){
			        Vector<Object> vector = new Vector<Object>();
			        for(int i=1; i<=cc; i++){
			        	vector.add(rs.getObject(rsmd.getColumnName(i))); 
			        }
			        rowData.add(vector);
				}
			}
			dftmodel.setDataVector(rowData, columnNames);
		}catch(SQLException se) {
			pln("�����߻�(1)" + se);
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){
				pln("�����߻�(2)" + se);
			}catch(Exception e) {
				pln("�Ӽ�������?(3)" + e);
			}
		}
	}
	
	/////////////////////// �ǰ������̷� ��� ///////////////////////
	public void phyCheckShow(String ssn, String tel) {
		Vector<Vector<String>> rowData = new Vector<>();
		ResultSet rs = null;
		try {
			pstmt20.setString(1, ssn);
			pstmt20.setString(2, tel);
			rs = pstmt20.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			pln("�÷�����: " + cc);
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p(cn + "\t");
				p("---------");
			}
			
			while(rs.next()){
		        Vector<String> vector = new Vector<String>();
		        for(int i=1; i<=cc; i++){
		        	vector.add(rs.getString(rsmd.getColumnName(i))); 
		        }
		        rowData.add(vector);
			}
			dftmodel.setDataVector(rowData, columnNames);		
		}catch(SQLException se) {
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}
		}
	}
	
	/////////////////////// �ǰ������̷� �޺��ڽ� ///////////////////////
	public void phyCheckCom(String str, String ser, String ssn, String tel) {
		ResultSet rs = null;
		Vector<Vector<String>> rowData = new Vector<>();
		String sql = "select E_DATE �����Ͻ�, HEIGHT ����, WEIGHT ü��, BP ����, FBS ��������, HDL, LDL, CREA, AST, ALT from EXAM natural join PATIENT where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by E_DATE desc";
//		String sql = "select HEIGHT, WEIGHT, BP, FBS, HDL, LDL, CREA, AST, ALT, E_DATE from EXAM natural join PATIENT where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by E_DATE desc";
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);	
			p("rs: " + rs);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p("cn: " + cn);
			}
			if(rs.next()) {
				rs.beforeFirst();
				p("str: " + str);
				p("ser: " + ser); 
				p("ssn: " + ssn);
				p("tel: " + tel);				
				while(rs.next()){
			        Vector<String> vector = new Vector<String>();
			        for(int i=1; i<=cc; i++){
			        	vector.add(rs.getString(rsmd.getColumnName(i))); 
			        }
			        rowData.add(vector);
				}
			}
			dftmodel.setDataVector(rowData, columnNames);
		}catch(SQLException se) {
			pln("�����߻�(1)" + se);
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){
				pln("�����߻�(2)" + se);
			}catch(Exception e) {
				pln("�Ӽ�������?(3)" + e);
			}
		}
	}
	/////////////////////// �����̷� ��� ///////////////////////
	public void surgeryShow(String ssn, String tel) {
		Vector<Vector<String>> rowData = new Vector<>();
		ResultSet rs = null;
		try {
			pstmt21.setString(1, ssn);
			pstmt21.setString(2, tel);
			rs = pstmt21.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			pln("�÷�����: " + cc);
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p(cn + "\t");
				p("---------");
			}			
			while(rs.next()){
		        Vector<String> vector = new Vector<String>();
		        for(int i=1; i<=cc; i++){
		        	vector.add(rs.getString(rsmd.getColumnName(i))); 
		        }
		        rowData.add(vector);
			}
			dftmodel.setDataVector(rowData, columnNames);		
		}catch(SQLException se) {
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}
		}
	}
	/////////////////////// �����̷���ȸ �޺��ڽ� ///////////////////////
	public void surgeryCom(String str, String ser, String ssn, String tel) {
		ResultSet rs = null;
		Vector<Vector<String>> rowData = new Vector<>();
		String sql = "select S_NAME ������, DIS_NAME ���ܸ�, DOC_NAME �ǻ��, S_DATE �����Ͻ� from SURGERY natural join PATIENT natural join DOCTOR where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by S_DATE desc";
//		String sql = "select S_NAME, DIS_NAME, DOC_ID, S_DATE from SURGERY natural join PATIENT where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by S_DATE desc";
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);	
			p("rs: " + rs);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p("cn: " + cn);
			}
			if(rs.next()) {
				rs.beforeFirst();				
				while(rs.next()){
			        Vector<String> vector = new Vector<String>();
			        for(int i=1; i<=cc; i++){
			        	vector.add(rs.getString(rsmd.getColumnName(i))); 
			        }
			        rowData.add(vector);
				}
			}
			dftmodel.setDataVector(rowData, columnNames);
		}catch(SQLException se) {
			pln("�����߻�(1)" + se);
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){
				pln("�����߻�(2)" + se);
			}catch(Exception e) {
				pln("�Ӽ�������?(3)" + e);
			}
		}
	}

	/////////////////////// �����̷� ��� ///////////////////////
	public void reservShow(String ssn, String tel) {
		Vector<Vector<String>> rowData = new Vector<>();
		ResultSet rs = null;
		try {
			pstmt10.setString(1, ssn);
			pstmt10.setString(2, tel);
			rs = pstmt10.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			pln("�÷�����: " + cc);
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p(cn + "\t");
				p("---------");
			}
			
			while(rs.next()){
				String data1 = rs.getString(1);
				String data2 = rs.getString(2);
				String data3 = rs.getString(3);
				Vector<String> vector = new Vector<String>();
				vector.add(data1);
				vector.add(data2);
				vector.add(data3);
				rowData.add(vector);
			}
			dftmodel.setDataVector(rowData, columnNames);		
		}catch(SQLException se) {
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}
		}
	}
	
	/////////////////////// ������ȸ �޺��ڽ� ///////////////////////
	public void reservCom(String str, String ser, String ssn, String tel) {
		ResultSet rs = null;
		Vector<Vector<String>> rowData = new Vector<>();
		String sql = "select DEP_NAME �����, DOC_NAME �ǻ��, R_DATE �����Ͻ� from PATIENT natural join DOCTOR natural join RESERV where "+str+" like '%"+ser+"%' and P_SSN='"+ssn+"' and P_TEL='"+tel+"' order by R_DATE desc";
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);	
			p("rs: " + rs);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for(int i=1; i<=cc; i++){
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
				p("cn: " + cn);
			}
			if(rs.next()) {
				rs.beforeFirst();				
				while(rs.next()){
			        Vector<String> vector = new Vector<String>();
			        for(int i=1; i<=cc; i++){
			        	vector.add(rs.getString(rsmd.getColumnName(i))); 
			        }
			        rowData.add(vector);
				}
			}
			dftmodel.setDataVector(rowData, columnNames);
		}catch(SQLException se) {
			pln("�����߻�(1)" + se);
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){
				pln("�����߻�(2)" + se);
			}catch(Exception e) {
				pln("�����߻�(3)" + e);
			}
		}
	}
	/////////////////////// ������� ///////////////////////
	public void reservDEL(String str1, String str2, String date) {
		String sql = "delete from RESERV where DOC_ID=(select DOC_ID from DOCTOR where DEP_NAME='"+str1+"' and DOC_NAME='"+str2+"') and R_DATE=TO_DATE('"+date+"', 'YYYY-MM-DD HH24:MI:SS')";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			p("str1: " + str1);
			p("str2: " + str2);
			p("date: " + date);
			con.commit();
		}catch(SQLException se) {
			pln("�����߻�: " + se);
		}finally {
			try {
				stmt.close();
			}catch(SQLException se) {
			}
		}
	}
	
	/////////////////////// ���Ό�� �޺��ڽ� ///////////////////////
	Vector<String> vector1 = new Vector<String>();
	Vector<String> vector2 = new Vector<String>();
	Vector<String> vector3 = new Vector<String>();
	public void getDept() {
		String SQL25 = "select DEP_NAME from DEPT";
		ResultSet rs = null;
		try {
			vector1.clear();
			vector2.clear();
			vector3.clear();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(SQL25);
			rs.beforeFirst();
			while (rs.next()) {
				String dept = rs.getString(1);
				vector1.add(dept);
				p("dept: " + dept);
			}
		} catch (SQLException se) {
			pln("�����߻�1: " + se);
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException se) {
				pln("�����߻�2: " + se);
			}
		}
	}

	public void getDoc(String selectedDept) {
		ResultSet rs = null;
		try {
			vector2.clear();
			pstmt26.setString(1, selectedDept);
			rs = pstmt26.executeQuery();
			p("rs: " + rs);
			rs.beforeFirst();
			while (rs.next()) {
				String doctor = rs.getString(1);
				vector2.add(doctor);				
				p("doctor: " + doctor);
			}
		} catch (SQLException se) {
			pln("�����߻�3: " + se);
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException se) {
				pln("�����߻�4: " + se);
			}
		}
	}
	public void getTRDate(String selectedDoc) {
		ResultSet rs = null;
		try {
			vector3.clear();
			pstmt27.setString(1, selectedDoc);
			rs = pstmt27.executeQuery();
			p("rs: " + rs);
			rs.beforeFirst();
			while (rs.next()) {
				String trdate = rs.getString(1);
				vector3.add(trdate);
				p("trdate: " + trdate);
			}
		} catch (SQLException se) {
			pln("�����߻�3: " + se);
		} finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException se) {
				pln("�����߻�4: " + se);
			}
		}
	}
	
	public void insertReserv(String loginId, String selectedDept, String selectedDoc, String dateStr, String treatReason) {
		try {
			pstmt28.setString(1, loginId);
			pstmt28.setString(2, selectedDept);
			pstmt28.setString(3, selectedDoc);
			pstmt28.setString(4, dateStr);
			pstmt28.setString(5, treatReason);
			int i = pstmt28.executeUpdate();
			if(i>0) {
				con.commit();
				System.out.println("���� ����!!");
			}else {
				System.out.println("���� ����..");
			}
		} catch (SQLException se) {
			pln("���� �߻�(5): " + se);
		}
	}
	
	public boolean deleteD_SCHE(String selectedDept, String selectedDoc, String dateStr) {
		try {
			pstmt29.setString(1, selectedDept);
			pstmt29.setString(2, selectedDoc);
			pstmt29.setString(3, dateStr);
			int i = pstmt29.executeUpdate();
			if(i>0) {
				con.commit();
				return true;
			}else {
				return false;
			}
		}catch(SQLException se) {
			pln("�����߻�se: " + se);
		}
		return false;
	}

	/////////////////////// ���Ό��� �Ƿ��� �����쿡�� ���� ///////////////////////	
	public boolean scheduleDel(String DEP_NAME, String DOC_NAME, String date) {
		try {
			pstmt23.setString(1, DEP_NAME);
			pstmt23.setString(2, DOC_NAME);
			pstmt23.setString(3, date);
			int i = pstmt23.executeUpdate();
			if(i>0) {
				con.commit();
				pln("������ ���� ����!");
				return true;
			}else {
				pln("������ ���� ����...");
				return false;
			}
		}catch(SQLException se) {
			pln("�����߻�(1): " + se);
			return false;
		}
	}
	/////////////////////// ������ҽ� �Ƿ��� ������ ���� ///////////////////////	
	public boolean scheduleRes(String DEP_NAME, String DOC_NAME, String date) {
		try {
			pstmt24.setString(1, DEP_NAME);
			pstmt24.setString(2, DOC_NAME);
			pstmt24.setString(3, date);
			int i = pstmt24.executeUpdate();
			if(i>0) {
				con.commit();
				pln("������ ���� ����!");
				return true;
			}else {
				pln("������ ���� ����...");
				return false;
			}
		}catch(SQLException se) {
			pln("�����߻�(1): " + se);
			return false;
		}
	}
	////////////////////// �ǰ��������� ���� ///////////////////////////////////////
	public void getSchedule(GUI gui) {
		SQL sq = new SQL();
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sq.SQL16);
			while (rs.next()) {
				String schedule = rs.getString(1);
				gui.phySelect_comB1.addItem(schedule);
			}
		}catch(SQLException se){
		}finally {
			try {
				if (rs != null) rs.close();
			} catch (SQLException se) {
			}
		} 
	}
	
	public void insertExam(String loginId, String selectedSchedule) {
		try {
			pstmt17.setString(1, loginId);
			pstmt17.setString(2, selectedSchedule);
			int i = pstmt17.executeUpdate();
			if(i>0) {
				con.commit();
				System.out.println("�ǰ����� ���� ����!!");
			}else {
				System.out.println("�ǰ����� ���� ����..");
			}
		} catch (SQLException se) {
			pln("se: "+se);
		}
	}
	public void examColumns() {
		SQL sq = new SQL();
		Vector<String> columnNames = new Vector<String>();
		Vector<Vector<String>> rowData = new Vector<>();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sq.SQL18);
			ResultSetMetaData rsmd = rs.getMetaData();
			columnNames.add("�˻��׸�");
			for(int i=1; i<=9; i++){
				Vector<String> vector = new Vector<String>();
				String cn = rsmd.getColumnName(i);
				vector.add(cn);
				rowData.add(vector);
			}
			dftmodel2.setDataVector(rowData, columnNames);		
		}catch(SQLException se) {
		}finally{
			try{
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se){				
			}
		}
	}

	public void showBox(String contents, String title) {
		JOptionPane.showMessageDialog(null, contents, title, JOptionPane.INFORMATION_MESSAGE);			
	}
	public void pln(String str) {
		System.out.println(str);
	}
	public void p(String str) {
		System.out.println(str);
	}
}
