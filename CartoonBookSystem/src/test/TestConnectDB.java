package test;

import utils.MySQLHelper;

public class TestConnectDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(MySQLHelper.open() != null) {
			System.out.println("Connected!");
		}else {
			System.out.println("Connection error!");
		}
		MySQLHelper.close();
	}

}
