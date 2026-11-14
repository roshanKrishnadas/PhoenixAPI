package com.api.utils;

import java.util.Map;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;

public class VaultDbConfig {

	private static VaultConfig vaultConfig;
	private static Vault vault;
	
	
	static {
		
			try {
				vaultConfig=new VaultConfig().address(System.getenv("VAULT_SERVER")).token(System.getenv("VAULT_TOKEN")).build();
			} catch (VaultException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
 
		 vault=new Vault(vaultConfig);
	}
	private VaultDbConfig() {
		
	}
	public static String getSecret(String key) {
LogicalResponse response=null;
try {
	response = vault.logical().read("secret/phoenix/qa/database");
} catch (VaultException e) {
	e.printStackTrace();
	return null;
}
		
		Map<String, String> data = response.getData();
		String secret=data.get(key);
		return secret;
	}
}
