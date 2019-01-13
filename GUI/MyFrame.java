package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MyFrame extends JFrame implements MouseListener
{

	public static void main(String[] args) 
	{
		new MyFrame();
	}

	public MyFrame() 
	{

		//Title our frame.
		super("Packman Game");


		// menu
		menuGame();

		BackgroundImageJFrame();


		//Set the size for the frame.
		setSize(1433,642); 
		//addMouseListener(this);
	

		//We need to turn on the visibility of our frame
		//by setting the Visible parameter to true.
		setVisible(true);


		//Now, we want to be sure we properly dispose of resources 
		//this frame is using when the window is closed.  We use 
		//an anonymous inner class adapter for this.
		addWindowListener(new WindowAdapter() 
		{public void windowClosing(Window e) 
		{dispose(); System.exit(0);}  
		}
				);
	}

	private void menuGame()
	{
		// create menu
		JMenuBar  menubar = new JMenuBar();
		setJMenuBar(menubar);

		//menu buttons
		JMenu myGame = new JMenu("Game");
		JMenu file = new JMenu("File");
		JMenu save = new JMenu("Save");

		// add buttons to the menu
		menubar.add(file);
		menubar.add(save);
		menubar.add(myGame);

		//"file" buttons
		JMenuItem csvOpen = new JMenuItem ("open csv");

		//"save" buttons
		JMenuItem csvSave = new JMenuItem ("save to csv");
		JMenuItem kmlSave = new JMenuItem ("save path to kml");

		// "myGame" buttons
		JMenuItem newGame = new JMenuItem ("create new game");

		//add buttons to "file" in the menu
		file.add(csvOpen);

		//add buttons to "save" in the menu
		save.add(csvSave);
		save.add(kmlSave);

		//add buttons to "myGame" in the menu
		myGame.add(newGame);

		//ActionListener build
		//---------------------------------------------------------
		class actcsvSave implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("save to csv");
			}

		}
		class actkmlSave implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("save to kml");
			}

		}
		class actcsvOpen implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("csv file open");
			}

		}
		class actnewGame implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("new game");
			}

		}
		//---------------------------------------------------------

		//add listener to item
		csvSave.addActionListener(new actcsvSave ());
		kmlSave.addActionListener(new actkmlSave ());
		csvOpen.addActionListener(new actcsvOpen ());
		newGame.addActionListener(new actnewGame());

	}


	private void BackgroundImageJFrame()
	{
		String imgFile="D:\\Users\\eli\\Documents\\ArielJAVAProjects\\Ex3\\pictures\\Ariel1.png";
		//	Map map = new Map(file);

		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(imgFile)));
		setLayout(new FlowLayout());
	}

	public void paint(Graphics g) 
	{
		super.paint(g);
		int high = this.getHeight(), width = this.getWidth();

		// packman
		g.setColor(Color.yellow);
		g.fillOval(width/2, high/2, 50, 50);
		// fruit
		g.setColor(Color.GREEN);
		g.fillOval(width/3, high/3, 25, 25);

	}

	//--------------------------------------------------------------------------
	// לחיצה עם העכבר
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	//	העכבר מעל אזור מסוים
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	// שהעכבר יצא מאזור מסוים
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub

	}




}
