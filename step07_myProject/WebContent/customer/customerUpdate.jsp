<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.updateForm;
		
	if ( f.headCount.value == "" ) {
		alert( "�ο��� �Է��� �ּ���." );
		return false;
	}
	if ( f.name.value == "" ) {
		alert( "�̸��� �Է��� �ּ���." );
		return false;
	}
	if ( f.pNumber.value == "" ) {
        alert( "��ȭ��ȣ�� �Է��� �ּ���" );
        return false;
    }
    return true;
}

</SCRIPT>
</HEAD>
<BODY>

<form name="updateForm" method="post" action="../customer?command=update" onSubmit='return checkValid()'>

<input type="hidden" name="command" value="update">
<input type="hidden" name="customerId" value="${param.customerId }">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="1">

    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#336699">
            <p align="center"><font color="white" size="3"><b>${param.customerId} �� ����</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">�ο���</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="headCount" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">��ȭ��ȣ</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
        <input type=text name="pNumber" size="50" maxlength = 15></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">&nbsp;</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=submit value=����> 
        <input type=reset value=�ٽþ���></span></b></td>
    </tr>
</table>

</form>

<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="../customer?command=list">����Ʈ�� ���ư���</a>&gt;</span></div>
</BODY>
</HTML>