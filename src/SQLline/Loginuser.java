package SQLline;

public class Loginuser {
boolean loginSuccess =false;
String id;
String password;

public void setID(String id) {
	this.id=id;
}

public void setPassWord(String password) {
	this.password=password;
}

public String getID() {
	return id;
}

public String getPassWord() {
	return password;
}

public void setLoginSuccess(boolean bo) {
	loginSuccess=bo;
}

public boolean getLoginSuccess() {
	return loginSuccess;
}
}
