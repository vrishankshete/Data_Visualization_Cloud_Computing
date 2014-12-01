import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class visualize_data {


	public static void main(String[] args) throws Exception {

		JSONParser JObj = new JSONParser();
		JSONObject j= (JSONObject) JObj.parse(new FileReader("/home/ubuntu/Cloud/sampleData_2.json"));

		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/ubuntu/Cloud/sample_2.csv"));
		String[][] arr = new String[20][20]; 
		JSONArray data= (JSONArray) j.get("data");
		int m=0,k=0;
		for(k=0; k<data.size(); k++){
			JSONArray j2 = (JSONArray)data.get(k);
			
			for(m=0; m<j2.size(); m++){
				if(m==0){
					arr[k][m]=j2.get(m).toString();
					System.out.print(j2.get(m));
					bw.write(j2.get(m).toString());
				}
				else{
					arr[k][m]=j2.get(m).toString();
					System.out.print(","+j2.get(m));
					bw.write(","+j2.get(m));
				}
			}
			System.out.println();
			bw.write("\n");
		}/*
		for(int x=0; x<m; x++){
			for(int y=0; y<k; y++){
				if(y==0){
					
					System.out.print(arr[y][x]);
					bw.write(arr[y][x]);
				}
				else{
					System.out.print(","+arr[y][x]);
					bw.write(","+arr[y][x]);
				}
				//System.out.print("  " + arr[y][x]);
			}
			System.out.println();
			bw.write("\n");
		}*/
		bw.close();
		
	}

}
