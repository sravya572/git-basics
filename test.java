
import java.util.*;
class apriori
{
    public static int c2=0;
    void calculate(int x,int check[],int res1[][],int p,int arr[][],int n1,int t,int min_sup)
    {
        int z,res[][]=new int[50][10],y=0,count[],b[],h=0,i,j;
        boolean l=false;
        int c1=0;
		for (i = 0; i < (1<<p); i++)
        {
            z=0;
            for (j = 0; j <p  && check[j]!=0; j++)
            {
                if ((i & (1 << j)) > 0)
                {
                    res[i][z]=check[j];
                    z++;
                }
            }
            res1[i]=new int[x];
            if(z==x)
            {
                for(j=0;j<res[i].length && res[i][j]!=0;j++)
                res1[y][j]=res[i][j];
                y++;
            }
        }
        count=new int[y];
        b=new int[y];
        for(i=0;i<y;i++)
        {
            b[i]=0;
            for(int w=0;w<n1;w++)
            {
                for(j=0;j<res1[i].length;j++)
                {
                    l=false;
                    for(int v=0;v<t && v<=res1[i][j];v++)
                    {
                        if(res1[i][j]==arr[w][v])
                        {
                            l=true;
                            break;
                        }
                    }
                    if(l==false)
                    break;
                }
                if(l==true) b[i]++;
            }
            count[i]=b[i];
        }
        System.out.println("----------");
        c1=0;
        for(i=0;i<y;i++)
        {
            if(count[i]>=min_sup)
            {
            for(j=0;j<res1[i].length;j++)
            {
                System.out.print(res1[i][j]+" ");
            }
            c1++;
            c2++;
            System.out.print("count is:"+count[i]);
            System.out.println();
            }
        }
        System.out.println("no.of frequent data itemsets for size "+x+" is:"+c1);
    }
}
class test
{  
       public static void main(String[] args) 
       {
                Scanner sc=new Scanner(System.in);
                int arr[][],count[],check[]=new int[10],res1[][]=new int[50][],min_sup;
                int n,t,n1,z,x,h=0,p=0,i=0,j,k;
                System.out.println("enter no.of transaction:");
                n1=sc.nextInt();
                System.out.println("enter no.of items:");
                t=sc.nextInt();	
                System.out.println("enter absolute support:");
                min_sup=sc.nextInt();
                arr=new int[n1][t];
                System.out.println("enter data set:");
                for(i=0;i<n1;i++)
               {
                     for(j=0;j<t;j++)
                    {
                           arr[i][j]=sc.nextInt();
                     }
               }
		count=new int[t];
		for(i=0;i<n1;i++)
		{
		    k=0;
		    for(j=0;j<arr[i].length;j++)
		    {
		           if((k+1)==arr[i][j])
		           {
		           count[k]++;
		           }
		           k++;
		    }
		}
		for(k=0;k<t;k++)
		{
		    System.out.println((k+1)+" "+count[k]);
		    if(count[k]>=min_sup)
		    {
		        check[h]=(k+1);
		        h++;
		    }
		    p=h;
		}
		apriori a=new apriori();
		x=1;
		while(x<4)
		{
		    a.calculate(x,check,res1,p,arr,n1,t,min_sup);
            x++;
		}
            System.out.println("total no.of frequent data item sets are:"+apriori.c2);

	}
}
