package core;

import java.util.HashMap;

import Persistance.connectDB;

import model.FactoryInitialize;
import model.Initialize;
import model.Remove;
import model.SaveMonthInfo;
import model.Search;
import model.Update;

public class Controller {

	private static Initialize initialize = FactoryInitialize.getInit();

	// ����� ��� ������ �����������, ��������������� �����
	public static HashMap<String, Integer> search(String mask) {
		HashMap<String, Integer> answer = new HashMap<String, Integer>();
		answer = Search.find(mask);
		return answer;
	}

	// ����� ��� ������ ���� �����������
	public static HashMap<String, Integer> searchAll() {
		HashMap<String, Integer> answer = new HashMap<String, Integer>();
		answer = Search.findAll();
		return answer;
	}

	// ����� ��� ���������� ����� ������ ����������
	public static void addCountLunch(int visitor_id, int count) {
		Update.addCountLunch(visitor_id, count);
		initialize.addLunch(visitor_id, count);
	}

	// ����� ��� ���������� ����� ������ ����������
	public static void addCountDinner(int visitor_id, int count) {
		Update.addCountDinner(visitor_id, count);
		initialize.addDinner(visitor_id, count);
	}

	// ����� ��� ��������� ���� ������
	public static void removeLunchs() {
		Remove.removeAllLunch();
		initialize.removeAllCountLunch();
	}

	// ����� ��� ��������� ���� ������
	public static void removeDinners() {
		Remove.removeAllDinner();
		initialize.removeAllCountDinner();
	}

	// ����� ��� ��������� ����� ������ � ����������
	public static void removeCountLunch(int visitor_id) {
		Remove.removeCountLunch(visitor_id);
		initialize.removeLunch(visitor_id);
	}

	// ����� ��� ��������� ����� ������ � ����������
	public static void removeCountDinner(int visitor_id) {
		Remove.removeCountDinner(visitor_id);
		initialize.removeDinner(visitor_id);
	}

	// ����� ��� �������� ����������
	public static void removeVisitor(int visitor_id) {
		Remove.removeVisitor(visitor_id);
		initialize.removeVisitor(visitor_id);
	}

	// ����� ��� ���������� ������ ����������
	public static void addNewVisitor(String firstname, String lastname,
			String middlename) {
		Update.addNewVisitor(firstname, lastname, middlename);
		initialize.addVisitor(firstname, lastname, middlename);
	}

	// ����� ��� ��������� ���������� � ���������� �� ��� id
	public static String[] getInfoByID(int visitor_id) {
		return Search.getInfoByID(visitor_id);
	}
	
	// ����� ��� ���������� �������� ����������
	public static boolean saveMonthInfo(String fileName) {
		HashMap<String, String> info = (HashMap<String, String>) connectDB.getInfoAboutAll();
		return SaveMonthInfo.addInfoInFile(fileName, info);
	}
	
	// ����� ��� ��������� ������ ��� ���������� ��������� ������
	public static String getErrorForSaveMonthInfo() {
		return SaveMonthInfo.getError();
	}
}
