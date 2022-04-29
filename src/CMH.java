import java.io.*;
public class CMH {
    public static int flag=0;
    public static void main(String args[])throws Exception
    {
        BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
        int init,column,row,x=0,sites=7  ; //total number of processes

        File input=new File("Graph.txt");
        BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(input)));
        String line;
        int[][] a=new int[sites][sites];
        boolean[][] dependentArr= new boolean[sites][sites];

        line=in.readLine();line=in.readLine();
        while((line=in.readLine())!=null)
        {column=3;row=4;
            for(int y=0 ; y<sites ; y++)
            {
                a[x][y]=Integer.parseInt(line.substring(column,row));
                column+=2;row+=2;
            }
            x++;
        }
        in.close();
        System.out.println("____________________________________________________________");System.out.println();
        System.out.println(" CHANDY-MISRA-HAAS DISTRIBUTED DEADLOCK DETECTION ALGORITHM");System.out.println();
        System.out.println(" GLOBAL WFG Graph--->");System.out.println();
        System.out.println("\tP1\tP2\tP3\tP4\tP5\tP6\tP7");
        for(int i=0 ; i<sites ; i++)
        {
            System.out.print("P"+(i+1)+"\t");
            for(int j=0 ; j<sites ; j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println();System.out.print("Enter Initiator Process No. : ");
        init=Integer.parseInt(ob.readLine());

        while(init<1 || init> sites)  //Valid inputs decision
        {
            System.out.print(" -- Ensure to enter valid values from 1 to 7 only --  : ");
            init=Integer.parseInt(ob.readLine());
        }

//start of Algorithm
        int j=init-1;
        System.out.println();System.out.println();
        System.out.println(" DIRECTION\t\tPROBE");System.out.println();

//Probe Started
        for (int k=0 ; k<sites; k++)
        {
            if(a[j][k]==1)
            {
                System.out.println(" P"+(j+1)+" --> P"+(k+1)+"     ("+init+","+(j+1)+","+(k+1)+")");
                dependentArr[k][j] = true;
                sendProbe(a,j,k, dependentArr);  //recursive call
            }
        }
        if(flag==1){System.out.println();System.out.println(" --- DEADLOCK DETECTED ---");}
        if(flag==0){System.out.println();System.out.println(" --- NO DEADLOCK DETECTED ---");}
        System.out.println("____________________________________________________________");
    }

    public static void sendProbe(int[][] a, int init, int k, boolean[][] dependentArr) {
        int sites = 7;
        for (int x = 0; x < sites; x++) {
            if (a[k][x] == 1) {
                if (init == x) {
                    System.out.println(" P" + (k + 1) + " --> P" + (x + 1) + "     (" + (init + 1) + "," + (k + 1) + "," + (x + 1) + ")" + "  **** DEADLOCK DETECTED ****");
                    flag = 1;
                    break;
                }

                System.out.println(" P" + (k + 1) + " --> P" + (x + 1) + "     (" + (init + 1) + "," + (k + 1) + "," + (x + 1) + ")");
                if(dependentArr[x][k] == true)
                {
                    System.out.println("# CYCLE DETECTED #");
                    if (flag==1)
                    {
                        break;
                    }
                    else
                    {
                        flag = 0;
                        break;
                    }
                }
                else
                {
                    dependentArr[x][k] = true;
                }
                if (dependentArr[k][x]) {
                    if (dependentArr[k][x] == dependentArr[x][k])    ///cycle detection
                    {
                        System.out.println("# CYCLE DETECTED #");
                        if (flag==1)
                        {
                            // do nothing
                        }
                        else{
                            flag = 0;
                            continue;
                        }


                    }
                }
                sendProbe(a, init, x, dependentArr);
            }
        }
    }
}

