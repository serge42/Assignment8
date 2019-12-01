package usi.se2019.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Session Bean implementation class UserBean
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
//	private User user;
	private int id;
	private String name;
	private String address;
	private String pwd_hash;
	
    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub
    }

    public String validate() {
    	
    	return "hello world";
    }
}
