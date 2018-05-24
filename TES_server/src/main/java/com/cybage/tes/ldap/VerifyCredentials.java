package com.cybage.tes.ldap;


import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VerifyCredentials {
	static DirContext ldapContext;
	public String validate(String username,String password,HttpServletRequest request) 
	{
		try{
			
			Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
			ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			ldapEnv.put(Context.PROVIDER_URL,  "ldap://ct-dc-1-1.cybage.com");
			ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
			String domain="@cybage.com"; 
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			ldapEnv.put(Context.SECURITY_PRINCIPAL, username.concat(domain));
			ldapEnv.put(Context.SECURITY_CREDENTIALS,password);
			ldapContext = new InitialDirContext(ldapEnv);
			return "Success";
		}catch(Exception e)
		{
			return "Invalid Username or Password";
		}		
	}
}
