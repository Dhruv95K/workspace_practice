package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeWay {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
		 int t  =Integer.parseInt(read.readLine());
		 
		while(t-->0)
		{
   		int N = Integer.parseInt(read.readLine());
   		ArrayList<Integer> A=new ArrayList<>();
   		int[] hash=new int[1000001];
   		Arrays.fill(hash,0);
   		
   		String str[] = read.readLine().trim().split(" ");
   		for(int i=0;i<N;i++)
   		{
   		    int val = Integer.parseInt(str[i]);
   		    A.add(i,val);
   		
   		    hash[A.get(i)]++;
		    }
		    
		    str = read.readLine().trim().split(" ");
   		int n = Integer.parseInt(str[0]);
   		int m = Integer.parseInt(str[1]);
		
   		ArrayList<Integer> B=new ArrayList<>();
   		for(int i=0;i<A.size();i++)
   		{
   			B.add(i,A.get(i));
   		}
           int k1=0,k2=0,k3=0;
           int kk1=0;int kk2=0;int kk3=0;
           for(int i=0;i<B.size();i++)
           {
           	if(B.get(i)>m)
           	{
           		k3++;
           	}else if(B.get(i)<=m && B.get(i)>=n)
           	{
           		k2++;
           	}else if(B.get(i)<m)
           	k1++;
           }
           ThreeWay g = new ThreeWay();
   		ArrayList<Integer> Res = g.threeWayPartition(A,n,m);
         	for(int i=0;i<k1;i++)
         	{
         		if(Res.get(i)<m)
         		kk1++;
         	}
         	for(int i=k1;i<k1+k2;i++)
         	{
         		
         		if(Res.get(i)<=m && Res.get(i)>=n)
         		kk2++;
         		
         	}
         	for(int i=k1+k2;i<k1+k2+k3;i++)
         	{
         		if(Res.get(i)>m)
         		kk3++;
         	}
         	boolean ok = false;
         	if(k1==kk1 && k2 ==kk2 && k3 == kk3)
         	ok = true;
   	
   	    for(int i=0;i<Res.size();i++)
         		hash[Res.get(i)]--;
         	
         	for(int i=0;i<Res.size();i++)
         	if(hash[Res.get(i)]!=0)
         	ok=false;
         	
       	if(ok)
       		System.out.println(1);
       		else
       		System.out.println(0);
       		}
	}
	
	
	public ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int a, int b)
	{
        //add code here.
       /* if(a>b)
            return 0;*/
            
        int lo=0,mid=0,hi=A.size()-1;
        for(mid=0;mid<=hi;) {
        	if(A.get(mid)<a) {
        		swap(A,mid,lo);
        		mid++;
        		lo++;
        	}
        	else if(A.get(mid)>b) {
        		swap(A,hi,mid);
        		hi--;
        	}
        	else
        		mid++;
        }
        return A;
    }


	private void swap(ArrayList<Integer> a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a.get(i);
		a.set(i,a.get(j));
		a.set(j, temp);
	}

}
