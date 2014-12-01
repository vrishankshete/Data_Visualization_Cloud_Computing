import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class visualize {


	public static void main(String[] args) throws Exception {

		JSONParser JObj = new JSONParser();
		JSONObject j= (JSONObject) JObj.parse(new FileReader("/home/ubuntu/Cloud/sampleData_4.json"));

		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/ubuntu/Cloud/sample_4.csv"));
		JSONArray j1 = (JSONArray)j.get("fields");
		Iterator i = j1.iterator();
		int count=0;
		while(i.hasNext()){
			JSONObject inn = (JSONObject) i.next();
			String temp = inn.get("label").toString();
			temp = temp.substring(0, temp.indexOf("\n")==-1?temp.length():temp.indexOf("\n"));
			if(count==0){
				System.out.print(temp);
				bw.write(temp);
			}
			else{
				System.out.print("," + temp);
				bw.write("," + temp);
			}
			count++;
		}
		JSONArray data= (JSONArray) j.get("data");
		for(int k=0; k<data.size(); k++){
			JSONArray j2 = (JSONArray)data.get(k);
			System.out.println();
			bw.write("\n");
			for(int m=0; m<j2.size(); m++){
				if(m==0){
					System.out.print(j2.get(m));
					bw.write(j2.get(m).toString());
				}
				else{
					System.out.print(","+j2.get(m));
					bw.write(","+j2.get(m));
				}
			}
		}
		bw.close();
	}

}
