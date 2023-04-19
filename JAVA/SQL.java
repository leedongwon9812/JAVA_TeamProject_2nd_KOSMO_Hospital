public class SQL {
	String SQL1 = "insert into PATIENT values(?, ?, ?, ?, ?, ?, ?)";
	String SQL2 = "select P_TEL from PATIENT where P_ID=? and P_PWD=?";
	String SQL3 = "select P_ID from PATIENT where P_ID=?";
	String SQL4 = "select P_ID from PATIENT where P_SSN=?";
	String SQL5 = "select P_ID from PATIENT where P_TEL=?";
	String SQL6 = "update PATIENT set P_PWD=? where P_ID=? and P_TEL=?";
	String SQL7 = "select P_ID from PATIENT where P_SSN=? and P_TEL=?";
	String SQL8 = "select DEP_NAME 진료과, DOC_NAME 의사명, DIS_NAME 진단명, TR_DATE 진료일시 from PATIENT natural join TREATM natural join DOCTOR where P_SSN=? and P_TEL=? order by TR_DATE desc";
	String SQL9 = "select DEP_NAME, DOC_NAME, DIS_NAME, TR_DATE from PATIENT natural join TREATM natural join DOCTOR where ? like '%' || ? || '%' and P_SSN=? and P_TEL=? order by TR_DATE desc";
	String SQL10 = "select DEP_NAME 진료과, DOC_NAME 의사명, R_DATE 예약일시 from PATIENT natural join DOCTOR natural join RESERV where P_SSN=? and P_TEL=?";
	String SQL11 = "select * from PATIENT where P_ID=? and P_SSN=? and P_TEL=?";
	String SQL13 = "select DOC_NAME from DOCTOR where DEP_NAME=?";
	String SQL14 = "select TR_DATE from D_SCHEDULE natural join DOCTOR where DOC_NAME=?";
	String SQL15 = "insert into RESERV values(RESERV_SEQ.nextval, ?, (select DOC_ID from DOCTOR where DEP_NAME=? and DOC_NAME=?), to_date(?, 'YYYY/MM/DD HH24:MI:SS'), ?)";
	String SQL16 = "select E_DATE from E_SCHEDULE";
	String SQL17 = "insert into E_RESERV values(?, to_date(?, 'YYYY/MM/DD HH24:MI:SS'))";
	String SQL18 = "select HEIGHT 신장, WEIGHT 체중, BP 혈압, FBS 공복혈당, HDL, LDL, CREA, AST, ALT from EXAM";
	String SQL19 = "select PR_DATE 처방일시, PR_NAME 처방명, DOSE 용량, DAYS 일수, NUM 횟수, DOC_NAME 처방의 from PRESC natural join PATIENT natural join DOCTOR where P_SSN=? and P_TEL=?";
	String SQL20 = "select E_DATE 검진일시, HEIGHT 신장, WEIGHT 체중, BP 혈압, FBS 공복혈당, HDL, LDL, CREA, AST, ALT from EXAM natural join PATIENT where P_SSN =? and P_TEL=?";
	String SQL21 = "select S_NAME 수술명, DIS_NAME 진단명, DOC_NAME 의사명, S_DATE 수술일시 from SURGERY natural join PATIENT natural join DOCTOR where P_SSN=? and P_TEL=?";
	String SQL23 = "delete from D_SCHEDULE where DOC_ID=(select DOC_ID from DOCTOR where DEP_NAME=? and DOC_NAME=?) and TR_DATE=to_date(?, 'YYYY/MM/DD HH24:MI:SS')";
	String SQL24 = "insert into D_SCHEDULE values((select DOC_ID from DOCTOR where DEP_NAME=? and DOC_NAME=?), to_date(?, 'YYYY/MM/DD HH24:MI:SS'))";
	String SQL26 = "select DOC_NAME from DOCTOR where DEP_NAME=?";
	String SQL27 = "select TR_DATE from D_SCHEDULE natural join DOCTOR where DOC_NAME=? order by TR_DATE asc";
	String SQL28 = "insert into RESERV values(RESERV_SEQ.nextval, ?, (select DOC_ID from DOCTOR where DEP_NAME=? and DOC_NAME=?), to_date(?, 'YYYY/MM/DD HH24:MI:SS'), ?)";
	String SQL29 = "delete from D_SCHEDULE where DOC_ID=(select DOC_ID from DOCTOR where DEP_NAME=? and DOC_NAME=?) and TR_DATE=to_date(?, 'YYYY/MM/DD HH24:MI:SS')";
	
}
	