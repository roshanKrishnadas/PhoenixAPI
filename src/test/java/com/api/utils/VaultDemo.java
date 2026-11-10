package com.api.utils;

import java.util.Map;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;

public class VaultDemo {

	public static void main(String[] args) throws VaultException {
	//String a = System.getenv("VAULT_SERVER");
//	String b = System.getenv("VAULT_TOKEN");
	//	System.out.println( a + b);
		
		
		  VaultConfig vaultConfig=new VaultConfig();
		  vaultConfig.address("http://13.53.201.246:8200") .token("root") .build();
		  
		  Vault vault=new Vault(vaultConfig);
		  
		  LogicalResponse response =
		  vault.logical().read("secret/phoenix/qa/database");
		  
		  Map<String, String> data = response.getData();
		  System.out.println(data.get("DB_URL"));
		  System.out.println(data.get("DB_USERNAME"));
		  System.out.println(data.get("DB_PASSWORD"));
		 
				
	}

}
