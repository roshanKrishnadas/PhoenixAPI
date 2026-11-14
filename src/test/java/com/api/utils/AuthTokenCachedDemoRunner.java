package com.api.utils;

import com.api.constant.Role;

public class AuthTokenCachedDemoRunner {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			String token=AuthTokenGenerator.getToken(Role.FD);
			System.out.println(token);
			
		}

	}

}
