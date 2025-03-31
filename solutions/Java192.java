// 192. Java Map

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        
        Map<String, Integer> phoneBook = new HashMap<>();
        
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            
            phoneBook.put(name, phone);
		}
        
		while(in.hasNext())
		{
			String query=in.nextLine();
            
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
		}
        
        in.close();
	}
}