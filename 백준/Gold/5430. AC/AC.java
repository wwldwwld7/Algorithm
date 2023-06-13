import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1 ; tc<=T ; tc++) {
			sb.setLength(0);
			//R : 뒤집기, D : 버리기  //배열이 비어있는데 D를 사용하면 에러
			String str = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String str2 = br.readLine();
			int ll = str2.length();
			String[] str3 = str2.split(",");
			ArrayList<String> list = new ArrayList<>();
			for(int i=0 ; i<len ; i++) {
				if(len==1) {
					list.add(str3[0].substring(1, str3[len-1].length()-1));
				}
				else {
					if(i==0) {
						list.add(str3[0].substring(1));
					}
					else if(i==len-1) {
						list.add(str3[len-1].substring(0, str3[len-1].length()-1));
					}
					else {
						list.add(str3[i]);
					}
				}
			}
			String result = "true";
			boolean check = true; //true면 정방향, false이면 역방향
			for(int i=0 ; i<str.length() ; i++) {
				if(str.charAt(i)=='R') {
					check = !check;
				}
				else {
					if(list.size()!=0) {
						if(check)
							list.remove(0);
						else
							list.remove(list.size()-1);
					}
					else {
						result = "error";
						break;
					}
				}
			}
			if(result!="error") {
				sb.append("[");
				if(check) {
					for(int i=0 ; i<list.size() ; i++) {
						if(i==list.size()-1) sb.append(list.get(i));
						else sb.append(list.get(i)+",");
					}
				}
				else {
					for(int i=list.size()-1 ; i>=0 ; i--) {
						if(i==0) sb.append(list.get(i));
						else sb.append(list.get(i)+",");
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
			else System.out.println(result);
		}
	}
}