package Entity;

public class Account {
private int AcountID;
private int isAdmin;
private String userName;
private String passWord;
private String fullname;
private String phone;
private String email;

    public Account() {
    }

      public Account( int isAdmin, String userName, String passWord, String fullname, String phone, String email) {
        
        this.isAdmin = isAdmin;
        this.userName = userName;
        this.passWord = passWord;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
    }
      
    public Account(int AcountID, int isAdmin, String userName, String passWord, String fullname, String phone, String email) {
        this.AcountID = AcountID;
        this.isAdmin = isAdmin;
        this.userName = userName;
        this.passWord = passWord;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
    }

    public int getAcountID() {
        return AcountID;
    }

    public void setAcountID(int AcountID) {
        this.AcountID = AcountID;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "AcountID=" + AcountID + ", isAdmin=" + isAdmin + ", userName=" + userName + ", passWord=" + passWord + ", fullname=" + fullname + ", phone=" + phone + ", email=" + email + '}';
    }



}