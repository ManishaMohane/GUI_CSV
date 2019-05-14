import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
/*
<applet code="ListDemo" width=1200 height=1000>
</applet>
*/
public class ListDemo extends Applet implements ActionListener {
//CSVReader csv1=new CSVReader();
//String count2[][];
//csv1.meth1();
final Font f=new Font("SansSerif",Font.BOLD,25);

Image picture;
List os;
String msg = "";
String count[][]=new String[30][];

        String csvFile = "D:/JavaProgram/Mobile_Spec.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
	

//***********************************************************************************************
public void init() {
Label one = new Label("MOBILE",Label.LEFT);
add(one);
//Label two = new Label("Specifications",Label.LEFT);
//add(two);
picture=getImage(getDocumentBase(),"csv_image2.jpeg");
setFont(f);
//setBackground(Color.pink);
setForeground(Color.blue);
os = new List(4, false);
try {
			int i=0;
			 
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
				count[i]=line.split(cvsSplitBy);
                //System.out.println(count[i][0]);
				i++;
            }
		System.out.println(count[2][5]);
		String asdf=count[2][2];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }
		
//****************************************************************
for(int x=1; x<=9; x++)
{
try{//String arry=count[0][1];
os.add(count[x][0]);
}
catch(Exception e){
	System.out.println("hsss");
}
}
add(os);

os.addActionListener(this);
}
//******************************************************************************************************
public void actionPerformed(ActionEvent ae) {
	
repaint();
}
//**********************************************************************************************

public void paint(Graphics g) {
g.drawImage(picture,60,60,this);
int idx[];
msg = "mobile details : ";
idx = os.getSelectedIndexes();
int id=idx[0];
id++;
int y=230;
for(int x=0; x<=7; x++)
{
	msg=count[0][x];
	msg+=":  "+count[id][x];
//	msg+="  ";

//for(int i=0; i<idx.length; i++)
//msg += os.getItem(idx[i]) + " ";

g.drawString(msg, 500,y );
y=y+50;
}
}
//*******************************************************************************************

}