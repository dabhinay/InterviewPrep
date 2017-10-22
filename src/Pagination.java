import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Pagination {
	
	static class Entry {
		int val;
		String str;
		Entry(int val, String str) {
			this.val = val;
			this.str = str;
		}
	}

	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String[] res;
        int num;
        num = Integer.parseInt(in.nextLine().trim());

        int results_size = 0;
        results_size = Integer.parseInt(in.nextLine().trim());

        String[] results = new String[results_size];
        for(int i = 0; i < results_size; i++) {
            String results_item;
            try {
                results_item = in.nextLine();
            } catch (Exception e) {
                results_item = null;
            }
            results[i] = results_item;
        }

        res = paginate(num, results);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
	

    static String[] paginate(int num, String[] results) {
        
        int size = results.length;
        System.out.println(num);
        
        ArrayList<Entry> entries = new ArrayList<>();
        for(int i =0; i< results.length; i++) {
            entries.add(new Entry(Integer.parseInt(results[i].split(",")[0]), results[i]));
        }
        String[] output = new String[size/num + size]; // fix edge case
        int currentVal = 0;
        
        Set<Integer> vals = new HashSet<>();
        
        int entriesAdded = 0;
        for(int i = 0; i < entries.size(); i++) {
            
            if(entriesAdded == num) {
                entriesAdded = 0;
                output[currentVal] = "";
                currentVal++;
                vals.clear();
                i = -1;
                continue;
            }
            
            if(!vals.contains(entries.get(i).val)) {               
                Entry tmp = entries.get(i);
                output[currentVal] = tmp.str;
                vals.add(tmp.val);
                currentVal++;
                entries.remove(i);
                i--;
                entriesAdded++;
                continue;
            }
            
            if((i == (entries.size()-1)) && (entries.size() > 0)) {
                Entry tmp = entries.get(0);
                output[currentVal] = tmp.str;
                currentVal++;
                entries.remove(0);
                i = 0;
                entriesAdded++;
            }
            
        }
      
        return output;
    }
	
	
}
