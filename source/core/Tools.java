package core;

import java.util.Arrays;
import java.util.Set;

public class Tools {

	// ����� ��� ���������� ������ ����� � �����
	public static String toUpperCase(String str) {
		if (str != null && str.length()!=0) {
			String head = str.substring(0, 1);
			String body = str.substring(1);
			return head.toUpperCase() + body;
		} else return "...";
	}
	
	// ����� ��� ���������� �� ��������
	public static String[] sortOfAlphabet(Set<String> keys) {
		String[] FIO = new String[keys.size()];
		int i = 0;
		for (String key : keys) {
			FIO[i] = key;
			i++;
		}
		Arrays.sort(FIO);
		return FIO;
	}
	
	public static String delSpaces(String str) {
		str = str.replace(" ", "_");
		return str;
	}

}
